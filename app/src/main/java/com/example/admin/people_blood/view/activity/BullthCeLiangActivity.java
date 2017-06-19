package com.example.admin.people_blood.view.activity;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;
import com.example.admin.people_blood.utils.ToastUtils;
import com.example.admin.people_blood.view.view1.ChangZhuView;
import com.example.admin.people_blood.xueyua.BluetoothMsg;
import com.example.admin.people_blood.xueyua.ChatMessage;
import com.example.admin.people_blood.xueyua.CommonAttr;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 项目名称: 血压宝
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/15 23:10
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class BullthCeLiangActivity extends BaseActivity {
    @Bind(R.id.lanya_cl_zhuangtai)
    ImageView lanyaClZhuangtai;
    @Bind(R.id.lanya_islianjie)
    TextView lanyaIslianjie;
    @Bind(R.id.lanya_tu)
    ChangZhuView lanyaTu;
    @Bind(R.id.lanya_btn)
    Button lanyaBtn;
    private boolean ispeizdui;//是否已经配对 如果没没有配对 就开始扫描
    private boolean isbtn;//用来判断当前是连接还是测量
    private ProgressDialog progressDialog;//连接的dialog
    private Context mContext;
    private BluetoothAdapter mBluetoothAdapter; // Bluetooth适配器
    public static BluetoothDevice device;             // 蓝牙设备
    private ArrayList<ChatMessage> list;
    private BluetoothSocket socket;     // 客户端socket
    private ClientThread mClientThread; // 客户端运行线程
    private ReadThread mReadThread;   // 读取流线程
    public static byte[] bytes1 = {(byte) 0xEB, 0x21, (byte) 0xf4, (byte) 0xEB};

    private Handler sendHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            sendMessageHandler(bytes1);
            sendHandler.sendEmptyMessageDelayed(1, 250);
        }
    };

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        if (mBluetoothAdapter != null) {
            mBluetoothAdapter.cancelDiscovery();
            // 关闭蓝牙
            mBluetoothAdapter.disable();
        }
        unregisterReceiver(mReceiver);
        closeClient();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_butllth_celiang;
    }

    @Override
    protected void initView() {
        mContext = this;
        progressDialog = new ProgressDialog(this);
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        list = new ArrayList<ChatMessage>();
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(mReceiver, filter);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void listener() {

    }


    @OnClick({R.id.lanya_cl_zhuangtai, R.id.lanya_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lanya_cl_zhuangtai:
                finish();
                break;
            case R.id.lanya_btn:
                if (!isbtn) {
                    if (!mBluetoothAdapter.isEnabled()) {
                        Toast.makeText(this, "蓝牙未开启", Toast.LENGTH_SHORT).show();
                        Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        startActivityForResult(enableIntent, 1);
                    } else {
                        progressDialog.show();
                        //获取已经配对过的设备
//                        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
//                        if (pairedDevices.size() > 0) {
//                            for (BluetoothDevice pairedDevice : pairedDevices) {
//                                if (pairedDevice.getName().equals("KBB3-1")) {
//                                    device = mBluetoothAdapter.getRemoteDevice(pairedDevice.getAddress());
//                                    mClientThread = new ClientThread();
//                                    mClientThread.start();
//                                    BluetoothMsg.isOpen = true;
//                                    ispeizdui = true;
//                                }
//                            }
//                        }
//                        if(!ispeizdui){
                        mBluetoothAdapter.startDiscovery();
//                        }
                    }
                } else {
                    mReadThread = new ReadThread();
                    mReadThread.start();
                    sendMessageHandler(CommonAttr.Sphygmomanometer.START_MEASURE);
                    sendHandler.sendEmptyMessageDelayed(1, 250);

                }


                break;
        }
    }


    /**
     * 蓝牙设备扫描过程中(mBluetoothAdapter.startDiscovery())会发出的消息
     * ACTION_FOUND 扫描到远程设备
     * ACTION_DISCOVERY_FINISHED 扫描结束
     */
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            // When discovery finds a device
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                // Get the BluetoothDevice object from the Intent
                // 通过EXTRA_DEVICE附加域来得到一个BluetoothDevice设备
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                // If it's already paired, skip it, because it's been listed already
                // 如果这个设备是不曾配对过的，添加到list列表
//                if (device.getBondState() != BluetoothDevice.BOND_BONDED) {
//                    list.add(new ChatMessage(device.getName() + "\n" + device.getAddress(), false));
                Log.e("TAGNAME", "蓝牙名字---" + device.getName());
                if (device.getName().equals("KBB3-1")) {
                    BullthCeLiangActivity.device = mBluetoothAdapter.getRemoteDevice(device.getAddress());
                    mClientThread = new ClientThread();
                    mClientThread.start();
                    BluetoothMsg.isOpen = true;
                    ispeizdui = true;
                }
//                }
                // When discovery is finished, change the Activity title
            } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                setProgressBarIndeterminateVisibility(false);
                list.add(new ChatMessage("没有发现蓝牙设备", false));
                LinkDetectedHandler.sendEmptyMessage(113);
            }
        }
    };


    // Handler更新UI
    private Handler LinkDetectedHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            //Toast.makeText(mContext, (String)msg.obj, Toast.LENGTH_SHORT).show();
//            if (msg.what == 1) {
//                list.add(new ChatMessage((String) msg.obj, true));
//            } else {
//                list.add(new ChatMessage((String) msg.obj, false));
//            }
            switch (msg.what) {
                case 112:
                    progressDialog.dismiss();
                    ToastUtils.showShortToast("连接异常,请重新连接");
                    isbtn = false;
                    lanyaBtn.setText("点击连接");
                    lanyaIslianjie.setText("未连接");
                    break;
                case 113:
                    Toast.makeText(mContext, "没有扫描到设备", Toast.LENGTH_SHORT).show();
                    break;
            }

        }

    };
    // 当连接上服务器的时候才可以选择发送数据和断开连接
    private Handler refreshUI = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
//                disconnect.setEnabled(true);
//                sendButton.setEnabled(true);
//                editText.setEnabled(true);
                progressDialog.dismiss();
                isbtn = true;
                lanyaBtn.setText("点击测量");
                lanyaIslianjie.setText("已连接");
            }
        }
    };


    // 开启客户端连接服务端
    private class ClientThread extends Thread {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            if (device != null) {
                try {
                    //00001101-0000-1000-8000-00805F9B34FB
                    socket = device.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));
                    // 连接
//                    Message msg = new Message();
//                    msg.obj = "请稍候，正在连接服务器: " + BluetoothMsg.BlueToothAddress;
//                    msg.what = 0;
//                    LinkDetectedHandler.sendMessage(msg);
//                     通过socket连接服务器，这是一个阻塞过程，直到连接建立或者连接失效
                    socket.connect();

//                    Message msg2 = new Message();
//                    msg2.obj = "已经连接上服务端！可以发送信息";
//                    msg2.what = 0;
//                    LinkDetectedHandler.sendMessage(msg2);

                    // 更新UI界面
                    Message uiMessage = new Message();
                    uiMessage.what = 0;
                    refreshUI.sendMessage(uiMessage);

                    // 可以开启读数据线程

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    // socket.connect()连接失效
                    Log.e("TAGNAME", "连接异常---" + e.getMessage());
                    Message msg = new Message();
                    msg.obj = "连接服务端异常！断开连接重新试一试。";
                    msg.what = 112;
                    LinkDetectedHandler.sendMessage(msg);
                }
            }
        }

        HashMap map = new HashMap();
    }

    // 通过socket获取InputStream流
    private class ReadThread extends Thread {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            byte[] buffer = new byte[1024];
            int bytes;
            InputStream is = null;
            try {
                is = socket.getInputStream();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            while (true) {

                try {
                    if ((bytes = is.read(buffer)) > 0) {
                        byte[] data = new byte[bytes];
                        for (int i = 0; i < data.length; i++) {
                            data[i] = buffer[i];
                            byte b = data[i];

                        }
                        //-21,33,64,0,0,0,-116,0,89,0,71,-120,-21,
                        StringBuffer fs = new StringBuffer();

                        for (int i = 0; i < data.length; i++) {

                            fs.append(data[i] + ",");
                        }
                        Log.e("TAGNAME", "设备----" + fs.toString() + "");

                        String s = new String(data);
                        Log.i("TAGNAME", "abc------" + s);
                        Log.e("TAGNAME", "s---" + s);
                        Message msg = new Message();
                        msg.obj = s;
                        msg.what = 1;
                        LinkDetectedHandler.sendMessage(msg);
                    } else {

                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    try {
                        is.close();
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    // 发送数据
    private void sendMessageHandler(byte[] msg) {
        if (socket == null) {
            Toast.makeText(mContext, "没有可用的连接", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            OutputStream os = socket.getOutputStream();
            os.write(msg);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//        list.add(new ChatMessage(msg.toString(), false));

    }

    // 停止服务
    private void closeClient() {
        new Thread() {
            public void run() {
                if (mClientThread != null) {
                    mClientThread.interrupt();
                    mClientThread = null;
                }
                if (mReadThread != null) {
                    mReadThread.interrupt();
                    mReadThread = null;
                }
                try {
                    if (socket != null) {
                        socket.close();
                        socket = null;
                    }
                } catch (IOException e) {
                    // TODO: handle exception
                }
            }
        }.start();
    }

    // 扫描设备
    private void scanDevice() {
        // TODO Auto-generated method stub
        if (mBluetoothAdapter.isDiscovering()) {
            mBluetoothAdapter.cancelDiscovery();
        } else {
            list.clear();

            // 每次扫描前都先判断一下是否存在已经配对过的设备
            Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
            if (pairedDevices.size() > 0) {
                for (BluetoothDevice device : pairedDevices) {
                    list.add(new ChatMessage(device.getName() + "\n" + device.getAddress(), true));
                }
            } else {
                list.add(new ChatMessage("No devices have been paired", true));
            }
            /* 开始搜索 */
            mBluetoothAdapter.startDiscovery();
        }
    }


}

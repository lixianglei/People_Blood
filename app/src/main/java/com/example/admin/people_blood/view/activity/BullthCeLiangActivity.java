package com.example.admin.people_blood.view.activity;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
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
import java.util.Set;
import java.util.UUID;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名称: 血压宝
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/15 23:10
 * 修改人:
 * 修改内容:蓝牙测量的类
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
    private ChangZhuView yuanView;
    int[] addssy = {150, 130, 180, 120, 180};
    int[] addszy = {90, 110, 80, 50, 150};
    int count;
    int zhang;
    private boolean isfalse;
    public static byte[] bytes1 = {(byte) 0xEB, 0x21, (byte) 0xf4, (byte) 0xEB};

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 11:
                    if (count < 5) {
                        yuanView.setXueYa(addssy[count], addszy[count]);
                        count++;
                        handler.sendEmptyMessageDelayed(11, 2000);
                    } else {
//                count=0;
//                yuanView;
                    }
                    break;
                case 22:
                    sendMessageHandler(bytes1);
                    handler.sendEmptyMessageDelayed(22, 250);
                    break;
                case 33:
                    int[] ss = (int[]) msg.obj;
                    int aa = ss[0];

                    lanyaTu.setXueYa(Math.abs(aa), ss[1]);
                    break;
                case 44:
                    if (!isfalse) {
                        if (zhang < 150) {
                            lanyaTu.setXueYa(zhang, zhang);
                            zhang++;
                            handler.sendEmptyMessageDelayed(44, 200);

                        } else {
                            isfalse=true;
                        }

                    } else {

                        zhang--;
                        lanyaTu.setXueYa(zhang, zhang);
                        handler.sendEmptyMessageDelayed(44, 200);

                    }


                    break;
            }

        }

    };
    private IntentFilter filter;

    @Override
    protected int layoutId() {
        return R.layout.activity_butllth_celiang;
    }

    @Override
    protected void initView() {
        zhang = 1;
        mContext = this;
        progressDialog = new ProgressDialog(this);
        //通过蓝牙获得适配器
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        list = new ArrayList<ChatMessage>();
        filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(mReceiver, filter);
        handler.sendEmptyMessageDelayed(1, 2000);
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
                lanyaTu.stopCeliang();
                break;
            case R.id.lanya_btn:
                if (!isbtn) {
                    if (!mBluetoothAdapter.isEnabled()) {
                        Toast.makeText(this, "蓝牙未开启", Toast.LENGTH_SHORT).show();
                        Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        startActivityForResult(enableIntent, 1);
                    } else {
                        progressDialog.setTitle("正在连接");
                        progressDialog.show();
                        mBluetoothAdapter.startDiscovery();
                    }
                } else {
                    mReadThread = new ReadThread();
                    mReadThread.start();
                    handler.sendEmptyMessageDelayed(44, 200);
                    sendMessageHandler(CommonAttr.Sphygmomanometer.START_MEASURE);
                    handler.sendEmptyMessageDelayed(22, 250);
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
                Log.e("TAGNAME", "蓝牙名字---" + device.getName());
                //通过配对蓝牙的名来进行连接
                if (device.getName().equals("KBB3-1")) {
                    BullthCeLiangActivity.device = mBluetoothAdapter.getRemoteDevice(device.getAddress());
                    mClientThread = new ClientThread();
                    mClientThread.start();
                    BluetoothMsg.isOpen = true;
                    ispeizdui = true;
                }
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
                progressDialog.dismiss();
                isbtn = true;
                lanyaBtn.setText("点击测量");
//                Intent   intent=new Intent(BullthCeLiangActivity.this,YuanZhuTwoActivity.class);
//                startActivity(intent);
                lanyaIslianjie.setText("已连接");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    // 开启客户端连接服务端
    private class ClientThread extends Thread {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            if (device != null) {
                try {
                    mBluetoothAdapter.cancelDiscovery();
                    //用UUID获取一个socket连接；
                    //00001101-0000-1000-8000-00805F9B34FB
                    socket = device.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));
                    // 连接
//                    Message msg = new Message();
//                    msg.obj = "请稍候，正在连接服务器: " + BluetoothMsg.BlueToothAddress;
//                    msg.what = 0;
//                    LinkDetectedHandler.sendMessage(msg);
//                     通过socket连接服务器，这是一个阻塞过程，直到连接建立或者连接失效
                    socket.connect();
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

    }

    // 连接以后通过socket来获取InputStream流
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
                    //设备-----21,33,-128,0,-113,0,0,0,0,0,0,-27,-21,
                    if ((bytes = is.read(buffer)) > 0) {
                        byte[] data = new byte[bytes];
                        for (int i = 0; i < data.length; i++) {
                            data[i] = buffer[i];
                            byte b = data[i];
                            //把byte转化为bit（二进制）;
                            Log.e("ReadThread", byteToBit(b));
                            String b2 = byteToBit(b);
                            Log.e("ReadThread", "第一位--" + b2.substring(1, b2.length() - 1));
//                            if(b2.substring(0))
                        }
                        int[] xin = new int[3];
                        StringBuffer fs = new StringBuffer();
                        for (int i = 0; i < data.length; i++) {
                            fs.append(data[i] + " ");
                            if (i == 6) {
                                if (data[i] != 0) {

                                    Log.e("TAGNAME", "哈哈哈");
                                    xin[0] = data[i];
                                }
                            }
                            if (i == 8 && data[i] != 0) {
                                xin[1] = data[i];
                            }
                            if (i == 10 && data[i] != 0) {
                                xin[2] = data[i];
                            }

                        }


                        Log.e("TAGNAME", "设备----" + fs.toString() + "");
                        if (xin[0] != 0) {
                            handler.removeMessages(44);
                            isfalse = false;
                            Message message = new Message();
                            message.obj = xin;
                            message.what = 33;
                            handler.sendMessage(message);
                        }

                        String s = new String(data);
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

    // 此方法是停止服务哦；
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
            /**
             开始搜索 */
            mBluetoothAdapter.startDiscovery();
        }
    }

    /**
     * 关闭蓝牙设备
     */
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

    //    /**
//     * 这个方法是将byte转bit对象时
//     */
    public static String byteToBit(byte b) {
        return "" + (byte) ((b >> 7) & 0x1) +
                (byte) ((b >> 6) & 0x1) +
                (byte) ((b >> 5) & 0x1) +
                (byte) ((b >> 4) & 0x1) +
                (byte) ((b >> 3) & 0x1) +
                (byte) ((b >> 2) & 0x1) +
                (byte) ((b >> 1) & 0x1) +
                (byte) ((b >> 0) & 0x1);
    }
}

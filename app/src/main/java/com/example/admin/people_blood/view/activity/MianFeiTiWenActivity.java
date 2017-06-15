package com.example.admin.people_blood.view.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MianFeiTiWenActivity extends BaseActivity  {

    @Bind(R.id.update_back)
    ImageView updateBack;
    @Bind(R.id.askDocotor_Editext)
    EditText askDocotorEditext;
    @Bind(R.id.imageView)
    ImageView imageView;
    @Bind(R.id.MyText)
    TextView MyText;
    @Bind(R.id.MainActivity_Button1)
    RadioButton MainActivityButton1;
    @Bind(R.id.MainActivity_Button2)
    RadioButton MainActivityButton2;
    @Bind(R.id.Edit)
    EditText Edit;
    @Bind(R.id.TiJiao_ShuJu)
    Button TiJiaoShuJu;
    private PopupWindow mPopup;
    private View view;
    //自定义的弹出框类
    //调用系统相册-选择图片
    private static final int IMAGE = 1;
    private View inflate;
    private TextView choosePhoto;
    private TextView takePhoto;
    private Dialog dialog;
    private ImageView image;
    @Override
    protected int layoutId() {
        return R.layout.activity_wendoctor;
    }

    @Override
    protected void initView() {
        view = LayoutInflater.from(MianFeiTiWenActivity.this).inflate(R.layout.bootm_tanchu, null);
        mPopup = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        mPopup.setBackgroundDrawable(new ColorDrawable());
//        activityTiwen = (NumEditText) findViewById(R.id.activity_tiwen);
//        activityTiwen.setEtHint("内容")//设置提示文字
//                .setEtMinHeight(200)//设置最小高度，单位px
//                .setLength(100 / 1)//设置总字数
//                .setType(AnFQNumEditText.PERCENTAGE) //TextView显示类型(SINGULAR单数类型)(PERCENTAGE百分比类型)
//                .setLineColor("#3F51B5")//设置横线颜色
//                .show();

    }
    private void show(){
        dialog = new Dialog(this,R.style.ActionSheetDialogStyle);
        //填充对话框的布局
        inflate = LayoutInflater.from(this).inflate(R.layout.bootm_tanchu, null);
        //初始化控件
        image= (ImageView) findViewById(R.id.XianShi_Photo);
        choosePhoto = (TextView) inflate.findViewById(R.id.choosePhoto);
        takePhoto = (TextView) inflate.findViewById(R.id.takePhoto);
        choosePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, IMAGE);
                Toast.makeText(MianFeiTiWenActivity.this, "在相册选择", Toast.LENGTH_SHORT).show();
            }
        });
        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 1);
                Toast.makeText(MianFeiTiWenActivity.this, "拍照", Toast.LENGTH_SHORT).show();

            }
        });
        //将布局设置给Dialog
        dialog.setContentView(inflate);
        //获取当前Activity所在的窗体
        Window dialogWindow = dialog.getWindow();
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity( Gravity.BOTTOM);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 20;//设置Dialog距离底部的距离
//       将属性设置给窗体
        dialogWindow.setAttributes(lp);
        dialog.show();//显示对话框
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        //获取图片路径
        if ((requestCode == IMAGE) && (resultCode == Activity.RESULT_OK) && (data != null)) {
            Uri selectedImage = data.getData();
            String[] filePathColumns = {MediaStore.Images.Media.DATA};
            Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
            c.moveToFirst();
            int columnIndex = c.getColumnIndex(filePathColumns[0]);
            String imagePath = c.getString(columnIndex);
            showImage(imagePath);
            c.close();
        }
        if (resultCode == Activity.RESULT_OK) {
            String sdStatus = Environment.getExternalStorageState();
            if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
                Log.i("TestFile",
                        "SD card is not avaiable/writeable right now.");
                return;
            }
            String name = new DateFormat().format("yyyyMMdd_hhmmss",Calendar.getInstance(Locale.CHINA)) + ".jpg";
            Toast.makeText(this, name, Toast.LENGTH_LONG).show();
            Bundle bundle = data.getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");// 获取相机返回的数据，并转换为Bitmap图片格式

            FileOutputStream b = null;
            //???????????????????????????????为什么不能直接保存在系统相册位置呢？？？？？？？？？？？？
            File file = new File("/sdcard/myImage/");
            file.mkdirs();// 创建文件夹
            String fileName = "/sdcard/myImage/"+name;

            try {
                b = new FileOutputStream(fileName);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    b.flush();
                    b.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            ((ImageView) findViewById(R.id.XianShi_Photo)).setImageBitmap(bitmap);// 将图片显示在ImageView里
        }
    }
    //加载图片
    private void showImage(String imaePath){
        Bitmap bm = BitmapFactory.decodeFile(imaePath);
        ((ImageView)findViewById(R.id.XianShi_Photo)).setImageBitmap(bm);
    }

    @Override
    protected void loadData() {

    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        //获取图片路径
//        if ((requestCode == IMAGE) && (resultCode == Activity.RESULT_OK) && (data != null)) {
//            Uri selectedImage = data.getData();
//            String[] filePathColumns = {MediaStore.Images.Media.DATA};
//            Cursor c = getContentResolver().query(selectedImage, filePathColumns, null, null, null);
//            c.moveToFirst();
//            int columnIndex = c.getColumnIndex(filePathColumns[0]);
//            String imagePath = c.getString(columnIndex);
//            showImage(imagePath);
//            c.close();
//        }
//    }


    @Override
    protected void listener() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.update_back, R.id.askDocotor_Editext, R.id.MainActivity_Button1, R.id.MainActivity_Button2, R.id.Edit, R.id.TiJiao_ShuJu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.update_back:
                break;
            case R.id.askDocotor_Editext:
                break;
            case R.id.MainActivity_Button1:
                break;
            case R.id.MainActivity_Button2:
                break;
            case R.id.Edit:
                break;
            case R.id.TiJiao_ShuJu:
                Toast.makeText(this, "服务器有点问题，请稍后在提交", Toast.LENGTH_SHORT).show();
                break;
        }
    }
//    @Override
//    public void onClick(View v) {
//        switch (view.getId()){
//            case R.id.takePhoto:
//                Toast.makeText(this,"点击了拍照",Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.choosePhoto:
//                Toast.makeText(this,"点击了从相册选择",Toast.LENGTH_SHORT).show();
//                break;
//        }
//        dialog.dismiss();
//    }
}

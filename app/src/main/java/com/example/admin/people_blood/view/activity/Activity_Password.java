package com.example.admin.people_blood.view.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by d on 2017/6/12.
 */

public class Activity_Password extends BaseActivity {
    @Bind(R.id.left_image)
    ImageView leftImage;
    @Bind(R.id.left_layout)
    RelativeLayout leftLayout;
//    @Bind(R.id.Yijian_FanKui)
//    TextView YijianFanKui;
    @Bind(R.id.Edit_pass)
    EditText EditPhone;
    @Bind(R.id.ShuRu)
    TextView ShuRu;
    @Bind(R.id.Edit_PassOne)
    EditText EditPassword;
    @Bind(R.id.EditText_layout)
    LinearLayout EditTextLayout;
    @Bind(R.id.Login_Btn)
    Button LoginBtn;

    @Override
    protected int layoutId() {
        return R.layout.activity_password;
    }

    @Override
    protected void initView() {
        showListDialog();

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void listener() {
    }

    private void showListDialog() {
        final EditText et = new EditText(this);

        new AlertDialog.Builder(this).setTitle("验证密码")
                .setMessage("验证原密码，更新密码前，请输入旧密码来保证您的账户安全")
                .setView(et)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String input = et.getText().toString();
                        if (input.equals("")) {
                            Toast.makeText(getApplicationContext(), "请输入密码" + input, Toast.LENGTH_LONG).show();
                        }
                        else {
                            Intent intent = new Intent();
                            intent.putExtra("content", input);
//                            intent.setClass(Activity_Password.this, Activity_Password.class);
                            startActivity(intent);
                        }
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String string=et.getText().toString();
                        if(string.equals("")){
                            Intent intent=new Intent();
                            intent.setClass(Activity_Password.this,Activity_ZhangHu.class);
                            startActivity(intent);
                        }
                    }
                })
                .show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}

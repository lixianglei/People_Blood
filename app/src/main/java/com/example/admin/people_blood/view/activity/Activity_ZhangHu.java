package com.example.admin.people_blood.view.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.id.input;

/**
 * Created by d on 2017/6/12.
 */

public class Activity_ZhangHu extends BaseActivity {
    @Bind(R.id.left_image)
    ImageView leftImage;
    @Bind(R.id.left_layout)
    RelativeLayout leftLayout;
    @Bind(R.id.Yijian_FanKui)
    TextView YijianFanKui;
    @Bind(R.id.Text_Phone)
    TextView TextPhone;
    @Bind(R.id.Phone)
    LinearLayout Phone;
    @Bind(R.id.Text_Password)
    TextView TextPassword;
    @Bind(R.id.Password)
    LinearLayout Password;
    @Bind(R.id.TuiChuDengLu)
    Button TuiChuDengLu;

    @Override
    protected int layoutId() {
        return R.layout.activity_zhanghu;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void listener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.left_image, R.id.Phone, R.id.Password,R.id.TuiChuDengLu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.left_image:
                finish();
                break;
            case R.id.Phone:
                Intent intent = new Intent(this, Activity_Phone.class);
                startActivity(intent);
                break;
            case R.id.Password:
                Intent intent1 = new Intent(this, Activity_Password.class);
                startActivity(intent1);
                break;
            case R.id.TuiChuDengLu:
                showListDialog();
                break;
        }
    }
    private void showListDialog() {

        new AlertDialog.Builder(this).setTitle("退出登录")
                .setMessage("退出不会删除任何数据，下次登录可以使用本账号")
//                .setView(et)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent();
                            intent.putExtra("content", input);
                            intent.setClass(Activity_ZhangHu.this, LoginActivity.class);
                            startActivity(intent);
                        }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        }
                })
                .show();
    }

}

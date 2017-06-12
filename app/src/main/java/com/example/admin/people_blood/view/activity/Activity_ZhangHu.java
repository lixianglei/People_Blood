package com.example.admin.people_blood.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    @OnClick({R.id.left_image, R.id.Phone, R.id.Password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.left_image:
                finish();
                break;
            case R.id.Phone:
                Intent intent=new Intent(this,Activity_Phone.class);
                startActivity(intent);
                break;
            case R.id.Password:
                Intent intent1=new Intent(this,Activity_Password.class);
                startActivity(intent1);
                break;
        }
    }

}

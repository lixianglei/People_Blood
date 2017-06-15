package com.example.admin.people_blood.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;
import com.example.admin.people_blood.utils.UserUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by d on 2017/6/12.
 */

public class Activity_Phone extends BaseActivity {
    @Bind(R.id.left_image)
    ImageView leftImage;
    @Bind(R.id.left_layout)
    RelativeLayout leftLayout;
    @Bind(R.id.Yijian_FanKui)
    TextView YijianFanKui;
    @Bind(R.id.Text_Phone)
    TextView TextPhone;
    @Bind(R.id.Phong_Btn)
    Button PhongBtn;
    private String num;

    @Override
    protected int layoutId() {
        return R.layout.phone;
    }

    @Override
    protected void initView() {
        num = UserUtils.getUSERPHONENUM();
        TextPhone.setText(num);

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

    @OnClick(R.id.Phong_Btn)
    public void onViewClicked() {
        Intent intent=new Intent(getApplicationContext(),YanZheng_Ma.class);
        startActivity(intent);
        finish();
    }
}

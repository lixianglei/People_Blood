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
 * Created by d on 2017/6/10.
 */

public class Activity_SheZhi extends BaseActivity {

    @Bind(R.id.left_image)
    ImageView leftImage;
    @Bind(R.id.left_layout)
    RelativeLayout leftLayout;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.ZhangHu)
    LinearLayout ZhangHu;
    @Bind(R.id.Clear)
    LinearLayout Clear;
    @Bind(R.id.AboutBoold)
    TextView AboutBoold;
    @Bind(R.id.About_Blood)
    LinearLayout AboutBlood;

    @Override
    protected int layoutId() {
        return R.layout.shezhi_activity;
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

    @OnClick({R.id.left_image, R.id.ZhangHu, R.id.Clear, R.id.About_Blood})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.left_image:
                finish();
                break;
            case R.id.ZhangHu:
                break;
            case R.id.Clear:
                break;
            case R.id.About_Blood:
                Intent intent=new Intent(this,Activity_About_Boold.class);
                startActivity(intent);
                break;
        }
    }
}

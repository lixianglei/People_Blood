package com.example.admin.people_blood.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by d on 2017/6/12.
 */

public class Activity_MessageFanKui extends BaseActivity {
    @Bind(R.id.left_image)
    ImageView leftImage;
    @Bind(R.id.left_layout)
    RelativeLayout leftLayout;
    @Bind(R.id.Yijian_FanKui)
    TextView YijianFanKui;
    @Bind(R.id.Message_fasong)
    TextView MessageFasong;
    @Bind(R.id.Medit)
    EditText Medit;

    @Override
    protected int layoutId() {
        return R.layout.yijianfankui_activity;
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

    @OnClick({R.id.left_image, R.id.Message_fasong})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.left_image:
                finish();
                break;
            case R.id.Message_fasong:
                if (Medit.getText().toString().isEmpty()){
                    Toast.makeText(this, "内容不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "发送成功", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}

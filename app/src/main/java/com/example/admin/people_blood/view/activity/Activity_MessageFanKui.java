package com.example.admin.people_blood.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

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
    @Bind(R.id.custom_edit)
    AnFQNumEditText customEdit;
    //    @Bind(R.id.Yijian_FanKui)
//    TextView YijianFanKui;
//    @Bind(R.id.Message_fasong)
//    TextView MessageFasong;
//    @Bind(R.id.Medit)
//    EditText Medit;

    @Override
    protected int layoutId() {
        return R.layout.yijianfankui_activity;
    }

    @Override
    protected void initView() {
        customEdit = (AnFQNumEditText) findViewById(R.id.custom_edit);
        customEdit.setEtHint("内容")//设置提示文字
                .setEtMinHeight(200)//设置最小高度，单位px
                .setLength(100 / 1)//设置总字数
                .setType(AnFQNumEditText.PERCENTAGE) //TextView显示类型(SINGULAR单数类型)(PERCENTAGE百分比类型)
//                .setLineColor("#3F51B5")//设置横线颜色
                .show();
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
//                if (customEdit.getText().toString().isEmpty()) {
//                    Toast.makeText(this, "内容不能为空", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(this, "发送成功", Toast.LENGTH_SHORT).show();
//                }
                break;
        }
    }

}

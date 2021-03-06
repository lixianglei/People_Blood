package com.example.admin.people_blood.view.activity;

import android.os.Bundle;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by d on 2017/6/12.
 */

public class Activity_TiWen extends BaseActivity {
    @Bind(R.id.activity_tiwen)
    NumEditText activityTiwen;

    @Override
    protected int layoutId() {
        return R.layout.activity_tiwen;
    }

    @Override
    protected void initView() {
        activityTiwen = (NumEditText) findViewById(R.id.activity_tiwen);
        activityTiwen.setEtHint("内容")//设置提示文字
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
}

package com.example.admin.people_blood.view.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MianFeiTiWenActivity extends BaseActivity {

    @Bind(R.id.activity_tiwen)
    NumEditText activityTiwen;
    private PopupWindow mPopup;

    private View view;
    @Override
    protected int layoutId() {
        return R.layout.activity_tiwen;
    }
    @Override
    protected void initView() {
        view = LayoutInflater.from(MianFeiTiWenActivity.this).inflate(R.layout.photo_dialog, null);
        mPopup = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        mPopup.setBackgroundDrawable(new ColorDrawable());
//        activityTiwen = (NumEditText) findViewById(R.id.activity_tiwen);
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

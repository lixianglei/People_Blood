package com.example.admin.people_blood.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.admin.people_blood.App;
import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;

import butterknife.OnClick;

public class WenYiShengActivity extends BaseActivity {


    @Override
    protected int layoutId() {
        return R.layout.wenyisheng;
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
    @OnClick({R.id.image_Back, R.id.Wen_Btn, R.id.TiWen_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_Back:
                finish();
                break;
            case R.id.Wen_Btn:
                Intent intent=new Intent(App.baseActivity,MianFeiTiWenActivity.class);
                startActivity(intent);
                break;
            case R.id.TiWen_layout:
                Intent  intent1=new Intent(App.baseActivity,MianFeiTiWenActivity.class);
                startActivity(intent1);
                break;
        }
    }
}

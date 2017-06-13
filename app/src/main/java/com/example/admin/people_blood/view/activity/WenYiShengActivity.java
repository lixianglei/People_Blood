package com.example.admin.people_blood.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.people_blood.App;
import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WenYiShengActivity extends BaseActivity {


    @Bind(R.id.Center_Text)
    TextView CenterText;
    @Bind(R.id.image_Back)
    ImageView imageBack;
    @Bind(R.id.Wen_Btn)
    ImageView WenBtn;
    @Bind(R.id.TiWen_layout)
    LinearLayout TiWenLayout;

    @Override
    protected int layoutId() {
        return R.layout.wenyisheng;
    }

    @Override
    protected void initView() {
        CenterText.setText("问医生");
    }

    @Override
    protected void loadData() {

    }

    //
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
                Intent intent = new Intent(App.baseActivity, MianFeiTiWenActivity.class);
                startActivity(intent);
                break;
            case R.id.TiWen_layout:
                Intent intent1 = new Intent(App.baseActivity, MianFeiTiWenActivity.class);
                startActivity(intent1);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}

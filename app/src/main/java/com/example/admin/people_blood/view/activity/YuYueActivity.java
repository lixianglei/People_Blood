package com.example.admin.people_blood.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.people_blood.App;
import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YuYueActivity extends BaseActivity {

private Intent intent;
    @Bind(R.id.image_Back)
    ImageView imageBack;
    @Bind(R.id.Center_Text)
    TextView CenterText;
    @Bind(R.id.Doctor_Image)
    ImageView DoctorImage;
    @Bind(R.id.Doctor_Name)
    TextView DoctorName;
    @Bind(R.id.Doctor_KeShi)
    TextView DoctorKeShi;
    @Bind(R.id.Doctor_JiBie)
    TextView DoctorJiBie;
    @Bind(R.id.Doctor_Hosptial)
    TextView DoctorHosptial;
    @Bind(R.id.Doctor_Content)
    TextView DoctorContent;
    @Override
    protected int layoutId() {
        return R.layout.activity_yu_yue;
    }

    @Override
    protected void initView() {
        initData();
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void listener() {

    }



    @OnClick(R.id.image_Back)
    public void onViewClicked() {
        finish();
    }
    private void initData() {
        intent = getIntent();
        String image = intent.getStringExtra("app_image");
        String doc_name = intent.getStringExtra("doc_name");
        String doc_title = intent.getStringExtra("doc_title");
        String doc_teach = intent.getStringExtra("doc_teach");
        String doc_hospital = intent.getStringExtra("doc_hospital");
        String doc_content = intent.getStringExtra("doc_content");
        String doc_depart = intent.getStringExtra("doc_depart");
        DoctorName.setText(doc_name);
        CenterText.setText("预约专家");
        DoctorHosptial.setText(doc_hospital);
        DoctorJiBie.setText(doc_title);
        DoctorContent.setText(doc_content);
        DoctorKeShi.setText(doc_depart);
        Glide.with(App.baseActivity).load(image).into(DoctorImage);
    }
}

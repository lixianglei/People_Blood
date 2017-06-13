package com.example.admin.people_blood.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.people_blood.App;
import com.example.admin.people_blood.R;
import com.example.admin.people_blood.adapter.MyFragmentAdapter;
import com.example.admin.people_blood.base.BaseActivity;
import com.example.admin.people_blood.base.BaseFragment;
import com.example.admin.people_blood.view.fragment.HuiFuFragment;
import com.example.admin.people_blood.view.fragment.SharedFragment;
import com.example.admin.people_blood.view.fragment.TimeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DoctorDetailActivity extends BaseActivity {

    @Bind(R.id.Doctor_Image)
    ImageView DoctorImage;
    @Bind(R.id.Doctor_Name)
    TextView DoctorName;
    @Bind(R.id.Doctor_YiYuan)
    TextView DoctorYiYuan;
    @Bind(R.id.Doctor_JiBie)
    TextView DoctorJiBie;
    @Bind(R.id.Doctor_KeShi)
    TextView DoctorKeShi;
    @Bind(R.id.Doctor_ZhiCheng)
    TextView DoctorZhiCheng;
    @Bind(R.id.center)
    LinearLayout center;
    @Bind(R.id.Doctor_Content)
    TextView DoctorContent;
    @Bind(R.id.DoctorDetail_TabLayout)
    TabLayout DoctorDetailTabLayout;
    @Bind(R.id.DoctorDetail_Viewpager)
    ViewPager DoctorDetailViewpager;
    @Bind(R.id.image_Back)
    ImageView imageBack;
    @Bind(R.id.Center_Text)
    TextView CenterText;
    private Intent intent;
   private List<BaseFragment>   fragments;
    private List<String>  strings;
    private MyDetailAdapter  mAdapter;
    @Override
    protected int layoutId() {
        return R.layout.activity_doctor_detail;
    }

    @Override
    protected void initView() {
         initData();
        fragments=new ArrayList<>();
        strings=new ArrayList<>();
       DoctorDetailTabLayout.setTabMode(TabLayout.MODE_FIXED);
        fragments.add(new HuiFuFragment());
        fragments.add(new TimeFragment());
        fragments.add(new SharedFragment());
        strings.add("专家回复");
        strings.add("出诊时间表");
        strings.add("专家经验分享");
        mAdapter=new MyDetailAdapter(getSupportFragmentManager());
        DoctorDetailViewpager.setAdapter(mAdapter);
        DoctorDetailTabLayout.setupWithViewPager(DoctorDetailViewpager);
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
        CenterText.setText(doc_name);
        DoctorYiYuan.setText(doc_hospital);
        DoctorJiBie.setText(doc_title);
        DoctorZhiCheng.setText(doc_teach);
        DoctorContent.setText(doc_content);
        DoctorKeShi.setText(doc_depart);
        Glide.with(App.baseActivity).load(image).into(DoctorImage);
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
    class   MyDetailAdapter extends FragmentStatePagerAdapter{

        public MyDetailAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return strings.get(position);
        }
    }
}

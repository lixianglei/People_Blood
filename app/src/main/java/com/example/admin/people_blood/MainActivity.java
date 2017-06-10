package com.example.admin.people_blood;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.admin.people_blood.adapter.MyFragmentAdapter;
import com.example.admin.people_blood.base.BaseActivity;
import com.example.admin.people_blood.base.BaseFragment;
import com.example.admin.people_blood.view.fragment.BloodManagerFragment;
import com.example.admin.people_blood.view.fragment.DoctorLineFragment;
import com.example.admin.people_blood.view.fragment.PersonCenterFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.Title_Text)
    TextView TitleText;
    @Bind(R.id.Main_ViewPager)
    ViewPager MainViewPager;
    @Bind(R.id.Main_Tablayout)
    TabLayout MainTablayout;
    @Bind(R.id.activity_main)
    RelativeLayout activityMain;
    private List<BaseFragment> fragments;
    private List<String> strings;
    private MyFragmentAdapter fragmentAdapter;

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        TitleText.setText("医生在线");
        fragments = new ArrayList<>();
        strings = new ArrayList<>();
        fragments.add(new DoctorLineFragment());
        fragments.add(new BloodManagerFragment());
        fragments.add(new PersonCenterFragment());
        strings.add("医生在线");
        strings.add("血压管理");
        strings.add("个人中心");
        MainTablayout.setTabMode(TabLayout.MODE_FIXED);
        fragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(), fragments, strings);
        MainViewPager.setAdapter(fragmentAdapter);
        //Tablayout自定义view绑定ViewPager
        MainViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(MainTablayout));
        MainTablayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(MainViewPager));
        MainTablayout.setupWithViewPager(MainViewPager);
        MainTablayout.getTabAt(0).setCustomView(tab_icon(strings.get(0), R.drawable.doctorline));
        MainTablayout.getTabAt(1).setCustomView(tab_icon(strings.get(1), R.drawable.booldmanager));
        MainTablayout.getTabAt(2).setCustomView(tab_icon(strings.get(2), R.drawable.personcenter));

    }

    private View tab_icon(String name, int iconID) {
        View newtab = LayoutInflater.from(this).inflate(R.layout.tablayout_item, null);
        TextView tv = (TextView) newtab.findViewById(R.id.tablayout_text);
        tv.setText(name);
        ImageView im = (ImageView) newtab.findViewById(R.id.tablayout_image);
        im.setImageResource(iconID);
        return newtab;
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

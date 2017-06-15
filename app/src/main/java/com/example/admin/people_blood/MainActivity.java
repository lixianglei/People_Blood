package com.example.admin.people_blood;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    @Bind(R.id.linetitle_bar)
    LinearLayout linetitleBar;
    @Bind(R.id.Main_ViewPager)
    ViewPager MainViewPager;
    @Bind(R.id.Main_Tablayout)
    TabLayout MainTablayout;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;
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
        MainTablayout.getTabAt(0).setCustomView(tab_icon(strings.get(0), R.drawable.doctor_head_press));
        MainTablayout.getTabAt(1).setCustomView(tab_icon(strings.get(1), R.drawable.booldmanager));
        MainTablayout.getTabAt(2).setCustomView(tab_icon(strings.get(2), R.drawable.personcenter));
        MainTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            //最后加载的
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    //医生在线
                    case 0:
                        linetitleBar.setVisibility(View.VISIBLE);
                        TitleText.setText("医生在线");
                        ImageView imageView3 = (ImageView) MainTablayout.getTabAt(0).getCustomView().findViewById(R.id.tablayout_image);
                        imageView3.setImageResource(R.drawable.doctor_head_press);
                        break;
                    //血压管理
                    case 1:
                        linetitleBar.setVisibility(View.VISIBLE);
                        TitleText.setText("血压管理");
//                        MainTablayout.getTabAt(1).setCustomView(tab_icon(strings.get(1), R.drawable.blood_manger_press));
                        ImageView imageView = (ImageView) MainTablayout.getTabAt(1).getCustomView().findViewById(R.id.tablayout_image);
                        imageView.setImageResource(R.drawable.blood_manger_press);
                        break;
                    //个人中心
                    case 2:
                        linetitleBar.setVisibility(View.GONE);
                        ImageView imageView2 = (ImageView) MainTablayout.getTabAt(2).getCustomView().findViewById(R.id.tablayout_image);
                        imageView2.setImageResource(R.drawable.persional_press);
                        break;

                }
            }

            //上一个
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    //医生在线
                    case 0:

                        ImageView imageView3 = (ImageView) MainTablayout.getTabAt(0).getCustomView().findViewById(R.id.tablayout_image);
                        imageView3.setImageResource(R.drawable.doctor_head_normal);
                        break;
                    //血压管理
                    case 1:
//                        MainTablayout.getTabAt(1).setCustomView(tab_icon(strings.get(1), R.drawable.blood_manger_normal));
                        ImageView imageView = (ImageView) MainTablayout.getTabAt(1).getCustomView().findViewById(R.id.tablayout_image);
                        imageView.setImageResource(R.drawable.blood_manger_normal);
                        break;
                    //个人中心
                    case 2:
                        ImageView imageView2 = (ImageView) MainTablayout.getTabAt(2).getCustomView().findViewById(R.id.tablayout_image);
                        imageView2.setImageResource(R.drawable.persional_normal);
                        break;

                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Log.d("MainActivity", "onTabReselected" + tab.getTag());
                Log.d("MainActivity", "onTabReselected" + tab.getContentDescription());
                Log.d("MainActivity", "onTabReselected" + tab.getPosition());
            }
        });

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

package com.example.admin.people_blood.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.admin.people_blood.base.BaseFragment;

import java.util.List;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/9 20:58
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class MyFragmentAdapter extends FragmentStatePagerAdapter {
    private List<BaseFragment>  fragments;
    private List<String>  strings;

    public MyFragmentAdapter(FragmentManager fm, List<BaseFragment> fragments, List<String> strings) {
        super(fm);
        this.fragments = fragments;
        this.strings = strings;
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

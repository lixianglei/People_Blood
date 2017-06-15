package com.example.admin.people_blood.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseFragment;
import com.example.admin.people_blood.kechengbiao.TimeTableModel;
import com.example.admin.people_blood.kechengbiao.TimeTableView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/12 14:34
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class TimeFragment extends BaseFragment {
    @Bind(R.id.main_timetable_ly)
    TimeTableView mTimaTableView;

    private List<TimeTableModel> mList;
    @Override
    protected int ViewID() {
        return R.layout.time;
    }

    @Override
    protected void initView() {
        mList = new ArrayList<TimeTableModel>();
        addList();
        mTimaTableView.setTimeTable(mList);

    }

    @Override
    protected void loadData() {
    }

    @Override
    protected void listener() {
    }

    private void addList() {
        mList.add(new TimeTableModel(0, 1, 1, 1, "你猜",
                "王老师", "1", "2-3"));
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}

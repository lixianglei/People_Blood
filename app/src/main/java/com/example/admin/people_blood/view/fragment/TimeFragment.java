package com.example.admin.people_blood.view.fragment;

import android.content.Intent;
import android.util.Log;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseFragment;
import com.example.admin.people_blood.bean.TimeBean;
import com.example.admin.people_blood.presenter.cyy.TimePresenter;
import com.example.admin.people_blood.view.view1.KeChengBiaoView;
import com.example.admin.people_blood.view.view1.TimeView;

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

public class TimeFragment extends BaseFragment implements TimeView{

    @Bind(R.id.main_timetable_ly)
    KeChengBiaoView mainTimetableLy;
     private List<TimeBean.DataBean.ScheduleBean.RdtimeBean>  mList=new ArrayList<>();
   private TimePresenter  timePresenter;
    private Intent  intent;
    private String  document_id;
    @Override
    protected int ViewID() {
        return R.layout.time;
    }

    @Override
    protected void initView() {
        intent=getActivity().getIntent();

        document_id=intent.getStringExtra("document_id");
        Log.i("sd",document_id);
  timePresenter=new TimePresenter(this);

    }

    @Override
    protected void loadData() {
         timePresenter.time(document_id);
    }

    @Override
    protected void listener() {
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
    @Override
    public void time(List<TimeBean.DataBean.ScheduleBean.RdtimeBean> been) {
              Log.i("sd", been.get(0).getTitle());
//        String  str=been.get(0).getTitle();
        for (TimeBean.DataBean.ScheduleBean.RdtimeBean rdtimeBean : been) {
            String title = rdtimeBean.getTitle();
            String substring = title.substring(11, 14);
            String substring1 = title.substring(15, 17);
            Log.i("sd",substring);
            Log.i("sd",substring1);
            mainTimetableLy.setSunDay(substring,substring1);
        }
    }
}

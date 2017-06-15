package com.example.admin.people_blood.presenter.cyy;

import com.example.admin.people_blood.bean.TimeBean;
import com.example.admin.people_blood.modle.biz.cyy.ITimeModel;
import com.example.admin.people_blood.modle.biz.cyy.TImeImpl;
import com.example.admin.people_blood.modle.callback.HttpCallBack;
import com.example.admin.people_blood.view.view1.TimeView;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/15 21:33
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class TimePresenter {
   private ITimeModel  timeModel;
    private TimeView  timeView;

    public TimePresenter(TimeView timeView) {
        timeModel=new TImeImpl();
        this.timeView = timeView;
    }
    public   void  time(String id){
        timeModel.time(id, new HttpCallBack() {
            @Override
            public void onSuccess(Object object) {
                TimeBean  bean = (TimeBean) object;
                timeView.time(bean.getData().getSchedule().getRdtime());
            }
        });
    }
}

package com.example.admin.people_blood.presenter.cyy;

import com.example.admin.people_blood.bean.YuYueBean;
import com.example.admin.people_blood.modle.biz.cyy.IYuYueImpl;
import com.example.admin.people_blood.modle.biz.cyy.YuYueImpl;
import com.example.admin.people_blood.modle.callback.HttpCallBack;
import com.example.admin.people_blood.view.view1.YuYueView;

import java.util.List;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/13 15:27
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class YuYuePresenter {
//      void yuyue(String expertid,String id);
     private IYuYueImpl yuYue;
     private YuYueView  yuYueView;
    public YuYuePresenter(YuYueView yuYueView) {
        yuYue=new YuYueImpl();
        this.yuYueView = yuYueView;
    }
    public  void yuYue(String expertid,String id){
        yuYue.yuyue(expertid, id, new HttpCallBack() {
            @Override
            public void onSuccess(Object object) {
              YuYueBean  bean= (YuYueBean) object;
                List<YuYueBean.DataBean.ScheduleBean.RdtimeBean> rdtime = bean.getData().getSchedule().getRdtime();
                   yuYueView.yuyue(rdtime);
            }
        });
    }
}

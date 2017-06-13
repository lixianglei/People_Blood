package com.example.admin.people_blood.presenter.cyy;

import com.example.admin.people_blood.bean.ReMenDoctorBean;
import com.example.admin.people_blood.modle.biz.cyy.IReMenModel;
import com.example.admin.people_blood.modle.biz.cyy.ReMenImpl;
import com.example.admin.people_blood.modle.callback.HttpCallBack;
import com.example.admin.people_blood.view.view1.IReMenView;

import java.util.List;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/12 10:35
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ReMenPresenter {
    private IReMenModel  reMenModel;
    private IReMenView   reMenView;

    public ReMenPresenter(IReMenView reMenView) {
        reMenModel=new ReMenImpl();
        this.reMenView = reMenView;
    }
    public  void  remen(){
        reMenModel.remen(String.valueOf(reMenView.page()), new HttpCallBack() {
            @Override
            public void onSuccess(Object object) {
               ReMenDoctorBean  bean= (ReMenDoctorBean) object;
                List<ReMenDoctorBean.DataBean> data = bean.getData();
                reMenView.remen(data);
            }

            @Override
            public void onFailure(String message) {
                super.onFailure(message);
            }
        });
    }
}

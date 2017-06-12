package com.example.admin.people_blood.presenter.cyy;

import com.example.admin.people_blood.bean.SharedBean;
import com.example.admin.people_blood.modle.biz.cyy.ISharedModel;
import com.example.admin.people_blood.modle.biz.cyy.SharedImpl;
import com.example.admin.people_blood.modle.callback.HttpCallBack;
import com.example.admin.people_blood.view.view1.SharedView;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/12 16:25
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class SharedPresenter {
     private ISharedModel  sharedModel;
    private SharedView  sharedView;

    public SharedPresenter(SharedView sharedView) {
        sharedModel=new SharedImpl();
        this.sharedView = sharedView;
    }
    public  void shared(String id){
        sharedModel.shared(id, new HttpCallBack() {
            @Override
            public void onSuccess(Object object) {
              SharedBean  sharedBean= (SharedBean) object;
                sharedView.shared(sharedBean.getData());
            }
        });
    }
}

package com.example.admin.people_blood.presenter.cyy;

import android.util.Log;
import android.widget.Toast;

import com.example.admin.people_blood.App;
import com.example.admin.people_blood.bean.ChaXunZhuanJiaBean;
import com.example.admin.people_blood.modle.biz.cyy.ChaXunModelImpl;
import com.example.admin.people_blood.modle.biz.cyy.IChaXunModel;
import com.example.admin.people_blood.modle.callback.HttpCallBack;
import com.example.admin.people_blood.view.view1.ChaXunView;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/12 07:48
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ChaXunPresenter {
    private IChaXunModel   chaXunModel;
    private ChaXunView  chaXunView;
    public ChaXunPresenter(ChaXunView chaXunView) {
       chaXunModel=new ChaXunModelImpl();
        this.chaXunView = chaXunView;
    }

    public   void  chaxun(){
          chaXunModel.chaxun("", "", "10", "1", "", "", new HttpCallBack() {
              @Override
              public void onSuccess(Object object) {
               ChaXunZhuanJiaBean  bean= (ChaXunZhuanJiaBean) object;
                  List<ChaXunZhuanJiaBean.DataBean> data = bean.getData();
                  chaXunView.chaxun(data);
                  chaXunView.doctorNum(bean.getTotal());
              }

              @Override
              public void onFailure(String message) {
                  super.onFailure(message);
                  Toast.makeText(App.baseActivity, "dsadsads"+message, Toast.LENGTH_SHORT).show();
                  Log.i("集合",message);
              }
          });

    }
}

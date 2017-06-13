package com.example.admin.people_blood.presenter.cyy;

import com.example.admin.people_blood.bean.HuiFuBean;
import com.example.admin.people_blood.modle.biz.cyy.HuiFuImpl;
import com.example.admin.people_blood.modle.biz.cyy.IHuiFuModel;
import com.example.admin.people_blood.modle.callback.HttpCallBack;
import com.example.admin.people_blood.view.view1.HuiFuView;

import java.util.List;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/12 15:01
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class HuiFuPresenter {
       private IHuiFuModel   huiFuModel;
       private HuiFuView  huiFuView;

    public HuiFuPresenter(HuiFuView huiFuView) {
        huiFuModel=new HuiFuImpl();
        this.huiFuView = huiFuView;
    }
    public  void  huifu(String expertid, String pageNum){
          huiFuModel.huifu(expertid, pageNum, new HttpCallBack() {
              @Override
              public void onSuccess(Object object) {
                HuiFuBean   bean = (HuiFuBean) object;
                  List<HuiFuBean.DataBean> data = bean.getData();
                  huiFuView.huifu(data);
              }
          });
    }
}

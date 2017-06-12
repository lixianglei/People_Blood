package com.example.admin.people_blood.presenter;

import com.example.admin.people_blood.bean.GaoXueYaZiXun;
import com.example.admin.people_blood.biz.GaoXueYaBiz;
import com.example.admin.people_blood.biz.GaoXueYaBizImpl;
import com.example.admin.people_blood.modle.callback.HttpCallBack;
import com.example.admin.people_blood.view.xueyaguanli.GaoXueXueYaActivityImpl;

/**
 * 项目名称: 血压宝
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/11 20:55
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class GaoXueYaActivityPresenter {
    private GaoXueYaBiz gaoXueYaBiz;
    private GaoXueXueYaActivityImpl gaoXueXueYaActivity;

    public GaoXueYaActivityPresenter(GaoXueXueYaActivityImpl gaoXueXueYaActivity) {
        this.gaoXueXueYaActivity = gaoXueXueYaActivity;
        gaoXueYaBiz = new GaoXueYaBizImpl();
    }

    public void getHttp() {
        gaoXueYaBiz.getHttp(gaoXueXueYaActivity.getTypeid(), gaoXueXueYaActivity.getDir(), new HttpCallBack() {
            @Override
            public void onSuccess(Object object) {
                GaoXueYaZiXun gaoXueYaZiXun = (GaoXueYaZiXun) object;
                gaoXueXueYaActivity.getSucc(gaoXueYaZiXun);
            }

            @Override
            public void onFailure(String message) {
                gaoXueXueYaActivity.getFal(message);
            }
        });
    }

}

package com.example.admin.people_blood.presenter;

import com.example.admin.people_blood.bean.GaoXueYaDetil;
import com.example.admin.people_blood.biz.WenZhangBiz;
import com.example.admin.people_blood.biz.WenZhangBizImpl;
import com.example.admin.people_blood.modle.callback.HttpCallBack;
import com.example.admin.people_blood.view.xueyaguanli.WenZhangDetilImpl;

/**
 * 项目名称: 血压宝
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/12 9:24
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class WenZhangPressenter {
    private WenZhangBiz wenZhangBiz;
    private WenZhangDetilImpl wenZhangDetil;

    public WenZhangPressenter(WenZhangDetilImpl wenZhangDetil) {
        this.wenZhangDetil = wenZhangDetil;
        wenZhangBiz = new WenZhangBizImpl();
    }

    public void getDetil(String id, String dir) {
        wenZhangBiz.getDetil(id, dir, new HttpCallBack() {
                    @Override
                    public void onSuccess(Object object) {
                        GaoXueYaDetil gaoXueYaDetil = (GaoXueYaDetil) object;
                        wenZhangDetil.getHttp(gaoXueYaDetil);
                    }

                    @Override
                    public void onFailure(String message) {
                        super.onFailure(message);
                        wenZhangDetil.getFeil(message);
                    }
                }

        );
    }
}

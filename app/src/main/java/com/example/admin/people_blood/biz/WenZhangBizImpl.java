package com.example.admin.people_blood.biz;

import com.example.admin.people_blood.bean.GaoXueYaDetil;
import com.example.admin.people_blood.modle.callback.HttpCallBack;
import com.example.admin.people_blood.modle.http.RetrofitClient;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称: 血压宝
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/12 9:24
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class WenZhangBizImpl implements WenZhangBiz{

    @Override
    public void getDetil(String id, String dir, HttpCallBack httpCallBack) {
        Map<String,String> map = new HashMap<>();
        map.put("act","zixun");
        map.put("fun","getHealthPlazeDetail");
        map.put("version","version2");
        map.put("tag","zj");
        map.put("sign","2e0d0887581be1c35794ee4c13b00cae");
        map.put("id",id);
        map.put("dir",dir);
        RetrofitClient.getInstance().get(GaoXueYaDetil.class,"", map,httpCallBack);
    }
}

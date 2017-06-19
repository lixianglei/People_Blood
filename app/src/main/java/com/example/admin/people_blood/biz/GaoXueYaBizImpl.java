package com.example.admin.people_blood.biz;

import com.example.admin.people_blood.bean.GaoXueYaZiXun;
import com.example.admin.people_blood.modle.callback.HttpCallBack;
import com.example.admin.people_blood.modle.http.RetrofitClient;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称: 血压宝
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/11 20:49
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class GaoXueYaBizImpl implements GaoXueYaBiz{
    @Override
    public void getHttp(String typeid, String dir,HttpCallBack httpCallBack) {
        Map<String,String> map = new HashMap<>();
        map.put("act","zixun");
        map.put("fun","getHealthPlazeList");
        map.put("version","version2");
        map.put("tag","zj");
        map.put("sign","2e0d0887581be1c35794ee4c13b00cae");
        map.put("typeid",typeid);
        map.put("dir",dir);
        RetrofitClient.getInstance().get(GaoXueYaZiXun.class, "", map, httpCallBack);
    }


}

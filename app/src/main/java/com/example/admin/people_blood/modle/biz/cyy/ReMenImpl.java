package com.example.admin.people_blood.modle.biz.cyy;

import com.example.admin.people_blood.bean.ReMenDoctorBean;
import com.example.admin.people_blood.modle.callback.HttpCallBack;
import com.example.admin.people_blood.modle.http.RetrofitClient;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/12 10:30
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ReMenImpl implements IReMenModel {
    @Override
    public void remen(String pageNum, HttpCallBack httpCallBack) {
        Map<String,String>   map=new HashMap<>();
        map.put("tag","BloodAndroid");
        map.put("sign","2c19b2821ebc5306c3ac37bac5b4288b");
        map.put("act","zhuanjia");
         map.put("fun","HotDoctor");
        map.put("pageCount","4");
        map.put("pageNum",pageNum);
        RetrofitClient.getInstance().get(ReMenDoctorBean.class,"/index.php",map,httpCallBack);
            }
}

package com.example.admin.people_blood.modle.biz.cyy;

import com.example.admin.people_blood.bean.YuYueBean;
import com.example.admin.people_blood.modle.callback.HttpCallBack;
import com.example.admin.people_blood.modle.http.RetrofitClient;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/13 15:19
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class YuYueImpl implements IYuYueImpl {
    @Override
    public void yuyue(String expertid, String id, HttpCallBack httpCallBack) {
        Map<String,String>  map=new HashMap<>();
        map.put("tag","BloodAndroid");
        map.put("sign","2c19b2821ebc5306c3ac37bac5b4288b");
        map.put("act","zhuanjia");
        map.put("fun","DoctorDetail");
        map.put("pagesize","10");
        map.put("pagenum","1");
        map.put("expertid",expertid);
        map.put("id",id);
        RetrofitClient.getInstance().get(YuYueBean.class,"/index.php",map,httpCallBack);
    }
}

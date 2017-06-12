package com.example.admin.people_blood.modle.biz.cyy;

import com.example.admin.people_blood.bean.SharedBean;
import com.example.admin.people_blood.modle.callback.HttpCallBack;
import com.example.admin.people_blood.modle.http.RetrofitClient;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/12 16:11
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class SharedImpl implements ISharedModel {
    @Override
    public void shared(String id, HttpCallBack httpCallBack) {
        Map<String, String> map = new HashMap<>();
        map.put("tag", "BloodAndroid");
        map.put("sign", "2c19b2821ebc5306c3ac37bac5b4288b");
        map.put("act", "zhuanjia");
        map.put("fun", "Article");
        map.put("source", "cdsb");
        map.put("id", id);
        map.put("page","1");
        map.put("size","20");
        RetrofitClient.getInstance().get(SharedBean.class,"/index.php",map,httpCallBack);
    }
}

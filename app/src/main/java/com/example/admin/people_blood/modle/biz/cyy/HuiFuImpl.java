package com.example.admin.people_blood.modle.biz.cyy;

import com.example.admin.people_blood.bean.HuiFuBean;
import com.example.admin.people_blood.modle.callback.HttpCallBack;
import com.example.admin.people_blood.modle.http.RetrofitClient;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/12 14:58
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class HuiFuImpl implements IHuiFuModel {
    @Override
    public void huifu(String expertid, String pageNum, HttpCallBack httpCallBack) {
        Map<String,String> params = new HashMap<>();
        params.put("tag","BloodAndroid");
        params.put("sign","2c19b2821ebc5306c3ac37bac5b4288b");
        params.put("act","zhuanjia");
        params.put("fun","DoctorRely");
        params.put("expertid",expertid);
        params.put("pageNum",pageNum);
        params.put("pageCount","20");
        RetrofitClient.getInstance().get(HuiFuBean.class,"/index.php",params,httpCallBack);
    }
}

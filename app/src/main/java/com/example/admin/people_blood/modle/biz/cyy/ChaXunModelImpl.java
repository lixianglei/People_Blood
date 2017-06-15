package com.example.admin.people_blood.modle.biz.cyy;

import android.util.Log;

import com.example.admin.people_blood.bean.ChaXunZhuanJiaBean;
import com.example.admin.people_blood.modle.callback.HttpCallBack;
import com.example.admin.people_blood.modle.http.RetrofitClient;

import java.util.HashMap;
import java.util.Map;

import static com.baidu.location.d.j.C;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/12 00:56
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ChaXunModelImpl implements IChaXunModel {
    @Override
    public void chaxun(String Province, String Title, String PageCount, String PageNum, String Keyword, String Level, HttpCallBack httpCallBack) {
        Map<String,String>  map=new HashMap<>();
        map.put("tag","BloodAndroid");
        map.put("sign","2c19b2821ebc5306c3ac37bac5b4288b");
        map.put("act","zhuanjia");
        map.put("fun","SearchDoctor");
        map.put("pageCount",PageCount);
        map.put("pageNum",PageNum);
        map.put("province",Province);
        map.put("title",Title);
        map.put("keyword","");
        map.put("illid","%E9%AB%98%E8%A1%80%E5%8E%8B");
        map.put("IsPlus","0");
        map.put("level",Level);
        Log.i("集合",map.toString());
        RetrofitClient.getInstance().get(ChaXunZhuanJiaBean.class,"/index.php",map,httpCallBack);
    }
}

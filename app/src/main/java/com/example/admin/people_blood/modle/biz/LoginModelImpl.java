package com.example.admin.people_blood.modle.biz;

import com.example.admin.people_blood.bean.LoginBean;
import com.example.admin.people_blood.modle.callback.HttpCallBack;
import com.example.admin.people_blood.modle.http.RetrofitClient;
import com.example.admin.people_blood.utils.HostUtils;

import java.util.HashMap;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/10 19:22
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class LoginModelImpl implements ILoginModel {
    @Override
    public void login(String phonenum, String password, HttpCallBack httpCallBack) {
        HashMap<String,String>  map=new HashMap<>();
        map.put("phonenum",phonenum);
        map.put("password",password);
        RetrofitClient.getInstance().post(LoginBean.class, HostUtils.lgoinuid,map,httpCallBack);
    }

    @Override
    public void loginBack(HttpCallBack httpCallBack) {

    }

    @Override
    public void loginDoctor(HttpCallBack httpCallBack) {

    }
}

package com.example.admin.people_blood.modle.biz;

import com.example.admin.people_blood.modle.callback.HttpCallBack;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/10 19:11
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public interface ILoginModel {
    //登录返回uid；
     void login(String phonenum, String password, HttpCallBack httpCallBack);
    //登录跳转获取头像
    void loginBack(HttpCallBack httpCallBack);
    //登录之后获取热门医生
    void  loginDoctor(HttpCallBack httpCallBack);
}

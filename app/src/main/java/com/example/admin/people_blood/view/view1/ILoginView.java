package com.example.admin.people_blood.view.view1;

import com.example.admin.people_blood.bean.LoginBean;
import com.example.admin.people_blood.bean.LoginTwoBean;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/11 19:28
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public interface ILoginView {
    //获取手机号
      String  getPhoneNum();
    //获取密码;
    String getPassword();
    //点击登录；
    void  getLogin();
    //点击跳转；
    void getHome();
    //得到实体类
    void   login(LoginBean lo);
    void   onFiel(String message);

    String userid();
    void  logintwo(LoginTwoBean  loginTwoBean);
}

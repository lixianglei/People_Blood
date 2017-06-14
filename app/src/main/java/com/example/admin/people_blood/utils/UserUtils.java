package com.example.admin.people_blood.utils;


import com.example.admin.people_blood.App;


public class UserUtils {
    //用户id获取
    public static  String  getUSERID(){
        return App.sharedPreferences.getString (KeyUtils.USERID,"");
    }
    //用户touxaing获取
    public static  String getUSERImage(){
        return App.sharedPreferences.getString(KeyUtils.USERIMAGE,"");
    }
    //用户姓名
    public static  String  getUSERNAME(){
        return App.sharedPreferences.getString(KeyUtils.USERNAME,"");
    }
    //状态
    public  static  boolean getZhaungTai(){
        return  App.sharedPreferences.getBoolean(KeyUtils.ZhuangTai,false);
    }
    //用户手机号
    public static  String  getUSERPHONENUM(){
        return App.sharedPreferences.getString(KeyUtils.PHONENUM,"");
    }
}

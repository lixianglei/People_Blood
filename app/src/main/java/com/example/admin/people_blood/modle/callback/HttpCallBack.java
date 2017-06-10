package com.example.admin.people_blood.modle.callback;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/9 16:34
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public abstract class HttpCallBack {
    public abstract void onSuccess(Object object);

    public  void onFailure(String message){};

    public void upload(int pro) {

    }
}

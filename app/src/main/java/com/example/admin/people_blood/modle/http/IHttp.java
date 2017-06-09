package com.example.admin.people_blood.modle.http;


import com.example.admin.people_blood.modle.callback.HttpCallBack;

import java.util.Map;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/9 16:48
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public interface IHttp {
    void get(Class classBean, String url, Map<String, String> map, HttpCallBack httpCallBack);

    void post(Class classBean, String url, Map<String, String> map, HttpCallBack httpCallBack);


}

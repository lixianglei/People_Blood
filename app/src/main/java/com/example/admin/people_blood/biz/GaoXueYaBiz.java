package com.example.admin.people_blood.biz;

import com.example.admin.people_blood.modle.callback.HttpCallBack;

/**
 * 项目名称: 血压宝
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/11 20:48
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public interface GaoXueYaBiz {
    void getHttp(String typeid, String dir, HttpCallBack httpCallBack);
}

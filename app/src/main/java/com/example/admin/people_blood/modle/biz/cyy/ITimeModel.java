package com.example.admin.people_blood.modle.biz.cyy;

import com.example.admin.people_blood.modle.callback.HttpCallBack;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/15 21:27
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public interface ITimeModel {
    void  time(String id, HttpCallBack httpCallBack);
}

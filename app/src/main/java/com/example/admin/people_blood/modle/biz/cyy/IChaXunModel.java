package com.example.admin.people_blood.modle.biz.cyy;

import com.example.admin.people_blood.modle.callback.HttpCallBack;

import static com.baidu.location.d.j.v;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/12 00:50
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public interface IChaXunModel {
     void chaxun(String Province, String Title, String PageCount, String PageNum, String Keyword, String Level, HttpCallBack httpCallBack);
}

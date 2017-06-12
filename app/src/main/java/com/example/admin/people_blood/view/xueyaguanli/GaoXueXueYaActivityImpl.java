package com.example.admin.people_blood.view.xueyaguanli;

import com.example.admin.people_blood.bean.GaoXueYaDetil;
import com.example.admin.people_blood.bean.GaoXueYaZiXun;

/**
 * 项目名称: 血压宝
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/11 20:45
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public interface GaoXueXueYaActivityImpl{
    String getTypeid();
    String getDir();
    void getSucc(GaoXueYaZiXun gaoXueYaZiXun);
    void getFal(String string);
    void getItemSucc(GaoXueYaDetil gaoXueYaDetil);
}

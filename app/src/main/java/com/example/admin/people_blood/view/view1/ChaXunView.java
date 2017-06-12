package com.example.admin.people_blood.view.view1;

import com.example.admin.people_blood.bean.ChaXunZhuanJiaBean;

import java.util.List;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/12 07:49
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public interface ChaXunView {
    void chaxun(List<ChaXunZhuanJiaBean.DataBean>    beanList);

    void doctorNum(int number);
}

package com.example.admin.people_blood.eventbus;

import com.example.admin.people_blood.bean.CeLiangMesageBean;

import java.util.List;

/**
 * 项目名称: 血压宝
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/12 23:26
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ShuJuKuDetl {
    private List<CeLiangMesageBean> list;

    public List<CeLiangMesageBean> getList() {
        return list;
    }

    public void setList(List<CeLiangMesageBean> list) {
        this.list = list;
    }

    public ShuJuKuDetl(List<CeLiangMesageBean> list) {
        this.list = list;
    }
}

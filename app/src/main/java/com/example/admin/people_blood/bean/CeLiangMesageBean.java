package com.example.admin.people_blood.bean;

/**
 * 项目名称: 血压宝
 * 类描述: 用来存储测量结果的bena
 * 创建人: 田晓龙
 * 创建时间: 2017/6/12 11:00
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class CeLiangMesageBean {
    private String date;
    private String time;
    private String name;
    private String diya;
    private String gaoya;

    public CeLiangMesageBean(String date, String time, String name, String diya, String gaoya) {
        this.date = date;
        this.time = time;
        this.name = name;
        this.diya = diya;
        this.gaoya = gaoya;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiya() {
        return diya;
    }

    public void setDiya(String diya) {
        this.diya = diya;
    }

    public String getGaoya() {
        return gaoya;
    }

    public void setGaoya(String gaoya) {
        this.gaoya = gaoya;
    }
}

package com.example.admin.people_blood.bean;

import java.util.List;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/12 16:22
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class SharedBean {

    /**
     * data : [{"id":"61467","title":"强直性脊柱炎病人康复治疗很关键","categoryid":"83"},{"id":"61466","title":"痛风病人在饮食方面有哪些要注意的地方","categoryid":"83"},{"id":"61465","title":"为什么男性患痛风的几率比女性高","categoryid":"83"},{"id":"61464","title":"痛风在临床上都有哪些症状表现呢","categoryid":"83"},{"id":"61463","title":"痛风可以说是一种\u201c富贵病\u201d","categoryid":"83"},{"id":"57314","title":"风湿性关节炎与类风湿关节炎的区别","categoryid":"83"},{"id":"47322","title":"成人斯蒂尔病日常生活中该注意些什么","categoryid":"83"},{"id":"46967","title":"请问我患的是多肌炎吗","categoryid":"83"},{"id":"46014","title":"银屑病性关节炎，生物制剂该怎么用","categoryid":"83"},{"id":"46013","title":"关于银屑病性关节炎的几个问题","categoryid":"83"},{"id":"27435","title":"如何看待中医中药在类风湿关节炎和其他结缔组织病治疗中的作用","categoryid":"83"},{"id":"15072","title":"关于患者咨询的几点建议","categoryid":"83"},{"id":"15071","title":"再谈患者咨询","categoryid":"83"}]
     * code : 10000
     */

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 61467
         * title : 强直性脊柱炎病人康复治疗很关键
         * categoryid : 83
         */

        private String id;
        private String title;
        private String categoryid;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCategoryid() {
            return categoryid;
        }

        public void setCategoryid(String categoryid) {
            this.categoryid = categoryid;
        }
    }
}

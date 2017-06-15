package com.example.admin.people_blood.bean;

import java.util.List;


public class ShouCang {

    /**
     * state : 200
     * data : [{"categoryid":"770882","document_id":"0","title":"高血压患者饮食食谱有哪些","meta":"zhuzhan_ys,7938"},{"categoryid":"770334","document_id":"0","title":"高血压患者如何通过膳食缓解呢","meta":"zhuzhan_ys,7938"},{"categoryid":"1495225","document_id":"0","title":"高血压患者需正确认识低盐饮食","meta":"zhuanti_nk,18033"}]
     * error :
     */

    private int state;
    private String error;
    private List<DataBean> data;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * categoryid : 770882
         * document_id : 0
         * title : 高血压患者饮食食谱有哪些
         * meta : zhuzhan_ys,7938
         */

        private String categoryid;
        private String document_id;
        private String title;
        private String meta;

        public String getCategoryid() {
            return categoryid;
        }

        public void setCategoryid(String categoryid) {
            this.categoryid = categoryid;
        }

        public String getDocument_id() {
            return document_id;
        }

        public void setDocument_id(String document_id) {
            this.document_id = document_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMeta() {
            return meta;
        }

        public void setMeta(String meta) {
            this.meta = meta;
        }
    }
}

package com.example.admin.people_blood.bean;


public class Phone {

    /**
     * code : 10014
     * error : 手机已绑定不能重复绑定
     */

    private int code;
    private String error;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

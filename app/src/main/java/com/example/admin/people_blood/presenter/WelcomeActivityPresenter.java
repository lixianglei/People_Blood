package com.example.admin.people_blood.presenter;

import com.example.admin.people_blood.view.WelcomeActivityimpl;

/**
 * 项目名称: 血压宝
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/10 10:38
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class WelcomeActivityPresenter {
    private WelcomeActivityimpl welcomeActivityimpl;

    public WelcomeActivityPresenter(WelcomeActivityimpl welcomeActivityimpl) {
        this.welcomeActivityimpl = welcomeActivityimpl;
    }

    public void tiao(){
        welcomeActivityimpl.tiao();
    }
}

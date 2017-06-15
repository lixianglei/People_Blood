package com.example.admin.people_blood;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.admin.people_blood.base.BaseActivity;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/9 20:10
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class App extends Application {
    public static BaseActivity baseActivity,activity;
    public static SharedPreferences sharedPreferences;
    @Override
    public void onCreate() {
        super.onCreate();
        sharedPreferences = getSharedPreferences("DATA", Context.MODE_PRIVATE);

    }
}

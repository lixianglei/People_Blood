package com.example.admin.people_blood.modle.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/10 10:28
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class MyHepler extends SQLiteOpenHelper {
    public MyHepler(Context context, String name, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table xueya(name varchar(30) primary key)";
        db.execSQL(sql);
        String sqlce = "create table celiang(date varchar(30) primary key,time varchar(30),name varchar(30),gaoya varchar(30),diya varchar(30))";
        db.execSQL(sqlce);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

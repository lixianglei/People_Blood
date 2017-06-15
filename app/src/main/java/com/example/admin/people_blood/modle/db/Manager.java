package com.example.admin.people_blood.modle.db;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/10 10:31
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.admin.people_blood.bean.CeLiangMesageBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据库的
 */
public class Manager {
    private MyHepler myHepler;
    private SQLiteDatabase mDB;
    private Context context;
    private static final String TAB_SHUJU = "celiang";

    public Manager(Context context) {
        this.context = context;
        myHepler = new MyHepler(context, "lanya.db", 1);
        mDB = myHepler.getWritableDatabase();
    }

    /**
     * 数据库的插入
     *
     * @param name
     * @return
     */
    public boolean insert(String name) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        long insert = mDB.insert("xueya", null, values);
        return isBoo(insert);
    }

    private boolean isBoo(long insert) {
        boolean boo;
        if (insert > 0) {
            boo = true;
        } else {
            boo = false;
        }
        return boo;
    }

    public boolean insert(CeLiangMesageBean ceLiangMesageBean) {
        ContentValues values = new ContentValues();
        values.put("date", ceLiangMesageBean.getDate());
        values.put("time", ceLiangMesageBean.getTime());
        values.put("name", ceLiangMesageBean.getName());
        values.put("gaoya", ceLiangMesageBean.getGaoya());
        values.put("diya", ceLiangMesageBean.getDiya());
        values.put("isshoudong",ceLiangMesageBean.getIsshoudong());
        long insert = mDB.insert(TAB_SHUJU, null, values);
        return isBoo(insert);
    }

    /**
     * 此方法是数据库的查询,用于关键字搜索的查询
     *
     * @return
     */
    public List<String> getList() {
        List<String> list = new ArrayList<>();
        //游标查询
        Cursor cursor = mDB.query("xueya", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String ss = cursor.getString(cursor.getColumnIndex("name"));
            list.add(ss);
        }
        return list;
    }

    public boolean update(String date, CeLiangMesageBean ceLiangMesageBean) {
        ContentValues values = new ContentValues();
        values.put("date", ceLiangMesageBean.getDate());
        values.put("time", ceLiangMesageBean.getTime());
        values.put("name", ceLiangMesageBean.getName());
        values.put("gaoya", ceLiangMesageBean.getGaoya());
        values.put("diya", ceLiangMesageBean.getDiya());
        values.put("isshoudong",ceLiangMesageBean.getIsshoudong());
        int update = mDB.update(TAB_SHUJU, values, "date=?", new String[]{date});
        return isBoo(update);
    }

    public List<CeLiangMesageBean> query(String date) {

        List<CeLiangMesageBean> list = new ArrayList<>();
        //游标查询
        Cursor cursor = mDB.query(TAB_SHUJU, null, "date=?", new String[]{date}, null, null, null);
        while (cursor.moveToNext()) {
            String dat = cursor.getString(cursor.getColumnIndex("date"));
            String time = cursor.getString(cursor.getColumnIndex("time"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String gaoya = cursor.getString(cursor.getColumnIndex("gaoya"));
            String diya = cursor.getString(cursor.getColumnIndex("diya"));
//            String isshoudong = cursor.getString(cursor.getColumnIndex("isshoudong"));
            CeLiangMesageBean ceLiangMesageBean = new CeLiangMesageBean(dat, time, name, gaoya, diya,null);
            list.add(ceLiangMesageBean);
        }
        return list;

    }

    public List<CeLiangMesageBean> query() {

        List<CeLiangMesageBean> list = new ArrayList<>();
        //游标查询
        Cursor cursor = mDB.query(TAB_SHUJU, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String dat = cursor.getString(cursor.getColumnIndex("date"));
            String time = cursor.getString(cursor.getColumnIndex("time"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String gaoya = cursor.getString(cursor.getColumnIndex("gaoya"));
            String diya = cursor.getString(cursor.getColumnIndex("diya"));
            String isshoudong = cursor.getString(cursor.getColumnIndex("isshoudong"));
            CeLiangMesageBean ceLiangMesageBean = new CeLiangMesageBean(dat, time, name, gaoya, diya,isshoudong);
            list.add(ceLiangMesageBean);
        }
        return list;

    }
}

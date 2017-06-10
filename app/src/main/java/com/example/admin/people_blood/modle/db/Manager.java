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

import java.util.ArrayList;
import java.util.List;

/**
 * 数据库的
 */
public class Manager {
      private  MyHepler  myHepler;
     private SQLiteDatabase  mDB;
     private Context  context;
    public Manager(Context context) {
      this.context=context;
        myHepler=new MyHepler(context,"lanya.db",1);
        mDB=myHepler.getWritableDatabase();
    }

    /**
     * 数据库的插入
     * @param name
     * @return
     */
    public  boolean  insert(String name){
          boolean  boo;
        ContentValues  values=new ContentValues();
        values.put("name",name);
        long insert = mDB.insert("xueya", null, values);
        if (insert>0){
            boo= true;
        }else {
           boo=false;
        }
         return  boo;
    }

    /**
     * 此方法是数据库的查询,用于关键字搜索的查询
     * @return
     */
   public List<String>  getList(){
       List<String>   list=new ArrayList<>();
       //游标查询
       Cursor  cursor=mDB.query("xueya",null,null,null,null,null,null);
       while (cursor.moveToNext()){
           String ss=cursor.getString(cursor.getColumnIndex("name"));
           list.add(ss);
       }
       return  list;
   }
}

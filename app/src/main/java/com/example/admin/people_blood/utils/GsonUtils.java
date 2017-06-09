package com.example.admin.people_blood.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称: 城市通
 * 类描述: Gson解析工具类
 * 创建人: 田晓龙
 * 创建时间: 2017/5/13 23:04
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class GsonUtils {
    private static Gson gson = null;

    static {
        if (gson == null) {
            gson = new Gson();
        }
    }


    private GsonUtils() {
    }

    //bean
    public static <T> T gsonBean(String gsonString, Class<T> cls) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(gsonString, cls);
        }
        return t;

    }
    //集合
    public static <T> List<T> gsonList(String json, Class<T> cls) {
        Gson gson = new Gson();
        List<T> list = new ArrayList<T>();
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        for (final JsonElement elem : array) {
            list.add(gson.fromJson(elem, cls));
        }
        return list;
    }
}

package com.example.admin.people_blood.utils;

import android.content.Context;
import android.widget.Toast;

import com.example.admin.people_blood.App;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/5/15 00:58
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class ToastUtils {

    private static Toast mToast;
    private static Context context = App.baseActivity;
    public static void showShortToast(String text) {
        getSingleToast(text, Toast.LENGTH_SHORT).show();
    }



    public static void showLongToast(String text) {
        getSingleToast(text, Toast.LENGTH_LONG).show();
    }



    public static Toast getSingleToast(String text, int duration) {
        if (mToast == null) {
            mToast = Toast.makeText(context, text, duration);
        } else {
            mToast.setText(text);
        }
        return mToast;
    }

}

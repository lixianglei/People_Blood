package com.example.admin.people_blood.customizeview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;

import com.example.admin.people_blood.App;
import com.example.admin.people_blood.R;

/**
 * 项目名称: 血压宝
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/9 23:45
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class HttpDialogManager {
    //网络显示的Dialog
    private Dialog dialog;

    public HttpDialogManager() {
        View view = LayoutInflater.from(App.baseActivity).inflate(R.layout.dialog_proregss, null);
        dialog = new AlertDialog.Builder(App.baseActivity)
                .setTitle("加载中")
                .setView(view)
                .create();
    }

    public void showDialog() {
        if (dialog != null) {
            dialog.show();
        }
    }

    public void dimssDialog() {
        if (dialog != null || !dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}

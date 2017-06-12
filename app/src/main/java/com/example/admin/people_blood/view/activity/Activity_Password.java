package com.example.admin.people_blood.view.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by d on 2017/6/12.
 */

public class Activity_Password extends BaseActivity {
    @Bind(R.id.left_image)
    ImageView leftImage;
    @Bind(R.id.left_layout)
    RelativeLayout leftLayout;
//    @Bind(R.id.Yijian_FanKui)
//    TextView YijianFanKui;
    @Bind(R.id.Edit_pass)
    EditText EditPhone;
    @Bind(R.id.ShuRu)
    TextView ShuRu;
    @Bind(R.id.Edit_PassOne)
    EditText EditPassword;
    @Bind(R.id.EditText_layout)
    LinearLayout EditTextLayout;
    @Bind(R.id.Login_Btn)
    Button LoginBtn;

    @Override
    protected int layoutId() {
        return R.layout.activity_password;
    }

    @Override
    protected void initView() {
        showListDialog();

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void listener() {

    }

    private void showListDialog() {
        final String[] items = {"男", "女"};
        AlertDialog.Builder listDialog =
                new AlertDialog.Builder(Activity_Password.this);
        listDialog.setTitle("选择性别");
        listDialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // which 下标从0开始
                String item = items[which];
                ShuRu.setText(item);
                Toast.makeText(Activity_Password.this,
                        "修改成功",
                        Toast.LENGTH_SHORT).show();
            }
        });
        listDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}

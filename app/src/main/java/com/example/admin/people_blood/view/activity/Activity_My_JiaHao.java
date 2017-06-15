package com.example.admin.people_blood.view.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by d on 2017/6/10.
 */
public class Activity_My_JiaHao extends BaseActivity {
    @Bind(R.id.left_image)
    ImageView leftImage;
    @Bind(R.id.left_layout)
    RelativeLayout leftLayout;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.QuanJuJiaZai)
    LinearLayout QuanJuJiaZai;
    @Bind(R.id.Text_DianJi)
    TextView TextDianJi;
    ProgressDialog waitingDialog;
    @Override
    protected int layoutId() {
        return R.layout.activity_myjiahao;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void loadData() {
        showWaitingDialog();

    }

    @Override
    protected void listener() {

    }
    private void showWaitingDialog() {
        waitingDialog =
                new ProgressDialog(Activity_My_JiaHao.this);
        waitingDialog.setMessage("等待中...");
        waitingDialog.setIndeterminate(true);
        waitingDialog.setCancelable(false);
        waitingDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.left_image, R.id.Text_DianJi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.left_image:
                finish();
                break;
            case R.id.Text_DianJi:
                Toast.makeText(this, "暂时没有数据，请稍后再试", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

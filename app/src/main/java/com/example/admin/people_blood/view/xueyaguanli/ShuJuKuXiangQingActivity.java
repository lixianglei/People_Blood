package com.example.admin.people_blood.view.xueyaguanli;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 项目名称: 血压宝
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/13 0:07
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ShuJuKuXiangQingActivity extends BaseActivity {
    @Bind(R.id.image_Back)
    ImageView imageBack;
    @Bind(R.id.Center_Text)
    TextView CenterText;
    @Bind(R.id.shujuxiangqing_xueya)
    TextView shujuxiangqingXueya;
    @Bind(R.id.shujuxiangqing_name)
    TextView shujuxiangqingName;
    @Bind(R.id.shujuxiangqing_date)
    TextView shujuxiangqingDate;
    @Bind(R.id.shujuxiangqing_isshoudong)
    TextView shujuxiangqingIsshoudong;

    @Override
    protected int layoutId() {
        return R.layout.activity_shujuku_xiangqing;
    }

    @Override
    protected void initView() {
        CenterText.setText("详细信息");
        Intent intent = getIntent();
        if(intent!=null){
            shujuxiangqingXueya.setText(intent.getStringExtra("xiangqing_xueya"));
            shujuxiangqingName.setText(intent.getStringExtra("xiangqing_name"));
            shujuxiangqingDate.setText(intent.getStringExtra("xiangqing_date"));
            if(intent.getStringExtra("xiangqing_isshoudong").equals("true")){
                shujuxiangqingIsshoudong.setText("是");
            }else{
                shujuxiangqingIsshoudong.setText("否");
            }
        }
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void listener() {
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}

package com.example.admin.people_blood.view.xueyaguanli;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名称: 血压宝
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/13 13:11
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class TiXingListActivity extends BaseActivity {
    @Bind(R.id.image_Back)
    ImageView imageBack;
    @Bind(R.id.Center_Text)
    TextView CenterText;
    @Bind(R.id.image_shoucang)
    ImageView imageShoucang;
    @Bind(R.id.tixiang_list)
    ListView tixiangList;

    @Override
    protected int layoutId() {
        return R.layout.activity_tixinglist;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void listener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.image_Back, R.id.image_shoucang})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_Back:
                finish();
                break;
            case R.id.image_shoucang:

                break;
        }
    }
}

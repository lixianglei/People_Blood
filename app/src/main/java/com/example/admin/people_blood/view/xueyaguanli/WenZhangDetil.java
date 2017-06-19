package com.example.admin.people_blood.view.xueyaguanli;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;
import com.example.admin.people_blood.bean.GaoXueYaDetil;
import com.example.admin.people_blood.presenter.WenZhangPressenter;
import com.example.admin.people_blood.utils.DateUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名称: 血压宝
 * 类描述: 血压资讯的详情
 * 创建人: 田晓龙
 * 创建时间: 2017/6/12 9:21
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class WenZhangDetil extends BaseActivity implements WenZhangDetilImpl {
    @Bind(R.id.image_Back)
    ImageView imageBack;
    @Bind(R.id.Center_Text)
    TextView CenterText;
    @Bind(R.id.image_shoucang)
    ImageView imageShoucang;
    @Bind(R.id.Detal_Title)
    TextView DetalTitle;
    @Bind(R.id.Detal_date)
    TextView DetalDate;
    @Bind(R.id.Detal_content)
    TextView DetalContent;
    private String id;
    private String dir;
    private WenZhangPressenter wenZhangPressenter;

    @Override
    protected int layoutId() {
        return R.layout.activity_wenzhang;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        id = intent.getStringExtra("wen_id");
        dir = intent.getStringExtra("wen_dir");
        wenZhangPressenter = new WenZhangPressenter(this);
        wenZhangPressenter.getDetil(id,dir);
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
    public void getHttp(GaoXueYaDetil gaoXueYaDetil) {
        GaoXueYaDetil.DataBean data = gaoXueYaDetil.getData();
        Log.e("Body",data.getBody());
        Spanned spanned = Html.fromHtml(data.getBody());
        Log.d("WenZhangDetil", spanned.toString());
        DetalContent.setText( spanned.toString());
        DetalTitle.setText(data.getTitle());
        Long date = Long.parseLong(data.getPubdate()) * 1000;
        DetalDate.setText(DateUtils.format(date, "yyyy-MM-dd"));

    }

    @Override
    public void getFeil(String message) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.image_shoucang)
    public void onViewClicked() {
    }
}

package com.example.admin.people_blood.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.people_blood.App;
import com.example.admin.people_blood.R;
import com.example.admin.people_blood.adapter.JiaHaoItemAdapter;
import com.example.admin.people_blood.base.BaseActivity;
import com.example.admin.people_blood.bean.YuYueBean;
import com.example.admin.people_blood.presenter.cyy.YuYuePresenter;
import com.example.admin.people_blood.view.view1.YuYueView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YuYueActivity extends BaseActivity implements YuYueView {

    @Bind(R.id.center)
    LinearLayout center;
    @Bind(R.id.YuYueListView)
    ListView YuYueListView;
    private Intent intent;
    @Bind(R.id.image_Back)
    ImageView imageBack;
    @Bind(R.id.Center_Text)
    TextView CenterText;
    @Bind(R.id.Doctor_Image)
    ImageView DoctorImage;
    @Bind(R.id.Doctor_Name)
    TextView DoctorName;
    @Bind(R.id.Doctor_KeShi)
    TextView DoctorKeShi;
    @Bind(R.id.Doctor_JiBie)
    TextView DoctorJiBie;
    @Bind(R.id.Doctor_Hosptial)
    TextView DoctorHosptial;
    @Bind(R.id.Doctor_Content)
    TextView DoctorContent;
    private String expertid, id;
    private YuYuePresenter yuYuePresenter;
    private JiaHaoItemAdapter adapter;
    private List<YuYueBean.DataBean.ScheduleBean.RdtimeBean> mList;

    @Override
    protected int layoutId() {
        return R.layout.activity_yu_yue;
    }

    @Override
    protected void initView() {
        initData();
        yuYuePresenter = new YuYuePresenter(this);
        mList = new ArrayList<>();
        adapter = new JiaHaoItemAdapter(YuYueActivity.this, mList);
        YuYueListView.setAdapter(adapter);
    }

    @Override
    protected void loadData() {

        yuYuePresenter.yuYue(expertid, id);
    }

    @Override
    protected void listener() {

    }


    @OnClick(R.id.image_Back)
    public void onViewClicked() {
        finish();
    }

    private void initData() {
        intent = getIntent();
        String image = intent.getStringExtra("app_image");
        String doc_name = intent.getStringExtra("doc_name");
        String doc_title = intent.getStringExtra("doc_title");
        String doc_teach = intent.getStringExtra("doc_teach");
        String doc_hospital = intent.getStringExtra("doc_hospital");
        String doc_content = intent.getStringExtra("doc_content");
        String doc_depart = intent.getStringExtra("doc_depart");
        expertid = intent.getStringExtra("expert_id");
        id = intent.getStringExtra("document_id");
        DoctorName.setText(doc_name);
        CenterText.setText("预约专家");
        DoctorHosptial.setText(doc_hospital);
        DoctorJiBie.setText(doc_title);
        DoctorContent.setText(doc_content);
        DoctorKeShi.setText(doc_depart);
        Glide.with(App.baseActivity).load(image).into(DoctorImage);
    }

    @Override
    public void yuyue(List<YuYueBean.DataBean.ScheduleBean.RdtimeBean> bean) {
           mList.addAll(bean);
        adapter.notifyDataSetChanged();
    }


}

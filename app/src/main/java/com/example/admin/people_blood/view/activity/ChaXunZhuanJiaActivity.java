package com.example.admin.people_blood.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.adapter.ViewHolder;
import com.androidkun.callback.PullToRefreshListener;
import com.bumptech.glide.Glide;
import com.example.admin.people_blood.App;
import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;
import com.example.admin.people_blood.bean.ChaXunZhuanJiaBean;
import com.example.admin.people_blood.presenter.cyy.ChaXunPresenter;
import com.example.admin.people_blood.view.view1.ChaXunView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;



public class ChaXunZhuanJiaActivity extends BaseActivity implements ChaXunView {
    @Bind(com.example.admin.people_blood.R.id.image_Back)
    ImageView imageBack;
    @Bind(com.example.admin.people_blood.R.id.Center_Text)
    TextView CenterText;
    @Bind(com.example.admin.people_blood.R.id.ChaXun_ListView)
    PullToRefreshRecyclerView PullToRecycleView;
    private String sheng,zc,dj,gjz;
    private Intent  intent;
//    @Bind(R.id.ChaXun_ListView)
//    ListView ChaXunListView;
   private int  pageNum=1;
    private List<ChaXunZhuanJiaBean.DataBean> mList;
    private SharedPreferences  mShared;
    private SharedPreferences.Editor editor;
//    private ChaXunAdapter mAdapter;
    private ChaXunPresenter presenter;
   private MyChaXunAdapter mAdapter;
    @Override
    protected int layoutId() {
        return com.example.admin.people_blood.R.layout.activity_cha_xun_zhuan_jia;
    }

    @Override
    protected void initView() {



        mShared=getSharedPreferences("data",MODE_PRIVATE);
        sheng=mShared.getString("sheng","");

        gjz=mShared.getString("gjz","");
        LinearLayoutManager layoutManager = new LinearLayoutManager(ChaXunZhuanJiaActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        PullToRecycleView.addItemDecoration(new DividerItemDecoration(App.baseActivity, DividerItemDecoration.VERTICAL));
        PullToRecycleView.setLayoutManager(layoutManager);
        PullToRecycleView.setPullRefreshEnabled(true);//下拉刷新
        //是否开启上拉加载功能
        PullToRecycleView.setLoadingMoreEnabled(true);
        PullToRecycleView.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                PullToRecycleView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        PullToRecycleView.setRefreshComplete();
                        mList.clear();
                        loadData();
                    }
                },2000);
            }

            @Override
            public void onLoadMore() {
                PullToRecycleView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        PullToRecycleView.setLoadMoreComplete();
                        pageNum++;
                        loadData();
                    }
                },2000);
            }
        });
        //开启刷新回调
        PullToRecycleView.displayLastRefreshTime(true);
        presenter = new ChaXunPresenter(this);
        mList = new ArrayList<>();
        mAdapter = new MyChaXunAdapter(ChaXunZhuanJiaActivity.this,mList);
        PullToRecycleView.setAdapter(mAdapter);


    }

    @Override
    protected void loadData() {
        presenter.chaxun(sheng,"","10",String.valueOf(pageNum),gjz,"");
    }

    @Override
    protected void listener() {
    }


    @OnClick(R.id.image_Back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void chaxun(List<ChaXunZhuanJiaBean.DataBean> beanList) {
        mList.addAll(beanList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void doctorNum(int number) {
        CenterText.setText("全国有" + number + "位专家");
    }
    }

    class MyChaXunAdapter extends com.androidkun.adapter.BaseAdapter<ChaXunZhuanJiaBean.DataBean> {
        public MyChaXunAdapter(Context context,  List<ChaXunZhuanJiaBean.DataBean> datas) {
            super(context, R.layout.chaxunzhuanjia_item, datas);
        }

        @Override
        public void convert(ViewHolder holder, final ChaXunZhuanJiaBean.DataBean dataBean) {
            holder.setText(R.id.Doctor_Name, dataBean.getName());
            holder.setText(R.id.Doctor_JiBie, dataBean.getTitle());
            holder.setText(R.id.Doctor_Content, dataBean.getGoodat());
            holder.setText(R.id.Doctor_KeShi, dataBean.getDepart());
            holder.setText(R.id.Doctor_ZhiCheng, dataBean.getTeach());
            holder.setText(R.id.Doctor_YiYuan, dataBean.getHospital());
            ImageView view = holder.getView(R.id.Doctor_Image);
            Glide.with(App.baseActivity).load(dataBean.getApp_image()).into(view);
            holder.setOnclickListener(R.id.chaxun, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(App.baseActivity, DoctorDetailActivity.class);
                    intent.putExtra("app_image", dataBean.getApp_image());
                    intent.putExtra("doc_title", dataBean.getTitle());
                    intent.putExtra("doc_teach", dataBean.getTeach());
                    intent.putExtra("doc_hospital", dataBean.getHospital());
                    intent.putExtra("document_id", dataBean.getDocument_id());
                    intent.putExtra("doc_content", dataBean.getGoodat());
                    intent.putExtra("expert_id", dataBean.getExpert_id());
                    intent.putExtra("doc_depart", dataBean.getDepart());
                    intent.putExtra("doc_name", dataBean.getName());
                    App.baseActivity.startActivity(intent);
                }
            });
            holder.setOnclickListener(R.id.MianFei_Btn, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(App.baseActivity, YuYueActivity.class);
                    intent.putExtra("app_image", dataBean.getApp_image());
                    intent.putExtra("doc_title", dataBean.getTitle());
                    intent.putExtra("doc_teach", dataBean.getTeach());
                    intent.putExtra("doc_hospital", dataBean.getHospital());
                    intent.putExtra("document_id", dataBean.getDocument_id());
                    intent.putExtra("doc_content", dataBean.getGoodat());
                    intent.putExtra("expert_id", dataBean.getExpert_id());
                    intent.putExtra("doc_depart", dataBean.getDepart());
                    intent.putExtra("doc_name", dataBean.getName());
                    App.baseActivity.startActivity(intent);
                }
            });
        }

}

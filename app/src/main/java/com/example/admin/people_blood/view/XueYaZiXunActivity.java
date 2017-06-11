package com.example.admin.people_blood.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
 * 创建时间: 2017/6/10 17:44
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class XueYaZiXunActivity extends BaseActivity {


    @Bind(R.id.image_Back)
    ImageView imageBack;
    @Bind(R.id.Center_Text)
    TextView CenterText;
    @Bind(R.id.gxy_changshi)
    LinearLayout gxyChangshi;
    @Bind(R.id.imageView2)
    ImageView imageView2;
    @Bind(R.id.gxy_shipu)
    LinearLayout gxyShipu;
    @Bind(R.id.gxy_yufang)
    LinearLayout gxyYufang;
    @Bind(R.id.gxy_zhiliao)
    LinearLayout gxyZhiliao;
    @Bind(R.id.gxy_jiancha)
    LinearLayout gxyJiancha;
    private Intent intent;

    @Override
    protected int layoutId() {
        return R.layout.activity_xueyazixun;
    }

    @Override
    protected void initView() {
        CenterText.setText("血压资讯");
        intent = new Intent(XueYaZiXunActivity.this, GaoXueYaActivity.class);
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


    @OnClick({R.id.image_Back, R.id.gxy_changshi, R.id.gxy_shipu, R.id.gxy_yufang, R.id.gxy_zhiliao, R.id.gxy_jiancha})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_Back:
                finish();
                break;
            case R.id.gxy_changshi:
                intent.putExtra("typeid", "18031");
                intent.putExtra("dir", "zhuanti_nk");
                startActivity(intent);
                break;
            case R.id.gxy_shipu:

                intent.putExtra("typeid", "7938");
                intent.putExtra("dir", "zhuzhan_ys");
                startActivity(intent);
                break;
            case R.id.gxy_yufang:
                intent.putExtra("typeid", "18033");
                intent.putExtra("dir", "zhuanti_nk");
                startActivity(intent);
                break;
            case R.id.gxy_zhiliao:
                intent.putExtra("typeid", "18035");
                intent.putExtra("dir", "zhuanti_nk");
                startActivity(intent);
                break;
            case R.id.gxy_jiancha:
                intent.putExtra("typeid", "18032");
                intent.putExtra("dir", "zhuanti_nk");
                startActivity(intent);
                break;
        }
    }
}

package com.example.admin.people_blood.view.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.people_blood.App;
import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseFragment;
import com.example.admin.people_blood.presenter.BloodManagerPressenter;
import com.example.admin.people_blood.view.ShouDongCeLiangActivity;
import com.example.admin.people_blood.view.XueYaZiXunActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/9 20:29
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class BloodManagerFragment extends BaseFragment implements BloodManagerFragmentImpl {
    @Bind(R.id.xueyaceliang)
    ImageView xueyaceliang;
    @Bind(R.id.boold_shuju)
    TextView booldShuju;
    @Bind(R.id.tongji_day)
    RadioButton tongjiDay;
    @Bind(R.id.tongji_zhou)
    RadioButton tongjiZhou;
    @Bind(R.id.tongji_month)
    RadioButton tongjiMonth;
    @Bind(R.id.tongji_year)
    RadioButton tongjiYear;
    @Bind(R.id.boold_tongji)
    RadioGroup booldTongji;
    @Bind(R.id.boold_wendoctor)
    TextView booldWendoctor;
    @Bind(R.id.boold_zixun)
    TextView booldZixun;
    @Bind(R.id.boold_tixing)
    TextView booldTixing;
    private PopupWindow popupWindow;
    private BloodManagerPressenter bloodManagerPressenter;

    @Override
    protected int ViewID() {
        return R.layout.fragment_bloodmanager;
    }

    @Override
    protected void initView() {
        bloodManagerPressenter = new BloodManagerPressenter(this);
        initpopwindow();

    }

    private void initpopwindow() {
        View view = LayoutInflater.from(App.baseActivity).inflate(R.layout.pop_xuanzeceliang, null);
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#AFAFAF")));
        TextView shoudong = (TextView) view.findViewById(R.id.pop_shoudong);
        TextView kangbaobeo = (TextView) view.findViewById(R.id.pop_kangbaobei);
        TextView sfinsh = (TextView) view.findViewById(R.id.pop_finsh);
        shoudong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodManagerPressenter.shoudongCe();
            }
        });
        kangbaobeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodManagerPressenter.kangbaobei();
            }
        });
        sfinsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodManagerPressenter.finshpop();
            }
        });
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void listener() {

    }


    @Override
    public void shoudongshangchuan() {
        Intent intent = new Intent(App.baseActivity, ShouDongCeLiangActivity.class);
        startActivity(intent);
    }

    @Override
    public void kangBaoBeiShangChuan() {
        Toast.makeText(App.baseActivity, "康宝贝测量", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void shuaxin(String text) {

    }

    @Override
    public void showPopWindow() {
        popupWindow.showAsDropDown(xueyaceliang);
    }

    @Override
    public void finshpop() {
        popupWindow.dismiss();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.xueyaceliang, R.id.boold_shuju, R.id.boold_wendoctor, R.id.boold_tixing, R.id.boold_zixun})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //选择测量
            case R.id.xueyaceliang:
                bloodManagerPressenter.shangchuan();
                break;
            //更改 没用
            case R.id.boold_shuju:

                break;
            //提醒
            case R.id.boold_tixing:
                break;
            //问医生
            case R.id.boold_wendoctor:
                break;
            //资讯
            case R.id.boold_zixun:
                Intent intent = new Intent(App.baseActivity, XueYaZiXunActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}

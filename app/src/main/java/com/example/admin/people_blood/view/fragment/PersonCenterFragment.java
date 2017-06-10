package com.example.admin.people_blood.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseFragment;
import com.example.admin.people_blood.view.fragment.activity.Activity_Message;
import com.example.admin.people_blood.view.fragment.activity.Activity_My_JiaHao;
import com.example.admin.people_blood.view.fragment.activity.Activity_My_ShouCang;
import com.example.admin.people_blood.view.fragment.activity.Activity_PerSonMessage;
import com.example.admin.people_blood.view.fragment.activity.Activity_SheZhi;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/9 20:30
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class PersonCenterFragment extends BaseFragment {

    @Bind(R.id.Login_Image)
    TextView LoginImage;
    @Bind(R.id.imageView)
    ImageView imageView;
    @Bind(R.id.My_JiaHao)
    LinearLayout MyJiaHao;
    @Bind(R.id.My_ShouCang)
    LinearLayout MyShouCang;
    @Bind(R.id.My_ZiLiao)
    LinearLayout MyZiLiao;
    @Bind(R.id.My_XiaoXi)
    LinearLayout MyXiaoXi;
    @Bind(R.id.My_SheZhi)
    LinearLayout MySheZhi;

    @Override
    protected int ViewID() {
        return R.layout.person_center;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.Login_Image, R.id.imageView, R.id.My_JiaHao, R.id.My_ShouCang, R.id.My_ZiLiao, R.id.My_XiaoXi, R.id.My_SheZhi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Login_Image:
                break;
            case R.id.imageView:
                break;
            case R.id.My_JiaHao:
                Intent intent=new Intent(getContext(), Activity_My_JiaHao.class);
                startActivity(intent);
                break;
            case R.id.My_ShouCang:
                Intent intent1=new Intent(getContext(), Activity_My_ShouCang.class);
                startActivity(intent1);
                break;
            case R.id.My_ZiLiao:
                Intent intent2=new Intent(getContext(), Activity_PerSonMessage.class);
                startActivity(intent2);
                break;
            case R.id.My_XiaoXi:
                Intent intent3=new Intent(getContext(), Activity_Message.class);
                startActivity(intent3);
                break;
            case R.id.My_SheZhi:
                Intent intent4=new Intent(getContext(), Activity_SheZhi.class);
                startActivity(intent4);
                break;
        }
    }
}

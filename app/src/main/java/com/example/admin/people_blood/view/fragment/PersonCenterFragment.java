package com.example.admin.people_blood.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.people_blood.App;
import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseFragment;
import com.example.admin.people_blood.bean.LoginBean;
import com.example.admin.people_blood.bean.LoginTwoBean;
import com.example.admin.people_blood.presenter.LoginPresenter;
import com.example.admin.people_blood.view.activity.Activity_My_JiaHao;
import com.example.admin.people_blood.view.activity.Activity_My_ShouCang;
import com.example.admin.people_blood.view.activity.Activity_PerSonMessage;
import com.example.admin.people_blood.view.activity.Activity_SheZhi;
import com.example.admin.people_blood.view.activity.LoginActivity;
import com.example.admin.people_blood.view.activity.WenYiShengActivity;
import com.example.admin.people_blood.view.view1.ILoginView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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

public class PersonCenterFragment extends BaseFragment implements ILoginView{
    private Intent intent;
    @Bind(R.id.Login_Image)
    ImageView LoginImage;
    @Bind(R.id.DianjiText)
    TextView DianjiText;
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
  private String  userid,phonenum;
    private LoginPresenter  presenter;
    private SharedPreferences  mShared;
    @Override
    protected int ViewID() {
        return R.layout.person_center;
    }

    @Override
    protected void initView() {
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }

         mShared=App.baseActivity.getSharedPreferences("data", Context.MODE_PRIVATE);
        userid=mShared.getString("userid","");
        phonenum=mShared.getString("phonenum","");
        DianjiText.setText(phonenum);
        presenter=new LoginPresenter(this);
    }

    @Override
    protected void loadData() {
        if(userid.length()!=0 || !userid.isEmpty()){
            presenter.logintwo(userid);
        }
    }

    @Override
    protected void listener() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.My_SheZhi,R.id.Login_Image, R.id.DianjiText,R.id.My_JiaHao, R.id.My_ShouCang, R.id.My_ZiLiao, R.id.My_XiaoXi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Login_Image:
                Intent intent=new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.DianjiText:
                Intent intent1=new Intent(getContext(), LoginActivity.class);
                startActivity(intent1);
                break;
            case R.id.My_JiaHao:
                Intent intent2=new Intent(getContext(), Activity_My_JiaHao.class);
                startActivity(intent2);
                break;
            case R.id.My_ShouCang:
                Intent intent3=new Intent(getContext(), Activity_My_ShouCang.class);
                startActivity(intent3);
                break;
            case R.id.My_ZiLiao:
                Intent intent4=new Intent(getContext(), Activity_PerSonMessage.class);
                startActivity(intent4);
                break;
            case R.id.My_XiaoXi:
                Intent intent5=new Intent(getContext(), WenYiShengActivity.class);
                startActivity(intent5);
                break;
            case R.id.My_SheZhi:
                Intent intent6=new Intent(getContext(), Activity_SheZhi.class);
                startActivity(intent6);
                break;
        }
    }

    @Override
    public String getPhoneNum() {
        return  null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void getLogin() {

    }

    @Override
    public void getHome() {

    }

    @Override
    public void login(LoginBean lo) {

    }

    @Override
    public void onFiel(String message) {

    }

    @Override
    public String userid() {
        return null;
    }

    @Override
    public void logintwo(LoginTwoBean loginTwoBean) {
        String avatar = loginTwoBean.getAvatar();
        Glide.with(App.baseActivity).load(avatar).into(LoginImage);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(LoginBean loginBean){
        presenter.logintwo(loginBean.getUserid());

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}

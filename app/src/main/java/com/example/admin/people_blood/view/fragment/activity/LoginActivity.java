package com.example.admin.people_blood.view.fragment.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


    @Bind(R.id.Edit_Phone)
    EditText EditPhone;
    @Bind(R.id.ShuRu_PhoneNum)
    TextView ShuRuPhoneNum;
    @Bind(R.id.Edit_Password)
    EditText EditPassword;
    @Bind(R.id.Mima_TiShi)
    TextView MimaTiShi;
    @Bind(R.id.Forget_password)
    TextView ForgetPassword;
    @Bind(R.id.Login_Btn)
    Button LoginBtn;

    @Override
    protected int layoutId() {
        return R.layout.activity_login;
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

    @OnClick(R.id.Login_Btn)
    public void onViewClicked() {
    }
}

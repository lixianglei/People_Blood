package com.example.admin.people_blood.view.activity;

import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;
import com.example.admin.people_blood.bean.LoginBean;
import com.example.admin.people_blood.presenter.ILoginPresenter;
import com.example.admin.people_blood.presenter.LoginPresenter;
import com.example.admin.people_blood.view.view1.ILoginView;

import butterknife.Bind;
import butterknife.OnClick;


public class LoginActivity extends BaseActivity  implements ILoginView {


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
    private ILoginPresenter  loginPresenter;

    @Override
    protected int layoutId() {

        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

        loginPresenter=new LoginPresenter(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void listener() {

    }

    @OnClick(R.id.Login_Btn)
    public void onViewClicked() {
          loginPresenter.login(getPhoneNum(),getPassword());
        Toast.makeText(this, "niss", Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getPhoneNum() {
        String phonenum=EditPhone.getText().toString().trim();
        return phonenum;
    }

    @Override
    public String getPassword() {

     String   password=EditPassword.getText().toString().trim();
        return password;
    }

    @Override
    public void getLogin() {

    }

    @Override
    public void getHome() {

    }

    @Override
    public void login(LoginBean loginBean) {
        Log.i("TAG",loginBean.getPhonenum());
        Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFiel(String message) {
        Log.i("TAG","失败---"+message);
        Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
    }
}

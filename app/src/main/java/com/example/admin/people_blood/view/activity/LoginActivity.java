package com.example.admin.people_blood.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;
import com.example.admin.people_blood.bean.LoginBean;
import com.example.admin.people_blood.bean.LoginTwoBean;
import com.example.admin.people_blood.presenter.ILoginPresenter;
import com.example.admin.people_blood.presenter.LoginPresenter;
import com.example.admin.people_blood.view.fragment.PersonCenterFragment;
import com.example.admin.people_blood.view.view1.ILoginView;

import org.greenrobot.eventbus.EventBus;

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
    private SharedPreferences  mShared;
    private SharedPreferences.Editor mEditor;
    private String  userid,phonenum;
    @Override
    protected int layoutId() {

        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        loginPresenter=new LoginPresenter(this);
        mShared=getSharedPreferences("data",MODE_PRIVATE);
        mEditor=mShared.edit();
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
//        Intent  intent=new Intent(LoginActivity.this, PersonCenterFragment.class);
//         intent.putExtra("userid",userid);
//        intent.putExtra("phonenum",phonenum);
//        startActivity(intent);

//         loginPresenter.logintwo(userid);
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
        String phonenum = loginBean.getPhonenum();
        userid = loginBean.getUserid();
        mEditor.putString("userid",userid);
        mEditor.putString("phonenum",phonenum);
        mEditor.putString("passworld",EditPassword.getText().toString().trim());
        mEditor.commit();
        finish();
        EventBus.getDefault().post(loginBean);
    }

    @Override
    public void onFiel(String message) {
        Log.i("TAG","失败---"+message);
        Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public String userid() {
        return userid;
    }

    @Override
    public void logintwo(LoginTwoBean loginTwoBean) {
        //用户的头像
        String avatar = loginTwoBean.getAvatar();
        Log.i("sd",avatar);
//        mEditor.putString("avatar",avatar);
    }
}

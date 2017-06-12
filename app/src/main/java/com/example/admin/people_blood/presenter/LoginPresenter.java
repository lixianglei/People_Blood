package com.example.admin.people_blood.presenter;

import com.example.admin.people_blood.bean.LoginBean;
import com.example.admin.people_blood.bean.LoginTwoBean;
import com.example.admin.people_blood.modle.biz.cyy.ILoginModel;
import com.example.admin.people_blood.modle.biz.cyy.LoginModelImpl;
import com.example.admin.people_blood.modle.callback.HttpCallBack;
import com.example.admin.people_blood.view.view1.ILoginView;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/11 19:25
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class LoginPresenter implements ILoginPresenter {
       private ILoginModel  loginModel;
       private ILoginView   loginView;

    public LoginPresenter( ILoginView loginView) {
        loginModel=new LoginModelImpl();
        this.loginView = loginView;
    }


    @Override
    public void login(String phonenum, String password) {
          loginModel.login(loginView.getPhoneNum(), loginView.getPassword(), new HttpCallBack() {
              @Override
              public void onSuccess(Object object) {
                 LoginBean  loginBean = (LoginBean) object;
                  loginView.getHome();
                  loginView.login(loginBean);
              }

              @Override
              public void onFailure(String message) {
                  loginView.onFiel(message);
              }
          });
    }

    @Override
    public void logintwo() {
          loginModel.loginImage(loginView.userid(), new HttpCallBack() {
              @Override
              public void onSuccess(Object object) {
                  LoginTwoBean loginBean = (LoginTwoBean) object;
                  loginView.logintwo(loginBean);
              }
          });
    }
}

package com.example.admin.people_blood.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;
import com.example.admin.people_blood.bean.Phone;
import com.example.admin.people_blood.modle.callback.ResaultCallBack;
import com.example.admin.people_blood.modle.http.RetrofitUtil;
import com.example.admin.people_blood.utils.HostUtils;
import com.example.admin.people_blood.utils.ToastUtils;
import com.example.admin.people_blood.utils.UserUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YanZheng_Ma extends BaseActivity {
    @Bind(R.id.Num_Text)
    TextView NumText;
    @Bind(R.id.edit_num)
    EditText editNum;
    @Bind(R.id.send_yanzhengma)
    Button sendYanzhengma;
    private String num;
    private boolean isSendRegist;


    @Override
    protected int layoutId() {
        return R.layout.yanzheng_activity;
    }

    @Override
    protected void initView() {

        num = UserUtils.getUSERPHONENUM();
        NumText.setText("更换成功后，下次登录可以使用新的手机号，当前手机号为：" + num);
        isSendRegist = true;

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

    @OnClick({ R.id.Num_Text, R.id.edit_num, R.id.send_yanzhengma})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Num_Text:
                break;
            case R.id.edit_num:
                break;
            case R.id.send_yanzhengma:
                if (TextUtils.isEmpty(editNum.getText())) {
                    ToastUtils.showShortToast("请输入手机号");
                    return;
                }
                editNum.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if (editNum.getText().length() >= 11) {
                            sendYanzhengma.setBackgroundColor(Color.parseColor("#4CBF5B"));
                        }
                    }
                    @Override
                    public void afterTextChanged(Editable s) {
                        if (editNum.getText().length() >= 11) {
                            sendYanzhengma.setBackgroundColor(Color.parseColor("#4CBF5B"));
                        } else {
                            sendYanzhengma.setBackgroundColor(Color.parseColor("#5f5d5d"));
                        }
                    }
                });
                Map<String,String > map = new HashMap<>();
                map.put("act","sms");
                map.put("fun","sendCode");
                map.put("target",editNum.getText().toString().trim());
                map.put("tag","BloodAndroid");
                map.put("sign","2c19b2821ebc5306c3ac37bac5b4288b");
                map.put("type","3");
                RetrofitUtil.getInstance().getRetrofit(HostUtils.HOST, map, new ResaultCallBack() {
                    @Override
                    public void onSuccess(Object obj) {
                        Phone phoneBean = (Phone) obj;
                       if (phoneBean.getCode()==10000){
                           ToastUtils.showShortToast("验证码已发送");
                           Intent intent = new Intent(getApplicationContext(),BangDing_Activity.class);
                           intent.putExtra("aaa",editNum.getText().toString().trim());
                           startActivity(intent);

                       }else {
                           ToastUtils.showShortToast("此手机已验证");
                       }

                    }

                    @Override
                    public void onError(String errorMsg) {

                    }

                    @Override
                    public void notNet(String netData) {

                    }

                    @Override
                    public void onErrorParams(String errorParams) {

                    }
                }, Phone.class);

                break;
        }
    }
}


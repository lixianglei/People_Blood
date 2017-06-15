package com.example.admin.people_blood.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;
import com.example.admin.people_blood.bean.BangDing;
import com.example.admin.people_blood.modle.callback.ResaultCallBack;
import com.example.admin.people_blood.modle.http.RetrofitUtil;
import com.example.admin.people_blood.utils.ToastUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class BangDing_Activity extends BaseActivity {
    @Bind(R.id.back_img)
    ImageView backImg;
    @Bind(R.id.mEdiText_YanZhngMa)
    EditText mEdiTextYanZhngMa;
    @Bind(R.id.BangDing_Btn)
    Button ButtonBangDing;
    @Bind(R.id.title_text)
    TextView titleText;
    @Bind(R.id.Text_Fa)
    TextView TextFa;
    private String num;
    private String string;

    @Override
    protected int layoutId() {
        return R.layout.queding_yanzhengma;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        num = intent.getStringExtra("aaa");
        TextFa.setText("验证码已发送至这个手机号：" + num);
        string = mEdiTextYanZhngMa.getText().toString().trim();


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

    @OnClick({R.id.back_img, R.id.mEdiText_YanZhngMa, R.id.BangDing_Btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_img:
                onBackPressed();
                break;
            case R.id.mEdiText_YanZhngMa:
                break;
            case R.id.BangDing_Btn:
                Map<String, String> map = new HashMap();
                map.put("act", "sms");
                map.put("fun", "verifyCode");
                map.put("target", num);
                map.put("tag", "BloodAndroid");
                map.put("code", string);
                map.put("yz", "1");
                map.put("sign", "2c19b2821ebc5306c3ac37bac5b4288b");
                map.put("type", "3");
                RetrofitUtil.getInstance().getRetrofit("http://api.wws.xywy.com/index.php", map, new ResaultCallBack() {
                    @Override
                    public void onSuccess(Object obj) {
                        BangDing bangdingBean = (BangDing) obj;
                        if (bangdingBean.getCode() == 10000) {
                            ToastUtils.showShortToast("提交成功");
                            finish();
                        } else {
                            ToastUtils.showShortToast("提交失败");
                        }

                    }

                    @Override
                    public void onError(String errorMsg) {
                        ToastUtils.showShortToast("请求失败");
                    }

                    @Override
                    public void notNet(String netData) {
                        ToastUtils.showShortToast("无网络连接");

                    }

                    @Override
                    public void onErrorParams(String errorParams) {
                        ToastUtils.showShortToast("参数错误");

                    }
                }, BangDing.class);

                break;
        }
    }
}

package com.example.admin.people_blood.view.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.admin.people_blood.App;
import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseFragment;
import com.example.admin.people_blood.utils.ToastUtils;
import com.example.admin.people_blood.view.activity.GuanJianZiActivity;
import com.example.admin.people_blood.view.activity.ShengFenActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.background;
import static android.R.attr.id;
import static com.baidu.location.d.j.t;

/**
 * 项目名称: 血压测量
 * 类描述:医生在线的fragment
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/9 20:26
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class DoctorLineFragment extends BaseFragment {
    @Bind(R.id.MyLoction)
    ImageView MyLoction;
    @Bind(R.id.Shengfen)
    LinearLayout Shengfen;
    @Bind(R.id.YiShengZhiCheng)
    LinearLayout YiShengZhiCheng;
    @Bind(R.id.YiYuanDengJi)
    LinearLayout YiYuanDengJi;
    @Bind(R.id.GuanJianZi)
    LinearLayout GuanJianZi;
    @Bind(R.id.doct_image)
    ImageView doctImage;
    @Bind(R.id.doct_jiahao)
    TextView doctJiahao;
    @Bind(R.id.MianFeiWenYiSheng)
    TextView MianFeiWenYiSheng;
    @Bind(R.id.JianKangGuWen)
    TextView JianKangGuWen;
    @Bind(R.id.doctor_huanyihuan)
    TextView doctorHuanyihuan;
    @Bind(R.id.daoctor_gridviwe)
    GridView daoctorGridviwe;
    private PopupWindow  mPopupZc,mPopupDJ;
    private Dialog  dialog;
    private Button  mBtnCancle,mBtnSure;
    @Override
    protected int ViewID() {
        return R.layout.fragment_doctor;
    }

    @Override
    protected void initView() {
       initPopupZc();
            initPopupDj();

    }

    private void initPopupDj() {
        View  view1=LayoutInflater.from(App.baseActivity).inflate(R.layout.ysdj_popup,null);
        mPopupDJ=new PopupWindow(view1,ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT,true);
        mPopupDJ.setOutsideTouchable(true);
        mPopupDJ.setBackgroundDrawable(new ColorDrawable());
    }

    private void initPopupZc() {

        View  view=LayoutInflater.from(App.baseActivity).inflate(R.layout.yszcpopup,null);
        mPopupZc=new PopupWindow(view,ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT,true);
        mPopupZc.setBackgroundDrawable(new ColorDrawable());
        mPopupZc.setOutsideTouchable(true);

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void listener() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
//
    @OnClick({R.id.MyLoction, R.id.Shengfen, R.id.YiShengZhiCheng, R.id.YiYuanDengJi, R.id.GuanJianZi, R.id.doct_jiahao, R.id.MianFeiWenYiSheng, R.id.JianKangGuWen, R.id.doctor_huanyihuan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.MyLoction:
                break;
            case R.id.Shengfen:
                Intent  intent=new Intent(App.baseActivity, ShengFenActivity.class);
                startActivity(intent);
                break;
            case R.id.YiShengZhiCheng:
               if (mPopupZc.isShowing()){
                   mPopupZc.dismiss();
               }else {
                   mPopupZc.showAtLocation(App.baseActivity.findViewById(R.id.Doctor_Line), Gravity.BOTTOM,0,0);
               }
                break;
            case R.id.YiYuanDengJi:
                if (mPopupDJ.isShowing()){
                    mPopupDJ.dismiss();
                }else {
                    mPopupDJ.showAtLocation(App.baseActivity.findViewById(R.id.Doctor_Line), Gravity.BOTTOM,0,0);
                }
                break;
            case R.id.GuanJianZi:
                Intent  intent1=new Intent(App.baseActivity, GuanJianZiActivity.class);
                startActivity(intent1);
                break;
            case R.id.doct_jiahao:
                break;
            case R.id.MianFeiWenYiSheng:
                break;
            case R.id.JianKangGuWen:
                 initDialog();
                break;
            case R.id.doctor_huanyihuan:
                break;
            case  R.id.ChaXunZhuanJia:
                Intent  intent2=new Intent(App.baseActivity, ChaXunZhuanJiaActivity.class);
                startActivity(intent2);
                break;
        }
    }

    private void initDialog() {
        View view2=LayoutInflater.from(App.baseActivity).inflate(R.layout.phone_dialog,null);
        dialog=new AlertDialog.Builder(App.baseActivity).setView(view2).create();
        mBtnSure= (Button) view2.findViewById(R.id.Sure_Btn);
        mBtnCancle= (Button) view2.findViewById(R.id.Cancle_Btn);
        mBtnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        mBtnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:400-9700-120s"));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });
        dialog.show();
    }
}

package com.example.admin.people_blood.view.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.people_blood.App;
import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseFragment;
import com.example.admin.people_blood.bean.ReMenDoctorBean;
import com.example.admin.people_blood.presenter.cyy.ReMenPresenter;
import com.example.admin.people_blood.utils.ToastUtils;
import com.example.admin.people_blood.view.activity.ChaXunZhuanJiaActivity;
import com.example.admin.people_blood.view.activity.DoctorDetailActivity;
import com.example.admin.people_blood.view.activity.GuanJianZiActivity;
import com.example.admin.people_blood.view.activity.ShengFenActivity;
import com.example.admin.people_blood.view.activity.WenYiShengActivity;
import com.example.admin.people_blood.view.view1.IReMenView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.background;
import static android.R.attr.id;

/**
 * 项目名称: 血压测量
 * 类描述:医生在线的fragment
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/9 20:26
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class DoctorLineFragment extends BaseFragment implements IReMenView{
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
    @Bind(R.id.doctor_huanyihuan)
    TextView huanyihuan;
    @Bind(R.id.MianFeiWenYiSheng)
    TextView MianFeiWenYiSheng;
    @Bind(R.id.JianKangGuWen)
    TextView JianKangGuWen;

    //gridview
    @Bind(R.id.daoctor_gridviwe)
    GridView daoctorGridviwe;
    @Bind(R.id.ChaXunZhuanJia)
    Button  chaxunZhuanjia;
    private PopupWindow  mPopupZc,mPopupDJ;
    private Dialog  dialog;
    private Button  mBtnCancle,mBtnSure;
    private ReMenPresenter  presenter;
    private List<ReMenDoctorBean.DataBean>  mList;
    private ReMenAdapter  mAdapter;
    private int  page=1;
    @Override
    protected int ViewID() {
        return R.layout.fragment_doctor;
    }

    @Override
    protected void initView() {
       initPopupZc();
            initPopupDj();
     presenter=new ReMenPresenter(this);
        mList=new ArrayList<>();
        mAdapter=new ReMenAdapter();
        daoctorGridviwe.setAdapter(mAdapter);
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
                presenter.remen();
    }

    @Override
    protected void listener() {
        daoctorGridviwe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ReMenDoctorBean.DataBean  bean=mList.get(position);
                Intent  intent=new Intent(App.baseActivity, DoctorDetailActivity.class);
                intent.putExtra("app_image",bean.getApp_image());
                intent.putExtra("doc_title",bean.getTitle());
                intent.putExtra("doc_teach",bean.getTeach());
                intent.putExtra("doc_hospital",bean.getHospital());
                intent.putExtra("document_id",bean.getDocument_id() );
                intent.putExtra("doc_content",bean.getGoodat());
                intent.putExtra("expert_id",bean.getExpert_id());
                intent.putExtra("doc_depart",bean.getDepart());
                intent.putExtra("doc_name",bean.getName());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
//
    @OnClick({R.id.MyLoction, R.id.ChaXunZhuanJia,R.id.Shengfen, R.id.YiShengZhiCheng, R.id.YiYuanDengJi, R.id.GuanJianZi, R.id.doct_jiahao, R.id.MianFeiWenYiSheng, R.id.JianKangGuWen, R.id.doctor_huanyihuan})
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
                Intent  intent2=new Intent(App.baseActivity, WenYiShengActivity.class);
                startActivity(intent2);
                break;
            case R.id.JianKangGuWen:
                 initDialog();
                break;
            case R.id.doctor_huanyihuan:
                mList.clear();
                page++;
                presenter.remen();
//                mAdapter.notifyDataSetChanged();
                break;
            case  R.id.ChaXunZhuanJia:
                Intent  intent3=new Intent(App.baseActivity, ChaXunZhuanJiaActivity.class);
                startActivity(intent3);
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

    @Override
    public void remen(List<ReMenDoctorBean.DataBean> dataBeen) {
              mList.addAll(dataBeen);
        Log.i("Sd",mList.toString());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public int page() {
        return   page;
    }

    class   ReMenAdapter extends BaseAdapter{
         @Override
         public int getCount() {
             return mList.isEmpty()?0:mList.size();
         }

         @Override
         public Object getItem(int position) {
             return null;
         }

         @Override
         public long getItemId(int position) {
             return 0;
         }

         @Override
         public View getView(int position, View convertView, ViewGroup parent) {
             Holder  holder=null;
             if (convertView==null){
                 holder=new Holder();
                 convertView=LayoutInflater.from(App.baseActivity).inflate(R.layout.remengrid_item,null);
                 holder.mName= (TextView) convertView.findViewById(R.id.ReMen_Name);
                 holder.mImageView= (ImageView) convertView.findViewById(R.id.RenMen_ImageView);
                convertView.setTag(holder);
             }else {
                 holder= (Holder) convertView.getTag();
             }
                ReMenDoctorBean.DataBean  bean=mList.get(position);
             holder.mName.setText(bean.getName());
             Glide.with(App.baseActivity).load(bean.getApp_image()).into(holder.mImageView);
             return convertView;
         }
         class   Holder{
             private TextView  mName;
             private ImageView  mImageView;
         }
     }
}

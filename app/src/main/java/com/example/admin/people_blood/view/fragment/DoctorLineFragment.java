package com.example.admin.people_blood.view.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.admin.people_blood.view.MyGridLayout;
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
import static android.R.string.yes;
import static com.baidu.location.d.j.S;

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
    @Bind(R.id.Dengji)
    TextView Dengji;
    @Bind(R.id.ZhiCheng)
    TextView Zhicheng;
    @Bind(R.id.ShengFen_Text)
    TextView shengText;
    @Bind(R.id.MianFeiWenYiSheng)
    TextView MianFeiWenYiSheng;
    @Bind(R.id.JianKangGuWen)
    TextView JianKangGuWen;
    @Bind(R.id.GuanJianZi_Text)
    TextView guanjianzi;
    private MyGridLayout mGridLayout1;
    private Button yes;
    private PopupWindow popupWindow_zhicheng;
    private Button sure_btn1;
    private PopupWindow popupWindow_dengji;
    private List<String> mList1;
    private List<String> mList2;
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
    private SharedPreferences  mShared;
    @Override
    protected void initView() {
        initPopupZc();
        initPopupDj();
        presenter=new ReMenPresenter(this);
        mList=new ArrayList<>();
        mAdapter=new ReMenAdapter();
        daoctorGridviwe.setAdapter(mAdapter);
        mShared=getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        String  username=mShared.getString("username","");
//        Bundle  bundle=getArguments();
        shengText.setText(username);
        guanjianzi.setText(mShared.getString("name",""));
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
    private void showTechnical(View view) {
        View inflate = View.inflate(getActivity(), R.layout.activity_dactor_name, null);
        mGridLayout1 = (MyGridLayout) inflate.findViewById(R.id.dragable_myGridLayout);
        yes = (Button) inflate.findViewById(R.id.Yes);
        initDatas();
        popupWindow_zhicheng = new PopupWindow(inflate, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, true);
        popupWindow_zhicheng.setBackgroundDrawable(new ColorDrawable());
        popupWindow_zhicheng.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        popupWindow_zhicheng.setOutsideTouchable(true);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow_zhicheng.dismiss();
            }
        });
        mGridLayout1.setOnClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s=mList1.get(position);
                Zhicheng.setText(s);
            }
        });
    }

    private void initDatas() {
//        mGridLayout1.;
        mList1 = new ArrayList<String>();
        mList1.add("不限");
        mList1.add("主任医师");
        mList1.add("副主任医师");
        mList1.add("主任医生");
        mList1.add("医师");
        mGridLayout1.setItems(mList1);
    }

    private void showHosrank(View view) {

        View inflate = View.inflate(getActivity(), R.layout.activity_hospital_dengji, null);
        mGridLayout1 = (MyGridLayout) inflate.findViewById(R.id.dragable_myGridLayout);
        sure_btn1 = (Button) inflate.findViewById(R.id.sure);
        initDatatwo();
        popupWindow_dengji = new PopupWindow(inflate, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, true);
        popupWindow_dengji.setBackgroundDrawable(new ColorDrawable());
        popupWindow_dengji.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        popupWindow_dengji.setOutsideTouchable(true);

        sure_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow_dengji.dismiss();
            }

        });
        mGridLayout1.setOnClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s=mList1.get(position);
                Dengji.setText(s);
            }
        });

    }

    private void initDatatwo() {

//        mGridLayout1.setBoo;
        mList1 = new ArrayList<String>();
        mList1.add("不限");
        mList1.add("三级甲等");
        mList1.add("三级乙等");
        mList1.add("三级丙等");
        mList1.add("三级");
        mList1.add("二级甲等");
        mList1.add("二级已等");
        mList1.add("二级丙等");
        mGridLayout1.setItems(mList1);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
//
    /**
     * 搜索页面的跳转回传。
     *
     * @param requestCode 跳转的返回值
     * @param resultCode  回传的返回值
     * @param data        得到的结果
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 300 && resultCode == 200) {
            String content = data.getStringExtra("search_content");
            guanjianzi.setText(content);
        }
        if (requestCode == 400 & resultCode == 250) {
            String Province = data.getStringExtra("Province");
            shengText.setText(Province);
        }

    }
    @OnClick({R.id.MyLoction, R.id.ChaXunZhuanJia,R.id.Shengfen, R.id.YiShengZhiCheng, R.id.YiYuanDengJi, R.id.GuanJianZi, R.id.doct_jiahao, R.id.MianFeiWenYiSheng, R.id.JianKangGuWen, R.id.doctor_huanyihuan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.MyLoction:
                break;
            case R.id.Shengfen:
                Intent  intent=new Intent(App.baseActivity, ShengFenActivity.class);
                startActivityForResult(intent,400);
                break;
            case R.id.YiShengZhiCheng:

//               if (mPopupZc.isShowing()){
//                   mPopupZc.dismiss();
//               }else {
//                   mPopupZc.showAtLocation(App.baseActivity.findViewById(R.id.Doctor_Line), Gravity.BOTTOM,0,0);
//               }
                showTechnical(view);
                break;
            case R.id.YiYuanDengJi:
//                if (mPopupDJ.isShowing()){
//                    mPopupDJ.dismiss();
//                }else {
//                    mPopupDJ.showAtLocation(App.baseActivity.findViewById(R.id.Doctor_Line), Gravity.BOTTOM,0,0);
//                }
                showHosrank(view);
                break;
            case R.id.GuanJianZi:
                Intent  intent1=new Intent(App.baseActivity, GuanJianZiActivity.class);
                startActivityForResult(intent1,300);
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



    //这是每个gridLayout 的点击事件




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

package com.example.admin.people_blood.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.people_blood.App;
import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;
import com.example.admin.people_blood.bean.ChaXunZhuanJiaBean;
import com.example.admin.people_blood.presenter.cyy.ChaXunPresenter;
import com.example.admin.people_blood.view.view1.ChaXunView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChaXunZhuanJiaActivity extends BaseActivity  implements ChaXunView{

    @Bind(R.id.image_Back)
    ImageView imageBack;
    @Bind(R.id.Center_Text)
    TextView CenterText;
    @Bind(R.id.ChaXun_ListView)
    ListView ChaXunListView;
  private List<ChaXunZhuanJiaBean.DataBean>   mList;
    private ChaXunAdapter  mAdapter;
    private ChaXunPresenter  presenter;
    @Override
    protected int layoutId() {
        return R.layout.activity_cha_xun_zhuan_jia;
    }

    @Override
    protected void initView() {
        presenter=new ChaXunPresenter(this);
        mList=new ArrayList<>();
        mAdapter=new ChaXunAdapter();
      ChaXunListView.setAdapter(mAdapter);
    }

    @Override
    protected void loadData() {
          presenter.chaxun();
    }

    @Override
    protected void listener() {
       ChaXunListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 ChaXunZhuanJiaBean.DataBean  bean=mList.get(position);

               Intent   intent=new Intent(App.baseActivity,DoctorDetailActivity.class);
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



    @OnClick(R.id.image_Back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void chaxun(List<ChaXunZhuanJiaBean.DataBean> beanList) {
              mList.addAll(beanList);
        mAdapter.notifyDataSetChanged();
    }
    @Override
    public void doctorNum(int number) {
          CenterText.setText("全国有"+number+"位专家");
    }

    class ChaXunAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return  mList.isEmpty()?0:mList.size();
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
                convertView= LayoutInflater.from(App.baseActivity).inflate(R.layout.chaxunzhuanjia_item,null);
               holder.name= (TextView) convertView.findViewById(R.id.Doctor_Name);
                holder.jibie= (TextView) convertView.findViewById(R.id.Doctor_JiBie);
                holder.content= (TextView) convertView.findViewById(R.id.Doctor_Content);
                holder.keshi= (TextView) convertView.findViewById(R.id.Doctor_KeShi);
                holder.zhicheng= (TextView) convertView.findViewById(R.id.Doctor_ZhiCheng);
                holder.yiyuan= (TextView) convertView.findViewById(R.id.Doctor_YiYuan);
                holder.TouXiang= (ImageView) convertView.findViewById(R.id.Doctor_Image);
                holder.MianFeiJiahao= (ImageView) convertView.findViewById(R.id.MianFei_Btn);
                convertView.setTag(holder);
            }else {
                holder= (Holder) convertView.getTag();
            }
            ChaXunZhuanJiaBean.DataBean   bean=mList.get(position);
             holder.keshi.setText(bean.getDepart());
             holder.name.setText(bean.getName());
             holder.content.setText(bean.getGoodat());
             holder.yiyuan.setText(bean.getHospital());
             holder.jibie.setText(bean.getTitle());
             holder.zhicheng.setText(bean.getTeach());
            Glide.with(App.baseActivity).load(bean.getApp_image()).into(holder.TouXiang);
            return convertView;
        }
        class   Holder{
            private TextView name,yiyuan,jibie,keshi,zhicheng,content  ;
            private ImageView TouXiang,MianFeiJiahao;
        }
    }
}

package com.example.admin.people_blood.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.people_blood.App;
import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseFragment;
import com.example.admin.people_blood.bean.HuiFuBean;
import com.example.admin.people_blood.presenter.cyy.HuiFuPresenter;
import com.example.admin.people_blood.view.view1.HuiFuView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/12 14:34
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class HuiFuFragment extends BaseFragment implements HuiFuView {
    @Bind(R.id.HuiFu_ListView)
    ListView HuiFuListView;
    private List<HuiFuBean.DataBean> mList;
    private HuiFuAdapter mAdapter;
    private String  expertid;
    private Intent  intent;
    private int page=1;
    private HuiFuPresenter   presenter;
    @Override
    protected int ViewID() {
        return R.layout.huifu;
    }

    @Override
    protected void initView() {
        intent=getActivity().getIntent();
        expertid=intent.getStringExtra("expert_id");
        presenter=new HuiFuPresenter(this);
        mList = new ArrayList<>();
        mAdapter = new HuiFuAdapter();
   HuiFuListView.setAdapter(mAdapter);
    }

    @Override
    protected void loadData() {
        presenter.huifu(expertid,String.valueOf(page));
    }

    @Override
    protected void listener() {

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void huifu(List<HuiFuBean.DataBean> beanList) {
          mList.addAll(beanList);
        mAdapter.notifyDataSetChanged();
    }

    class HuiFuAdapter extends BaseAdapter {
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
            Holder   holder=null;
            if (convertView==null){
                holder=new Holder();
                convertView=LayoutInflater.from(App.baseActivity).inflate(R.layout.huifu_item,null);
                holder.mTitle= (TextView) convertView.findViewById(R.id.HuiFu_Title);
                holder.mReply= (TextView) convertView.findViewById(R.id.HuiFu_Reply);
                convertView.setTag(holder);
            }else {
                holder= (Holder) convertView.getTag();
            }
               HuiFuBean.DataBean   bean=mList.get(position);
               holder.mTitle.setText(bean.getTitle());
               holder.mReply.setText(bean.getReply());
            return convertView;
        }
        class  Holder{
            private TextView  mTitle,mReply;
        }
    }
}

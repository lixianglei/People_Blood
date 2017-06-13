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
import com.example.admin.people_blood.bean.SharedBean;
import com.example.admin.people_blood.presenter.cyy.SharedPresenter;
import com.example.admin.people_blood.view.view1.SharedView;

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

public class SharedFragment extends BaseFragment  implements SharedView {
    @Bind(R.id.Share_ListView)
    ListView ShareListView;
   private Intent  intent;
    private String  id;
    private List<SharedBean.DataBean>  mList;
    private SharedAdapter  sharedAdapter;
    private SharedPresenter  presenter;
    @Override
    protected int ViewID() {
        return R.layout.shared;
    }

    @Override
    protected void initView() {
        presenter=new SharedPresenter(this);
      intent=getActivity().getIntent();
        id=intent.getStringExtra("expert_id");
        mList=new ArrayList<>();
        sharedAdapter=new SharedAdapter();
        ShareListView.setAdapter(sharedAdapter);
    }

    @Override
    protected void loadData() {
         presenter.shared(id);
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
    public void shared(List<SharedBean.DataBean> beanList) {
          mList.addAll(beanList);
        sharedAdapter.notifyDataSetChanged();
    }

    class SharedAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return  mList.size();
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
                convertView=LayoutInflater.from(App.baseActivity).inflate(R.layout.shared_item,null);
                holder.mText= (TextView) convertView.findViewById(R.id.Shared_Title);
                convertView.setTag(holder);
            }else {
                holder= (Holder) convertView.getTag();
            }
              SharedBean.DataBean  bean=mList.get(position);
               holder.mText.setText(bean.getTitle());
            return convertView;
        }
        class   Holder{
            private TextView mText;
        }
    }
}

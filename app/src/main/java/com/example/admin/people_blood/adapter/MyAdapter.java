package com.example.admin.people_blood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.bean.ShouCang;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context context ;
    private List<ShouCang.DataBean> mList;

    public MyAdapter(Context context, List<ShouCang.DataBean> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.isEmpty() ? 0 : mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hodler hodler = null;
        if (convertView == null) {
            hodler = new Hodler();
            convertView = LayoutInflater.from(context).inflate(R.layout.shoucang_item, null);
            hodler.mTitle = (TextView) convertView.findViewById(R.id.textview);
            convertView.setTag(hodler);
        } else {
            hodler = (Hodler) convertView.getTag();
        }
        ShouCang.DataBean dataBean = mList.get(position);
        hodler.mTitle.setText(dataBean.getTitle()+"");
        return convertView;
    }

    class Hodler {
        private TextView mTitle;

    }
}

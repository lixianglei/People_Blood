package com.example.admin.people_blood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.admin.people_blood.R;

import java.util.List;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/10 10:21
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class GuanJianZiAdapter extends BaseAdapter {
     private List<String>   list;
     private Context  mContext;

    public GuanJianZiAdapter(List<String> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return list.size();
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
            convertView= LayoutInflater.from(mContext).inflate(R.layout.guanjianzi_item,null);
            holder.mText= (TextView) convertView.findViewById(R.id.guanjianzi_text);
            convertView.setTag(holder);
        }else {
            holder= (Holder) convertView.getTag();
        }
        String  str=list.get(position);
        holder.mText.setText(str);
        return convertView;
    }
    class  Holder{
        private TextView  mText;
    }
}

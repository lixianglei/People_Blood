package com.example.admin.people_blood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.bean.YuYueBean;
import com.example.admin.people_blood.utils.AppUtils;

import java.util.List;



/**
 *
 * 项目名称: 血压卫士
 * 类描述:  这是加号详情的适配器，还有就是转换时间格式
 * 创建人: Administrator
 * 创建时间: 2017/6/13 11:44
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 *
 */

public class JiaHaoItemAdapter extends BaseAdapter {
    private Context context;
    private List<YuYueBean.DataBean.ScheduleBean.RdtimeBean> mList;
    private String id;
    private String[] str = {"一", "二", "三", "四", "五", "六", "日"};

    public void setId(String id) {
        this.id = id;
    }


    public JiaHaoItemAdapter(Context context, List<YuYueBean.DataBean.ScheduleBean.RdtimeBean> mList) {
        this.context = context;
        this.mList = mList;

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public String getId() {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        mViewHodle hodle = null;
        if (convertView == null) {
            hodle = new mViewHodle();
            convertView = LayoutInflater.from(context).inflate(R.layout.yuyue_item, null);
            hodle.mTime = (TextView) convertView.findViewById(R.id.JiaHao_ItemTime);
            hodle.mCount = (TextView) convertView.findViewById(R.id.JiaHao_ItemCount);
            hodle.mMsg = (TextView) convertView.findViewById(R.id.JiaHao_ItemMsg);
            hodle.mXingqi = (TextView) convertView.findViewById(R.id.JiaHao_ItemXingqi);
            convertView.setTag(hodle);
        } else {
            hodle = (mViewHodle) convertView.getTag();
        }
        YuYueBean.DataBean.ScheduleBean.RdtimeBean bean = mList.get(position);
        Long aLong = Long.parseLong(bean.getDate());
        String data = AppUtils.longToString(aLong * 1000, "M月dd日");
        hodle.mTime.setText(data);

        hodle.mMsg.setText(bean.getMsg());
        hodle.mCount.setText("(" + "剩余" + bean.getAmount() + "个" + ")");

        int i = Integer.parseInt(bean.getWeek());


        hodle.mXingqi.setText("星期"+str[i]);

        return convertView;
    }

    public class mViewHodle {
        private TextView mTime, mXingqi, mMsg, mCount;

    }

}

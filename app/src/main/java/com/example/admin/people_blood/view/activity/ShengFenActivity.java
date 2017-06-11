package com.example.admin.people_blood.view.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;
import com.example.admin.people_blood.bean.User;
import com.example.admin.people_blood.view.fragment.NavView;

import java.util.ArrayList;
import java.util.List;

/**
 * 这是字母栏的activity
 */
public class ShengFenActivity extends BaseActivity{
    private TextView tv,title;
    private ListView listview;
    private NavView nv;

    private List<User> list;
    private UserAdapter adapter;
    private String[] name = new String[]{
            "不限", "北京市", "山东省", "山西省", "河北省", "河南省", "天津市",
            "辽宁省", "黑龙江省", "吉林省", "湖北省", "湖南省", "上海市", "四川省", "重庆市", "陕西省", "甘肃省", "云南省",
            "新疆维吾尔自治区", "内蒙古自治区", "海南省", "贵州省", "青海省", "广东省", "宁夏回族自治区", "西藏自治区", "广西壮族自治区",
            "江苏省", "浙江省",
            "安徽省", "江西省"};

    @Override
    protected int layoutId() {
        return R.layout.activity_zi_mu_lan;
    }

    public void initView() {
        tv = (TextView) findViewById(R.id.tv);
        listview = (ListView) findViewById(R.id.listview);
        title= (TextView) findViewById(R.id.Center_Text);
        title.setText("省份");
         initData();
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void listener() {

    }

    private void initData() {
        //初始化数据
        list = new ArrayList<>();
      for (int i=0;i<name.length;i++){

          list.add(new User(name[i]));
      }
        //将拼音排序，在这里用不到
//        Collections.sort(list, new Comparator<User>() {
//            @Override
//            public int compare(User lhs, User rhs) {
//                return lhs.getFirstCharacter().compareTo(rhs.getFirstCharacter());
//            }
//        });
        //填充ListView
        adapter = new UserAdapter(this, list);
        listview.setAdapter(adapter);

    }


     class UserAdapter extends BaseAdapter {

        private List<User> list;
        private User user;
        private LayoutInflater mInflater;
        private Context context;

        public UserAdapter(Context context, List<User> list) {
            this.list = list;
            mInflater = LayoutInflater.from(context);
            this.context = context;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.adapter_user, null);
            }
            ViewHolder holder = getViewHolder(convertView);
            user = list.get(position);
            holder.tv_name.setText(user.getUsername());
            return convertView;
        }

        /**
         * 获得控件管理对象
         *
         * @param view
         * @return
         */
        private ViewHolder getViewHolder(View view) {
            ViewHolder holder = (ViewHolder) view.getTag();
            if (holder == null) {
                holder = new ViewHolder(view);
                view.setTag(holder);
            }
            return holder;
        }

        /**
         * 控件管理类优化类
         */
        private class ViewHolder {

            private TextView  tv_name;

            ViewHolder(View view) {
                tv_name = (TextView) view.findViewById(R.id.tv_name);
            }
        }


    }
}

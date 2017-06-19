package com.example.admin.people_blood.view.xueyaguanli;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;
import com.example.admin.people_blood.bean.CeLiangMesageBean;
import com.example.admin.people_blood.eventbus.ShuJuKuDetl;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名称: 血压宝
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/12 23:27
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ShuJuKuListActivity extends BaseActivity {
    @Bind(R.id.image_Back)
    ImageView imageBack;
    @Bind(R.id.Center_Text)
    TextView CenterText;
    @Bind(R.id.shuju_detl)
    ListView shujuDetl;
    private List<CeLiangMesageBean> list;

    @Override
    protected int layoutId() {
        return R.layout.activity_shujudetl;
    }

    @Override
    protected void initView() {
        EventBus.getDefault().register(this);
        CenterText.setText("所有已记录的信息");

    }

    @Override
    protected void loadData() {
        if (!list.isEmpty()) {
            shujuDetl.setAdapter(new MyShuJuAdapter());
        }
    }

    @Override
    protected void listener() {
        shujuDetl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ShuJuKuListActivity.this, ShuJuKuXiangQingActivity.class);
                intent.putExtra("xiangqing_xueya", list.get(position).getGaoya() + ".0");

                intent.putExtra("xiangqing_name", list.get(position).getName());
                intent.putExtra("xiangqing_date", list.get(position).getDate());

                if (list.get(position).getIsshoudong() == null) {
                    intent.putExtra("xiangqing_isshoudong", "true");
                } else {
                    intent.putExtra("xiangqing_isshoudong", list.get(position).getIsshoudong());
                }
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.image_Back)
    public void onViewClicked() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getList(ShuJuKuDetl shuJuKuDetl) {
        list = shuJuKuDetl.getList();
    }

    class MyShuJuAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.isEmpty() ? 0 : list.size();
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

            ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(ShuJuKuListActivity.this).inflate(R.layout.item_shujuku, null);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            String month = list.get(position).getDate().split("-")[1];
            String day = list.get(position).getDate().split("-")[2];
            viewHolder.shujukuDetlDate.setText(month + "月" + day + "日");
            String hour = list.get(position).getTime().split(":")[0];
            if (Integer.parseInt(hour) > 12) {
                viewHolder.shujukuDetlTime.setText("下午" + list.get(position).getTime());
            } else {
                viewHolder.shujukuDetlTime.setText("上午" + list.get(position).getTime());
            }
            viewHolder.shujukuDetlXueya.setText(list.get(position).getGaoya() + "/" + list.get(position).getDiya());
            return convertView;
        }

        class ViewHolder {
            @Bind(R.id.shujuku_detl_xueya)
            TextView shujukuDetlXueya;
            @Bind(R.id.shujuku_detl_time)
            TextView shujukuDetlTime;
            @Bind(R.id.shujuku_detl_date)
            TextView shujukuDetlDate;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }

}

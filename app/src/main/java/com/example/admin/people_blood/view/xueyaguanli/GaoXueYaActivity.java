package com.example.admin.people_blood.view.xueyaguanli;

import android.content.Intent;
import android.util.Log;
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
import com.example.admin.people_blood.bean.GaoXueYaDetil;
import com.example.admin.people_blood.bean.GaoXueYaZiXun;
import com.example.admin.people_blood.presenter.GaoXueYaActivityPresenter;
import com.example.admin.people_blood.utils.DateUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名称: 血压宝
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/11 20:18
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class GaoXueYaActivity extends BaseActivity implements GaoXueXueYaActivityImpl {

    @Bind(R.id.image_Back)
    ImageView imageBack;
    @Bind(R.id.Center_Text)
    TextView CenterText;
    @Bind(R.id.gaoxueya_listView)
    ListView gaoxueyaListView;
    private String typeid;
    private String dir;
    private GaoXueYaActivityPresenter Presenter;
    private List<GaoXueYaZiXun.DataBean> data;

    @Override
    protected int layoutId() {
        return R.layout.activity_gaoxueya;
    }

    @Override
    protected void initView() {

        Intent intent = getIntent();
        if (intent != null) {
            typeid = intent.getStringExtra("typeid");
            dir = intent.getStringExtra("dir");
        } else {
            typeid = "18031";
            dir = "zhuanti_nk";
        }
        Presenter = new GaoXueYaActivityPresenter(this);
    }

    @Override
    protected void loadData() {
        Presenter.getHttp();

    }

    @Override
    protected void listener() {
        gaoxueyaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GaoXueYaZiXun.DataBean dataBean = data.get(position);
                Intent intent = new Intent(GaoXueYaActivity.this,WenZhangDetil.class);
                intent.putExtra("wen_id",dataBean.getId());
                intent.putExtra("wen_dir",dir);
                startActivity(intent);
            }
        });
    }

    @OnClick(R.id.image_Back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public String getTypeid() {
        return typeid;
    }

    @Override
    public String getDir() {
        return dir;
    }

    @Override
    public void getSucc(GaoXueYaZiXun gaoXueYaZiXun) {
        data = gaoXueYaZiXun.getData();
        gaoxueyaListView.setAdapter(new MyGaoxueYaAdapter(gaoXueYaZiXun.getData()));
    }

    @Override
    public void getFal(String string) {
        Log.e("TAG", "失败-----" + string);
    }

    @Override
    public void getItemSucc(GaoXueYaDetil gaoXueYaDetil) {

    }

    class MyGaoxueYaAdapter extends BaseAdapter {
        private List<GaoXueYaZiXun.DataBean> list;

        public MyGaoxueYaAdapter(List<GaoXueYaZiXun.DataBean> list) {
            this.list = list;
        }

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
                convertView = LayoutInflater.from(GaoXueYaActivity.this).inflate(R.layout.item_gaoxueya, null);
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.itemGaoxueyaTitle.setText(list.get(position).getTitle());
            viewHolder.itemGaoxueyaContent.setText(list.get(position).getDescription());
            long date = Long.parseLong(list.get(position).getPubdate());
            viewHolder.itemGaoxueyaDate.setText(DateUtils.format(date, "yyyy-MM-dd"));
            return convertView;
        }

        class ViewHolder {
            @Bind(R.id.item_gaoxueya_title)
            TextView itemGaoxueyaTitle;
            @Bind(R.id.item_gaoxueya_date)
            TextView itemGaoxueyaDate;
            @Bind(R.id.item_gaoxueya_content)
            TextView itemGaoxueyaContent;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }
}

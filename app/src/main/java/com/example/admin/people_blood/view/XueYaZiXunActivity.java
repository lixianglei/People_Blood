package com.example.admin.people_blood.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.people_blood.App;
import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名称: 血压宝
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/10 17:44
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class XueYaZiXunActivity extends BaseActivity {

    @Bind(R.id.image_Back)
    ImageView imageBack;
    @Bind(R.id.Center_Text)
    TextView CenterText;
    @Bind(R.id.zixun_gridview)
    GridView zixunGridview;
    private int[] images = {R.drawable.zixun_1,
            R.drawable.zixun_2,
            R.drawable.zixun_3,
            R.drawable.zixun_4,
            R.drawable.zixun_5};

    @Override
    protected int layoutId() {
        return R.layout.activity_xueyazixun;
    }

    @Override
    protected void initView() {
        CenterText.setText("血压资讯");

    }

    @Override
    protected void loadData() {
        zixunGridview.setAdapter(new MyZiXunAdapter());
    }

    @Override
    protected void listener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.image_Back)
    public void onViewClicked() {
    }

    class MyZiXunAdapter extends BaseAdapter {

        @Override
        public int getCount() {

            return images.length;
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
                convertView = LayoutInflater.from(App.baseActivity).inflate(R.layout.item_zixun, null);
                viewHolder = new ViewHolder();
                viewHolder.imageView = (ImageView) convertView.findViewById(R.id.item_zixun);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.imageView.setImageResource(images[position]);
            return convertView;
        }

        private class ViewHolder {
            ImageView imageView;
        }
    }
}

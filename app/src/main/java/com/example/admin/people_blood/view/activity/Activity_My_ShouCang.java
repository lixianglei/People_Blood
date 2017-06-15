package com.example.admin.people_blood.view.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.adapter.MyAdapter;
import com.example.admin.people_blood.base.BaseActivity;
import com.example.admin.people_blood.bean.ShouCang;
import com.example.admin.people_blood.modle.callback.ResaultCallBack;
import com.example.admin.people_blood.modle.http.RetrofitUtil;
import com.example.admin.people_blood.utils.UserUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by d on 2017/6/10.
 */

public class Activity_My_ShouCang extends BaseActivity {
    @Bind(R.id.left_layout)
    RelativeLayout leftLayout;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.left_image)
    ImageView leftImage;
    @Bind(R.id.collection_listview)
    ListView collectionListview;
    private String id;
    ProgressDialog waitingDialog;
    private List<ShouCang.DataBean> mList = new ArrayList<>();
    private MyAdapter myAdapter;
    private ListView listView;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 200) {
                waitingDialog.dismiss();
            }
        }
    };

    @Override
    protected int layoutId() {
        return R.layout.my_collection;
    }

    @Override
    protected void initView() {
        id = UserUtils.getUSERID();
        listView = (ListView) findViewById(R.id.collection_listview);
        myAdapter = new MyAdapter(this, mList);
        listView.setAdapter(myAdapter);

    }

    @Override
    protected void loadData() {
        handler.sendEmptyMessageDelayed(200, 2000);
        showWaitingDialog();
        Map<String, String> map = new HashMap();
        map.put("xywy_userid", id);
        map.put("tag", "BloodAndroid");
        map.put("sign", "2c19b2821ebc5306c3ac37bac5b4288b");
        map.put("app_id", "2");
        RetrofitUtil.getInstance().postRetrofit("http://api.yun.xywy.com/index.php/app/collect/list_data/111", map, new ResaultCallBack() {
            @Override
            public void onSuccess(Object obj) {
                ShouCang shouCangbean = (ShouCang) obj;
                List<ShouCang.DataBean> dataBeen = shouCangbean.getData();
                mList.addAll(dataBeen);
                myAdapter.notifyDataSetChanged();


            }

            @Override
            public void onError(String errorMsg) {

            }

            @Override
            public void notNet(String netData) {

            }

            @Override
            public void onErrorParams(String errorParams) {

            }
        }, ShouCang.class);


    }

    @Override
    protected void listener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ShouCang.DataBean bean = mList.get(position);
                String categoryid = bean.getCategoryid();

            }
        });

    }

    private void showWaitingDialog() {
        waitingDialog =
                new ProgressDialog(Activity_My_ShouCang.this);
        waitingDialog.setMessage("等待中...");
        waitingDialog.setIndeterminate(true);
        waitingDialog.setCancelable(false);
        waitingDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

}

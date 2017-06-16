package com.example.admin.people_blood.view.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

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

/**
 * Created by d on 2017/6/10.
 */

public class Activity_My_ShouCang extends BaseActivity {

    @Bind(R.id.left_image)
    ImageView leftImage;
    @Bind(R.id.left_layout)
    RelativeLayout leftLayout;
    @Bind(R.id.WoDe_ShouCang)
    ListView WoDeShouCang;
    private String id;
    ProgressDialog waitingDialog;
    private List<ShouCang.DataBean> mList = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected int layoutId() {
        return R.layout.actitivty_shoucang;
    }

    @Override
    protected void initView() {
        id = UserUtils.getUSERID();
        WoDeShouCang = (ListView) findViewById(R.id.WoDe_ShouCang);
        myAdapter = new MyAdapter(this, mList);
        WoDeShouCang.setAdapter(myAdapter);
    }

    @Override
    protected void loadData() {
//        showWaitingDialog();

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
        leftImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.left_image:
                        finish();
                }
            }
        });
        WoDeShouCang.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ShouCang.DataBean bean = mList.get(position);
                String categoryid = bean.getCategoryid();
                Intent intent = new Intent(Activity_My_ShouCang.this, ShouCang_XiangQing.class);
                intent.putExtra("111", categoryid);
                startActivity(intent);

            }
        });


    }
    private void showWaitingDialog() {
        waitingDialog = new ProgressDialog(Activity_My_ShouCang.this);
        waitingDialog.setMessage("等待中...");
        waitingDialog.setIndeterminate(true);
        waitingDialog.setCancelable(false);
        waitingDialog.show();
    }
}

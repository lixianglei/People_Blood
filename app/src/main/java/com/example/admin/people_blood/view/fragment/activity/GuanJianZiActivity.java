package com.example.admin.people_blood.view.fragment.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.adapter.GuanJianZiAdapter;
import com.example.admin.people_blood.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GuanJianZiActivity extends BaseActivity {


    @Bind(R.id.GuanJianZi_EditText)
    EditText GuanJianZiEditText;
    @Bind(R.id.GuanJianZi_Sure)
    TextView GuanJianZiSure;
    @Bind(R.id.GuanJianZi_ListView)
    ListView GuanJianZiListView;
   private GuanJianZiAdapter  mAdapter;
    private List<String>  mList;
    @Override
    protected int layoutId() {
        return R.layout.guanjianzi;
    }

    @Override
    protected void initView() {
        mList=new ArrayList<>();
        mAdapter=new GuanJianZiAdapter(mList,GuanJianZiActivity.this);
        GuanJianZiListView.setAdapter(mAdapter);
    }

    @Override
    protected void loadData() {

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

    @OnClick(R.id.GuanJianZi_Sure)
    public void onViewClicked() {
    }
}

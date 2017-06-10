package com.example.admin.people_blood.view.fragment.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.adapter.GuanJianZiAdapter;
import com.example.admin.people_blood.base.BaseActivity;
import com.example.admin.people_blood.modle.db.Manager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.os.Build.VERSION_CODES.M;

public class GuanJianZiActivity extends BaseActivity {

   private Manager  mManager;
    @Bind(R.id.GuanJianZi_EditText)
    EditText GuanJianZiEditText;
    @Bind(R.id.GuanJianZi_Sure)
    TextView GuanJianZiSure;
    @Bind(R.id.GuanJianZi_ListView)
    ListView GuanJianZiListView;
   private GuanJianZiAdapter  mAdapter;
    private List<String>  mList;
    private SharedPreferences  mShared;
    private SharedPreferences.Editor  mEditor;
    @Override
    protected int layoutId() {
        return R.layout.guanjianzi;
    }

    @Override
    protected void initView() {
        mShared=getSharedPreferences("data",MODE_PRIVATE);
        mEditor=mShared.edit();
        mManager=new Manager(GuanJianZiActivity.this);
        mList=mManager.getList();
        mAdapter=new GuanJianZiAdapter(mList,GuanJianZiActivity.this);
        GuanJianZiListView.setAdapter(mAdapter);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void listener() {

    }



    @OnClick(R.id.GuanJianZi_Sure)
    public void onViewClicked() {
        if (GuanJianZiEditText.getText().toString().isEmpty()){
            Toast.makeText(this, "关键字不能为空", Toast.LENGTH_SHORT).show();
        }else{
         String name= GuanJianZiEditText.getText().toString();
            mEditor.putString("name",name);
            mEditor.commit();
            boolean insert = mManager.insert(name);
            if (insert){
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "插入失败", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

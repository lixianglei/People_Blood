package com.example.admin.people_blood.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.example.admin.people_blood.App;
import butterknife.ButterKnife;

/**
 *
 * 项目名称: 血压卫士
 * 类描述: Activity的基类
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/9 20:12
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//dsa
        setContentView(layoutId());
        ButterKnife.bind(this);
        App.activity=this;
        initView();
        loadData();
        listener();
    }
    public void setData(){


    }
    //指定布局
    protected abstract int layoutId();

    //初始化数据
    protected abstract void initView();


    //加载数据
    protected abstract void loadData();

    //加载监听
    protected abstract void listener();

    @Override
    protected void onResume() {
        super.onResume();
        App.activity = this;
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}

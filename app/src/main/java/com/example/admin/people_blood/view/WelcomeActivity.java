package com.example.admin.people_blood.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.widget.ImageView;

import com.example.admin.people_blood.MainActivity;
import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;
import com.example.admin.people_blood.presenter.WelcomeActivityPresenter;

import butterknife.Bind;

/**
 * 项目名称: 血压宝
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/10 10:27
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class WelcomeActivity extends BaseActivity implements WelcomeActivityimpl {
    @Bind(R.id.welcome_id)
    ImageView welcomeId;
    private ObjectAnimator objectAnimator;
    private WelcomeActivityPresenter welcomeActivityPresenter;

    @Override
    protected int layoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {
        welcomeActivityPresenter = new WelcomeActivityPresenter(this);
    }

    @Override
    protected void loadData() {
        objectAnimator = ObjectAnimator.ofFloat(welcomeId, "alpha", 0f, 1f);
        objectAnimator.setDuration(1000);
        objectAnimator.start();
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                welcomeActivityPresenter.tiao();
            }
        });
    }

    @Override
    protected void listener() {

    }


    @Override
    public void tiao() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

package com.example.admin.people_blood.view.view1;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.example.admin.people_blood.utils.DimenUtils;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/16 14:29
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ZhuZhuangView  extends View{
    //屏幕的高度
    private int windowHeight;
    //屏幕的宽度
    private int windowWeight;
    //view的高度
    private int viewHeight;
    //view的宽度
    private  int viewWeight;

    public ZhuZhuangView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ZhuZhuangView(Context context) {
        super(context);
    }

    public ZhuZhuangView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获取屏幕高度
        windowHeight= DimenUtils.getScreenHeight();
        //获取屏幕宽度；
        windowWeight=DimenUtils.getScreenWidth();
        //每个view的宽度
        viewWeight=windowWeight/8;
        //每个view高度
        viewHeight=windowHeight/15;

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}

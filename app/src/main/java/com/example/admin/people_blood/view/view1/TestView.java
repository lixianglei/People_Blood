package com.example.admin.people_blood.view.view1;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.IInterface;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.admin.people_blood.utils.DimenUtils;

import static com.baidu.location.d.j.o;


/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: 陈瑶瑶
 * 创建时间: 2017/6/16 14:46
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class TestView extends LinearLayout {
    //获取上下文对象
    private Context  context;
    //获取屏幕高度
    private int windowHeight;
    //获取屏幕宽度
    private int windowWeight;
    //每个view的高度
    private int viewHieght;
    //每个view的宽度
    private int viewWeight;
    //左边距
     private int marginLeft;
    //上边距
     private int marginTop;
    private Paint  xianPaint;
    public TestView(Context context) {
        super(context);
    }

    public TestView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        windowHeight= DimenUtils.getScreenHeight();
        windowWeight=DimenUtils.getScreenWidth();
        viewHieght=windowHeight/8;
        viewWeight=windowWeight/15;
         setWillNotDraw(false);
        //左边距默认为view的宽度；
        marginLeft=viewWeight;
        //上边距默认为0；
        marginTop=0;
         xianPaint=new Paint();
        xianPaint.setColor(Color.parseColor("#000000"));
        xianPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }
}

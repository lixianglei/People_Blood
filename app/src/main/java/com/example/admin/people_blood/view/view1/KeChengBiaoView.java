package com.example.admin.people_blood.view.view1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.admin.people_blood.utils.DimenUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 项目名称: 血压宝
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/14 17:26
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class KeChengBiaoView extends LinearLayout {
    //上下文对象
    private Context context;
    //屏幕高度
    private int windowHeight;
    //屏幕宽度
    private int windowWidth;
    //每个view的宽度
    private int viewWidth;
    //每个view的高度 这里常量
    private int viewHeight;
    //用于设置view的宽和高
    private LayoutParams params;
    //星期数组
    private String[] sunday = {"一", "二", "三", "四", "五", "六", "七"};
    //时间数组
    private String[] day = {"上午", "下午", "晚上"};
    //左边距 就是左
    private int marginleft;
    //上边距 就是上
    private int marginTop;
    //解决layout执行两边的异常
    private boolean aBoolean;
    //用于存储调用对外公开的方法 添加的view 存进map集合 以便删除
    private Map<String, Integer> map;
    private Paint linePaint;
    private boolean isDraw;

    public KeChengBiaoView(Context context) {
        this(context, null);
    }

    public KeChengBiaoView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public KeChengBiaoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        map = new HashMap<>();
        this.context = context;
        //获取屏幕高度
        windowHeight = DimenUtils.getScreenHeight();
        //获取屏幕宽度
        windowWidth = DimenUtils.getScreenWidth();
        //每个子view的宽度为屏幕宽度的8分之1
        viewWidth = windowWidth / 8;
        viewHeight=windowHeight/15;
        setWillNotDraw(false);
        //左边距默认为view的宽度
        marginleft = viewWidth;
        //默认上边距为0
        marginTop = 0;
        //画笔设置颜色
        linePaint = new Paint();
        linePaint.setColor(Color.parseColor("#000000"));
        linePaint.setAntiAlias(true);
//        params = new LayoutParams(viewWidth, viewHeight);
        //其实最后发现这里设置这个已经没啥用了
        params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, (float) 0.5);
        //初始化默认的view
        initView();
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        marginleft = viewWidth;
        marginTop = viewHeight;
        //这是划线
        float[] lines = {
                0,0,windowWidth,0,
                0, viewHeight, windowWidth, viewHeight,
                0, viewHeight * 2, windowWidth, viewHeight * 2,
                0, viewHeight * 3, windowWidth, viewHeight * 3,
                0, viewHeight * 4, windowWidth, viewHeight * 4,
                viewWidth * 1, 0, viewWidth * 1, viewHeight * 4,
                viewWidth * 2, 0, viewWidth * 2, viewHeight * 4,
                viewWidth * 3, 0, viewWidth * 3, viewHeight * 4,
                viewWidth * 4, 0, viewWidth * 4, viewHeight * 4,
                viewWidth * 5, 0, viewWidth * 5, viewHeight * 4,
                viewWidth * 6, 0, viewWidth * 6, viewHeight * 4,
                viewWidth * 7, 0, viewWidth * 7, viewHeight * 4};
        canvas.drawLines(lines, linePaint);
        //---------------------画字体
        linePaint.setTextSize(50);
        for (int i = 0; i < sunday.length; i++) {
            //这里获取到当前字体的宽度
            float stringWidth = linePaint.measureText(sunday[i]);
            float x = ((viewWidth - stringWidth) / 2) + marginleft;
            //这里获取到字体的高度
            Paint.FontMetrics fontMetrics = linePaint.getFontMetrics();
            float y = viewHeight / 2 + (Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2;
            canvas.drawText(sunday[i], x, y, linePaint);
            marginleft += viewWidth;
        }

        for (int i = 0; i < day.length; i++) {
            float stringWidth = linePaint.measureText(day[i]);
            float x = ((viewWidth - stringWidth) / 2);
            Paint.FontMetrics fontMetrics = linePaint.getFontMetrics();
            float y = (viewHeight / 2 + (Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2) + marginTop;
            canvas.drawText(day[i], x, y, linePaint);
            marginTop += viewHeight;
        }
    }

    private void initView() {

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//         计算出所有的childView的宽和高
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        //设置总view的宽度 这里简单 宽度为屏幕宽度 高度为4个字view的宽度 后面优化布局的话会改变
        setMeasuredDimension(windowWidth, viewHeight * 4);
    }

    /**
     * @param sun 星期 1 到 7
     * @param sunType   上午1 中午 2 下午 3
     */
    public void setSunDay(String  sun,String sunType) {
        int  sunday=0;
        int   type=0;
        switch (sun){
            case  "星期一":
               sunday=1;
                break;
            case  "星期二":
               sunday=2;
                break;
            case  "星期三":
                sunday=3;
                break;
            case  "星期四":
                sunday=4;
                break;
            case  "星期五":
                sunday=5;
                break;
            case  "星期六":
                sunday=6;
                break;
            case  "星期七":
                sunday=7;
                break;

        }
        if (sunType.contains("上午")){
            type=1;
        }
        else  if (sunType.contains("下午")){
            type=2;
        }
        else  if (sunType.contains("晚上")){
            type=3;
        }
        //这里判断用户输入的sunday值和type是否正确 不正确 直接Toast 同时return
        if (sunday == 0 || sunday > 7 || type == 0 || type > 3) {

            Toast.makeText(context, "请输入正确的星期或者时间", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.e("haha", getChildCount() + "");
        Log.e("haha", "添加是索引" + String.valueOf(sunday) + String.valueOf(type));
        if (map.get(String.valueOf(sunday) + String.valueOf(type)) != null) {
            int index = map.get(String.valueOf(sunday) + String.valueOf(type));
            map.remove(String.valueOf(sunday) + String.valueOf(type));
            removeViewAt(index);
            chongzhimap(index);
            addView(sunday, type);
        } else {
            addView(sunday, type);
        }


    }

    /**
     * 这里是添加view的方法
     *
     * @param sunday
     * @param type
     */
    private void addView(int sunday, int type) {

        /**
         * 这里由于你添加view 所以当前添加的view索引一定是没添加之前的总子view数
         * key值我想了很久 最后不让重复只能是把当前的2个int值转成 String 值 然后2个拼接起来 才不会重复
         * value值为添加view的索引
         */
        map.put(String.valueOf(sunday) + String.valueOf(type), getChildCount());
        //这个view的左边距等于 你输入的星期几 乘以 每个view的宽度
        int left = viewWidth * sunday;
        //这里每个view的上边距为 你输入的时间 乘以每个子view的高度
        int top = viewHeight * type;
        TextView textView = new TextView(context);
        textView.setLayoutParams(params);
        textView.setTextSize(15);
        textView.setText("专家");
//        textView.setGravity(Gravity.CENTER);
//        textView.setHint("专家");

        textView.setBackgroundColor(Color.parseColor("#16DCC7"));
        addView(textView);
        textView.layout(left, top, left + viewWidth, top + viewHeight);
    }

    /**
     * 这个是删除view的方法
     *
     * @param sunday
     * @param type
     */
    public void deleteview(int sunday, int type) {
        //判断当前有没有view
        if (map.get(String.valueOf(sunday) + String.valueOf(type)) != null) {
            Log.e("haha", "删除时索引---" + String.valueOf(sunday) + String.valueOf(type));
            //得到当前的索引
            int index = map.get(String.valueOf(sunday) + String.valueOf(type));
            Log.e("haha", index + "");
            //把当前索引的view删除掉
            removeViewAt(index);
            //在map集合里也删除掉
            map.remove(String.valueOf(sunday) + String.valueOf(type));
            chongzhimap(index);

        } else {
            Toast.makeText(context, "没有东西哦", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * 重置map集合的方法
     *
     * @param index
     */
    private void chongzhimap(int index) {
        /**
         * 这里
         * 由于这个viewgroup的索引是不断变化的 如果我删除了一个view
         * 在他后面的view索引就应该全部减一 在他前面的不减
         * 所以
         * 我遍历这个map集合
         * 得到所有的值
         * 这里要清楚 虽然我删除了view viewgroup的索引已经发生变化
         * 但是我map集合的索引还没有变化
         * 如果我那个map集合的value值比当前删除的索引大了 那么他就应该减一
         */
        Set<String> strings = map.keySet();
        for (String string : strings) {
            if (map.get(string) > index) {
                map.put(string, map.get(string) - 1);
            }

        }
    }
}

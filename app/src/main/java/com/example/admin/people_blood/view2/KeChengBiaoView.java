package com.example.admin.people_blood.view2;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
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
 * 创建人:
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
    private final int viewHeight = 50;
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
        //左边距默认为屏幕的宽度
        marginleft = viewWidth;
        //默认上边距为0
        marginTop = 0;
//        params = new LayoutParams(viewWidth, viewHeight);
        //其实最后发现这里设置这个已经没啥用了
        params = new LayoutParams(200, 200);
        //初始化默认的view
        initView();
    }

    private void initView() {

        Log.e("TAG", "0----->" + System.currentTimeMillis());
//遍历包含星期的数组
        for (int i = 0; i < sunday.length; i++) {
            TextView textView = new TextView(context);
            textView.setLayoutParams(params);
            textView.setText(sunday[i]);
            textView.setTextSize(15);
            textView.setTextColor(Color.parseColor("#000000"));
//            textView.setGravity(Gravity.CENTER);
            addView(textView);
        }
        //遍历为时间的数组
        for (int i = 0; i < day.length; i++) {
            TextView textView = new TextView(context);
            textView.setLayoutParams(params);
            textView.setText(day[i]);
            textView.setTextSize(15);
            textView.setTextColor(Color.parseColor("#000000"));
            addView(textView);
        }

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        // 计算出所有的childView的宽和高
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        //设置总view的宽度 这里简单 宽度为屏幕宽度 高度为4个字view的宽度 后面优化布局的话会改变
        setMeasuredDimension(windowWidth, viewHeight * 4);
//  int width;
//        int height;
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
//        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
//        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
//        int count = getChildCount();
//        View childAt = getChildAt(0);
//        View childAt1 = getChildAt(1);
//        childAt.setMinimumWidth(300);
//        childAt.setMinimumHeight(300);
//        childAt1.setMinimumWidth(300);
//        childAt1.setMinimumHeight(300);
//        width = childAt.getWidth() + childAt1.getWidth();
//        height = childAt.getHeight() + childAt1.getHeight();
//        setMeasuredDimension((widthMode == MeasureSpec.EXACTLY) ? sizeWidth
//                : width, (heightMode == MeasureSpec.EXACTLY) ? sizeHeight
//                : height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        super.onLayout(changed, l, t, r, b);
//        int childCount = getChildCount();
//        View view1 = getChildAt(0);
//        View view2 = getChildAt(1);
//        view1.layout(100, 300, 100 + view1.getWidth(), 300 + view1.getHeight());
//        Log.e("TAG", getChildCount() + "1----->" + System.currentTimeMillis());
//防止调用2次 出错
        if (!aBoolean) {
            aBoolean = true;
            //遍历所有已经添加的子view
            for (int i = 0; i < getChildCount(); i++) {
                //i<=6 的时候是星期的view
                if (i <= 6) {
                    Log.d("KeChengBiaoView", "getChildCount():" + getChildCount());
                    TextView view = (TextView) getChildAt(i);

                    Log.d("TAG", "--所有数据---->" + marginleft + "--" + marginTop + "--" + viewWidth + "---" + viewHeight);
                    view.layout(marginleft, marginTop, marginleft + viewWidth, marginTop + viewHeight);
                    marginleft += viewWidth;
                } else {
                    //重置左边距
                    marginleft = 0;
                    //同时上边距为当前的上边距 加 一个字view的高度
                    marginTop += viewHeight;
                    View view = getChildAt(i);
                    view.layout(marginleft, marginTop, marginleft + viewWidth, marginTop + viewHeight);
                }
            }


        }
    }

    /**
     * @param sunday 星期 1 到 7
     * @param type   上午1 中午 2 下午 3
     */
    public void setSunDay(int sunday, int type) {
        //这里判断用户输入的sunday值和type是否正确 不正确 直接Toast 同时return
        if (sunday == 0 || sunday > 7 || type == 0 || type > 3) {
            Toast.makeText(context, "请输入正确的星期或者时间", Toast.LENGTH_SHORT).show();
            return;
        }

        Log.e("haha", getChildCount() + "");
        Log.e("haha", "添加是索引" + String.valueOf(sunday) + String.valueOf(type));
        try {
            int index = map.get(String.valueOf(sunday) + String.valueOf(type));
            map.remove(String.valueOf(sunday) + String.valueOf(type));
            removeViewAt(index);
            chongzhimap(index);
            addView(sunday, type);
        } catch (Exception e) {
            addView(sunday, type);
        }


    }

    /**
     * 这里是添加view的方法
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
        textView.setBackgroundColor(Color.parseColor("#000000"));
        addView(textView);
        textView.layout(left, top, left + viewWidth, top + viewHeight);
    }

    /**
     * 这个是删除view的方法
     * @param sunday
     * @param type
     */
    public void deleteview(int sunday, int type) {
        //这里 try catch 是由于我这里的判断出了问题 解决后会把这个try catch删掉
        try {
            //先map.get() 这里由于没判断好 找不到就会报异常 只能用try catch了
            if (map.get(String.valueOf(sunday) + String.valueOf(type)) != null || map.get(String.valueOf(sunday) + String.valueOf(type)) != 0) {
                Log.e("haha", "删除时索引---" + String.valueOf(sunday) + String.valueOf(type));
                //得到当前的索引
                int index = map.get(String.valueOf(sunday) + String.valueOf(type));
                Log.e("haha", index + "");
                //把当前索引的view删除掉
                removeViewAt(index);
                //在map集合里也删除掉
                map.remove(String.valueOf(sunday) + String.valueOf(type));
                chongzhimap(index);

            }
        } catch (Exception e) {
            //异常的话说明我的map集合里面没有这个数据 Toast
            Toast.makeText(context, "没有内容", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * 重置map集合的方法
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

package com.example.admin.people_blood.view.fragment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.example.admin.people_blood.R;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/10 08:38
 * 修改人:
 * 修改内容:
 * 修改时间:
 *
 */

public class NavView extends View{
    private Paint textPaint = new Paint();
    private String[] s = new String[]{
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z", "#"};
    //鼠标点击、滑动时选择的字母
    private int choose = -1;
    //中间的文本
    private TextView tv;

    public NavView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NavView(Context context) {
        super(context);
    }

    public NavView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initPaint() {
        textPaint.setTextSize(20);
        textPaint.setAntiAlias(true);
        textPaint.setColor(getResources().getColor(R.color.colorZiMu));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画字母
        drawText(canvas);
    }


    /**
     * 画字母
     *
     * @param canvas
     */
    private void drawText(Canvas canvas) {
        //获取View的宽高
        int width = getWidth();
        int height = getHeight();
        //获取每个字母的高度
        int singleHeight = height / s.length;
        //画字母
        for (int i = 0; i < s.length; i++) {
            //画笔默认颜色
            initPaint();
            //高亮字母颜色
            if (choose == i) {
                textPaint.setColor(Color.RED);
            }
            //计算每个字母的坐标
            float x = (width - textPaint.measureText(s[i])) / 2;
            float y = (i + 1) * singleHeight;
            canvas.drawText(s[i], x, y, textPaint);
            //重置颜色
            textPaint.reset();
        }
    }

}

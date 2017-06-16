package com.example.admin.people_blood.view.view1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.admin.people_blood.utils.DimenUtils;


/**
 * 项目名称: 血压宝
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/15 20:52
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ChangZhuView extends View {

    private int viewWidth;
    private int windowHeight;
    private int windowWidth;
    private int viewHeight;
    private Paint shousuopaint;
    private Paint shuZhangPaint;
    private Paint linePaint;
    private Paint topPaint;
    private int zonggao;
    private float marginleft;
    private float dibuHeight;
    private float shousuoya;
    private float shuZhangYa;
    private int shouSuoYaText;
    private int shuZhangYaText;
    private float delte;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(shouSuoYaText>0){
                float[] shuzu = (float[]) msg.obj;

                float ssy = (int) (shuzu[0]-szydelte);
                float szy = (int) (shuzu[1]-1);
                shuaxin(ssy,szy);
                Message message = new Message();
                message.what = 1;
                float[] shuzu1 = {(int) ssy, (int) szy};
                message.obj = shuzu1;
                handler.sendMessageDelayed(message,200);
            }


        }
    };
    private float bilissy;
    private float biliszy;
    private float deletessy;
    private float deleteszy;
    private float szydelte;

    public ChangZhuView(Context context) {
        this(context, null);
    }

    public ChangZhuView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChangZhuView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        windowHeight = DimenUtils.getScreenHeight();
        windowWidth = DimenUtils.getScreenWidth();

        viewWidth = windowWidth / 8;
        zonggao = windowHeight / 2;
        marginleft = (float) ((viewWidth * 5) / 2);
        dibuHeight = 50;
        shousuoya  =  zonggao;
        shuZhangYa = zonggao;
        shuZhangYaText = 0;
        shuZhangYaText = 0;
        linePaint = new Paint();
        linePaint.setColor(Color.parseColor("#000000"));
        linePaint.setTextSize(50);
        topPaint = new Paint();
        topPaint.setColor(Color.parseColor("#999999"));
        topPaint.setTextSize(60);
        shousuopaint = new Paint();
        shousuopaint.setColor(Color.parseColor("#F6C51C"));
        shuZhangPaint = new Paint();
        shuZhangPaint.setColor(Color.parseColor("#52CCFB"));


    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        canvas.drawRect(marginleft, shousuoya, viewWidth + marginleft, zonggao, shousuopaint);
        canvas.drawRect(marginleft + (viewWidth * 2), shuZhangYa, viewWidth + (marginleft + (viewWidth * 2)), zonggao, shuZhangPaint);
        int lines = zonggao;
        canvas.drawLine(0, lines, windowWidth, lines, linePaint);
        float v = linePaint.measureText("收缩压");
        float x1 = (viewWidth - v) / 2 + marginleft;
        Paint.FontMetrics fontMetrics = linePaint.getFontMetrics();
        float y = (dibuHeight / 2 + (Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2) + zonggao;
        canvas.drawText("收缩压", x1, y + 10, linePaint);
        float v1 = linePaint.measureText("舒张压");
        float x2 = (viewWidth - v) / 2 + marginleft + (viewWidth * 2);
        canvas.drawText("舒张压", x2, y + 10, linePaint);
        //长方体上面的字体
            float v3 = linePaint.measureText(String.valueOf(shouSuoYaText));
            float x3 = (viewWidth - v3) / 2 + marginleft;
            Paint.FontMetrics topMetrics = topPaint.getFontMetrics();
            float y3 = (dibuHeight / 2 + (Math.abs(topMetrics.ascent) - topMetrics.descent) / 2) + shousuoya - dibuHeight - 5;
            canvas.drawText(String.valueOf(shouSuoYaText), x3, y3, topPaint);

            float v4 = linePaint.measureText(String.valueOf(shuZhangYaText));
            float x4 = (viewWidth - v3) / 2 + marginleft + (viewWidth * 2);
            float y4 = (dibuHeight / 2 + (Math.abs(topMetrics.ascent) - topMetrics.descent) / 2) + shuZhangYa - dibuHeight - 5;
            canvas.drawText(String.valueOf(shuZhangYaText), x4, y4, topPaint);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(windowWidth, (int) (zonggao + dibuHeight + 10));
    }

    /**
     * 对外提供的调整血压的方法
     * 这里我的血压最高为200
     *
     * @param ssy 收缩压
     * @param szy 舒张压
     */
    public void setXueYa(int ssy, int szy) {

        shuaxin(ssy, szy);

    }

    private void shuaxin(float ssy, float szy) {
        bilissy = (float) (ssy / 200.0);
        biliszy = (float) (szy / 200.0);
        float shijissy = bilissy * zonggao;
        shousuoya = zonggao - shijissy;
        float shijiszy = biliszy * zonggao;
        shuZhangYa = zonggao - shijiszy;
        shouSuoYaText = (int) ssy;
        shuZhangYaText = (int) szy;
        invalidate();
    }

    public void stopCeliang(){
        double st = Double.parseDouble(shuZhangYaText+".0");
        szydelte = (float) (shouSuoYaText/st)-0.3f;
        Log.e("TAG",szydelte+"---");

        Message message = new Message();
        message.what = 1;
        float[] shuzu = {shouSuoYaText,shuZhangYaText};
        message.obj = shuzu;
        handler.sendMessageDelayed(message,200);



    }
}

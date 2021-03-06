package com.example.admin.people_blood.view.activity;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.people_blood.R;

import butterknife.Bind;


/**
 * Created by d on 2017/6/12.
 */

public class NumEditText extends RelativeLayout {
    //类型1(单数类型)：TextView显示总字数，然后根据输入递减.例：100，99，98
    //类型2(百分比类型)：TextView显示总字数和当前输入的字数，例：0/100，1/100，2/100
    public static final String SINGULAR = "Singular";//类型1(单数类型)
    public static final String PERCENTAGE = "Percentage";//类型2(百分比类型)
    @Bind(R.id.update_back)
    ImageView updateBack;
    @Bind(R.id.askDocotor_Editext)
    EditText askDocotorEditext;
    @Bind(R.id.MyText)
    TextView MyText;
    @Bind(R.id.MainActivity_Button1)
    RadioButton MainActivityButton1;
    @Bind(R.id.MainActivity_Button2)
    RadioButton MainActivityButton2;
    @Bind(R.id.Edit)
    EditText Edit;
    @Bind(R.id.TiJiao_ShuJu)
    Button TiJiaoShuJu;
    @Bind(R.id.imageView)
    ImageView imageView;
    private EditText etContent, i;//文本框
    private TextView tvNum;//字数显示TextView
    private View vLine;//底部横线
    private String TYPES = SINGULAR;//类型
    private int MaxNum = 600;//最大字符
    private Button Mbtn;
    private PopupWindow popupWindow;
    private View popupView;

    public NumEditText(Context context) {
        this(context, null);
    }

    public NumEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.activity_wendoctor, this, true);
        etContent = (EditText) findViewById(R.id.askDocotor_Editext);
        tvNum = (TextView) findViewById(R.id.MyText);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.imageView:

//                        menuWindow=new SelectPicPopupWindow(getContext(),itemsOnClick);
                        Toast.makeText(getContext(), "点击事件", Toast.LENGTH_SHORT).show();

                }
            }
        });
//        //显示窗口
//        menuWindow.showAtLocation(getContext(), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0); //设置layout在PopupWindow中显示的位置


        Mbtn = (Button) findViewById(R.id.TiJiao_ShuJu);
        Mbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etContent.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "你的网络有点慢哦！", Toast.LENGTH_SHORT).show();
                }
            }
        });
//        vLine = findViewById(R.id.vLine);
    }

    private void changeIcon() {
        popupView = View.inflate(getContext(), R.layout.item_change_icon, null);

    }

    /**
     * 设置显示
     *
     * @return
     */
    public NumEditText show() {
        if (TYPES.equals(SINGULAR)) {//类型1
            tvNum.setText(String.valueOf(MaxNum));
        } else if (TYPES.equals(PERCENTAGE)) {//类型2
            tvNum.setText(0 + "/" + MaxNum);
        }
        //设置长度
        etContent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(MaxNum)});
        //监听输入
        etContent.addTextChangedListener(mTextWatcher);
        return this;
    }

    /**
     * 设置横线颜色
     *
     * @param color --颜色值
     * @return
     */
    public NumEditText setLineColor(String color) {
//        vLine.setBackgroundColor(Color.parseColor(color));
        return this;
    }

    /**
     * 设置类型
     *
     * @param type --类型
     * @return
     */
    public NumEditText setType(String type) {
        TYPES = type;
        return this;
    }

    /**
     * 设置最大字数
     *
     * @param num --字数
     * @return
     */
    public NumEditText setLength(int num) {
        this.MaxNum = num;
        return this;
    }

    /**
     * 设置文本框的Hint
     *
     * @param str --设置内容
     * @return
     */
    public NumEditText setEtHint(String str) {
        etContent.setHint(str);
        return this;
    }

    /**
     * 设置文本框的最小高度
     *
     * @param px --最小高度(单位px)
     * @return
     */
    public NumEditText setEtMinHeight(int px) {
        etContent.setMinHeight(px);
        return this;
    }

    /**
     * 感觉这个方法是核心方法
     */
    private TextWatcher mTextWatcher = new TextWatcher() {
        private int editStart;
        private int editEnd;

        public void afterTextChanged(Editable s) {
            editStart = etContent.getSelectionStart();
            editEnd = etContent.getSelectionEnd();
            // 先去掉监听器，否则会出现栈溢出
            etContent.removeTextChangedListener(mTextWatcher);
            // 注意这里只能每次都对整个EditText的内容求长度，不能对删除的单个字符求长度
            // 因为是中英文混合，单个字符而言，calculateLength函数都会返回1
            while (calculateLength(s.toString()) > MaxNum) { // 当输入字符个数超过限制的大小时，进行截断操作
                s.delete(editStart - 1, editEnd);
                editStart--;
                editEnd--;
            }
            // 恢复监听器
            etContent.addTextChangedListener(mTextWatcher);
            setLeftCount();
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    };

    /**
     * 刷新剩余输入字数
     */
    private void setLeftCount() {
        if (TYPES.equals(SINGULAR)) {//类型1
            tvNum.setText(String.valueOf((MaxNum - getInputCount())));
        } else if (TYPES.equals(PERCENTAGE)) {//类型2
            tvNum.setText(MaxNum - (MaxNum - getInputCount()) + "/" + MaxNum);
        }

    }

    /**
     * 获取用户输入内容字数
     */
    private long getInputCount() {
        return calculateLength(etContent.getText().toString());
    }

    /**
     * 计算分享内容的字数，一个汉字=两个英文字母，一个中文标点=两个英文标点
     * 注意：该函数的不适用于对单个字符进行计算，因为单个字符四舍五入后都是1
     *
     * @param cs
     * @return
     */
    public static long calculateLength(CharSequence cs) {
        double len = 0;
        for (int i = 0; i < cs.length(); i++) {
            int tmp = (int) cs.charAt(i);
            if (tmp > 0 && tmp < 127) {
                len += 1;
            } else {
                len++;
            }
        }
        return Math.round(len);
    }

}

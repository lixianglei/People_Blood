package com.example.admin.people_blood.view.xueyaguanli;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;
import com.example.admin.people_blood.bean.CeLiangMesageBean;
import com.example.admin.people_blood.modle.db.Manager;
import com.example.admin.people_blood.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 项目名称: 血压宝
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/10 16:18
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ShouDongCeLiangActivity extends BaseActivity {
    @Bind(R.id.Title_Text)
    TextView TitleText;
    @Bind(R.id.shoudong_date)
    RelativeLayout shoudongDate;
    @Bind(R.id.shoudong_time)
    RelativeLayout shoudongTime;
    @Bind(R.id.shoudong_name)
    EditText shoudongName;
    @Bind(R.id.shoudong_gaoya)
    EditText shoudongGaoya;
    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.shoudong_diya)
    EditText shoudongDiya;
    @Bind(R.id.shoudong_middle)
    LinearLayout shoudongMiddle;
    @Bind(R.id.shoudong_shangchuan)
    Button shoudongShangchuan;
    @Bind(R.id.text_date)
    TextView textDate;
    @Bind(R.id.text_time)
    TextView textTime;
    private DatePickerDialog DateDialog;
    private TimePickerDialog TimeDialog;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int mintune;
    private Manager manager;

    @Override
    protected int layoutId() {
        return R.layout.activity_shoudong;
    }

    @Override
    protected void initView() {
        LinearLayout linearLayout = new LinearLayout(this);

        manager = new Manager(this);
        Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);       //获取年月日时分秒
        month = cal.get(Calendar.MONTH);   //获取到的月份是从0开始计数
        day = cal.get(Calendar.DAY_OF_MONTH);//获取到日
        hour = cal.get(Calendar.HOUR_OF_DAY);//获取到小时 24
        mintune = cal.get(Calendar.MINUTE);
        String s = String.valueOf(month + 1);
        if (s.length() == 1) {
            s = "0" + s;

        }
        String day1 = String.valueOf(day);
        if (day1.length() == 1) {
            day1 = "0" + day1;
        }
        textDate.setText(year + "-" + s + "-" + day1);
        textTime.setText(hour + ":" + mintune);
        DateDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.e("TAG", year + "---" + month + "---" + dayOfMonth);
                String s = String.valueOf(month + 1);
                if (s.length() == 1) {
                    s = "0" + s;

                }
                String day1 = String.valueOf(dayOfMonth);
                if (day1.length() == 1) {
                    day1 = "0" + day1;
                }
                textDate.setText(year + "-" + s + "-" + day1);
            }
        }, year, month, day);
        TimeDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                textTime.setText(hourOfDay + ":" + minute);
            }
        }, hour, mintune, true);

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void listener() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.shoudong_date, R.id.shoudong_time, R.id.shoudong_shangchuan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shoudong_date:
                DateDialog.show();
                break;
            case R.id.shoudong_time:
                TimeDialog.show();
                break;
            case R.id.shoudong_shangchuan:

                if (TextUtils.isEmpty(shoudongName.getText())) {
                    ToastUtils.showShortToast("请输入设备名称");
                    return;
                }
                if (TextUtils.isEmpty(shoudongGaoya.getText())) {
                    ToastUtils.showShortToast("请输入高压");
                    return;
                }
                if (TextUtils.isEmpty(shoudongDiya.getText())) {
                    ToastUtils.showShortToast("请输入低压");
                    return;
                }
                int gaoya = Integer.parseInt(shoudongGaoya.getText().toString().trim());
                int diya = Integer.parseInt(shoudongDiya.getText().toString().trim());
                if (diya > gaoya) {
                    ToastUtils.showShortToast("高压必须大于低压");
                    return;
                }
                String date = textDate.getText().toString().trim();
                String time = textTime.getText().toString().trim();
                String name = shoudongName.getText().toString().trim();
                String gaogao = shoudongGaoya.getText().toString().trim();
                String didi = shoudongDiya.getText().toString().trim();
                CeLiangMesageBean ceLiangMesageBean = new CeLiangMesageBean(date, time, name, gaogao, didi,"true");
                if (manager.insert(ceLiangMesageBean)) {
                    EventBus.getDefault().post(ceLiangMesageBean);
                    finish();
                } else {
                    if (manager.update(ceLiangMesageBean.getDate(), ceLiangMesageBean)) {
                        EventBus.getDefault().post(ceLiangMesageBean);
                        finish();
                    }

                }
                break;
        }
    }
}

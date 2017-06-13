package com.example.admin.people_blood.view.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by d on 2017/6/10.
 */

public class Activity_PerSonMessage extends BaseActivity {
    @Bind(R.id.left_image)
    ImageView leftImage;
    @Bind(R.id.left_layout)
    RelativeLayout leftLayout;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.Name_XuanZe)
    LinearLayout NameXuanZe;
    @Bind(R.id.Sex_XuanZe)
    LinearLayout SexXuanZe;
    @Bind(R.id.My_Height)
    TextView MyHeight;
    @Bind(R.id.Height_XuanZe)
    LinearLayout HeightXuanZe;
    @Bind(R.id.Weight_XuanZe)
    LinearLayout WeightXuanZe;
    @Bind(R.id.My_Day)
    TextView MyDay;
    @Bind(R.id.Day_XuanZe)
    LinearLayout DayXuanZe;
    int mYear, mMonth, mDay;
    final int DATE_DIALOG = 1;
    @Bind(R.id.Text_Time)
    TextView TextTime;
    @Bind(R.id.Text_Name)
    TextView TextName;
    @Bind(R.id.set_Sex)
    TextView setSex;
    @Bind(R.id.height_text)
    TextView heightText;
    @Bind(R.id.weight_text)
    TextView weightText;

    @Override
    protected int layoutId() {
        return R.layout.person_message;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void listener() {
        NameXuanZe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_PerSonMessage.this, Activity_Name.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bundle bundle = data.getExtras();
        String param = bundle.getString("param");
        TextName.setText(param);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.left_image, R.id.Name_XuanZe, R.id.Sex_XuanZe, R.id.Height_XuanZe, R.id.Weight_XuanZe, R.id.Day_XuanZe})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.left_image:
                finish();
                break;
            case R.id.Name_XuanZe:
                break;
            case R.id.Sex_XuanZe:
                showListDialog();
                break;
            case R.id.Height_XuanZe:
                showDialog();
                break;
            case R.id.Weight_XuanZe:
                Dialog();
                break;
            case R.id.Day_XuanZe:
                showDialog(DATE_DIALOG);
                break;
        }

        final Calendar ca = Calendar.getInstance();
        mYear = ca.get(Calendar.YEAR);
        mMonth = ca.get(Calendar.MONTH);
        mDay = ca.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG:
                return new DatePickerDialog(this, mdateListener, mYear, mMonth, mDay);
        }
        return null;
    }

    /**
     * 设置日期 利用StringBuffer追加
     */
    public void display() {
        TextTime.setText(new StringBuffer().append(mYear).append("-").append(mMonth + 1).append("-").append(mDay).append(""));
    }

    private DatePickerDialog.OnDateSetListener mdateListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            display();
        }

    };
    //<-------选择性别------>

    private void showListDialog() {
        final String[] items = {"男", "女"};
        AlertDialog.Builder listDialog =
                new AlertDialog.Builder(Activity_PerSonMessage.this);
        listDialog.setTitle("选择性别");
        listDialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // which 下标从0开始
                String item = items[which];
                setSex.setText(item);
                Toast.makeText(Activity_PerSonMessage.this,
                        "修改成功",
                        Toast.LENGTH_SHORT).show();
            }
        });
        listDialog.show();
    }

    private void showDialog() {
        final String[] items = {"150-160", "160-170", "170-180", "180以上"};
        AlertDialog.Builder listDialog =
                new AlertDialog.Builder(Activity_PerSonMessage.this);
        listDialog.setTitle("选择身高");
        listDialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // which 下标从0开始
                String item = items[which];
                heightText.setText(item);
                Toast.makeText(Activity_PerSonMessage.this,
                        "修改成功",
                        Toast.LENGTH_SHORT).show();
            }
        });
        listDialog.show();
    }
    private void Dialog() {
        final String[] items = {"50-60", "60-70", "70-80", "80-90","90以上"};
        AlertDialog.Builder listDialog = new AlertDialog.Builder(Activity_PerSonMessage.this);
        listDialog.setTitle("选择身高");
        listDialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // which 下标从0开始
                String item = items[which];
                weightText.setText(item);
                Toast.makeText(Activity_PerSonMessage.this,
                        "修改成功",
                        Toast.LENGTH_SHORT).show();
            }
        });
        listDialog.show();
    }

}


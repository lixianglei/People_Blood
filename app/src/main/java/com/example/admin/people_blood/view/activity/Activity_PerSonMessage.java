package com.example.admin.people_blood.view.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.admin.people_blood.MainActivity;
import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;
import com.example.admin.people_blood.utils.ToastUtils;
import com.example.admin.people_blood.utils.whiledemo;

import java.util.Arrays;
import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by d on 2017/6/10.
 */

public class Activity_PerSonMessage extends BaseActivity {
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
    @Bind(R.id.Text_Time)
    TextView TextTime;
    @Bind(R.id.Text_Name)
    TextView TextName;
    //    @Bind(R.id.set_Sex)
//    TextView setSex;
    int mYear, mMonth, mDay;
    final int DATE_DIALOG = 1;
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String[] PLANETS = new String[]{"男", "女"};

    private static final String[] PLANETSA = new String[]{"60", "70", "80", "80", "100", "110", "120", "130", "140", "150", "160", "170", "180", "190", "200"};

    private static final String[] PLANETSB = new String[]{"10", "20", "30", "40", "50", "60", "70", "80", "90", "100"};
    @Bind(R.id.left_layout)
    RelativeLayout leftLayout;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.Name_XuanZe)
    LinearLayout NameXuanZe;
    @Bind(R.id.TextNv)
    TextView TextNv;
    @Bind(R.id.Weight)
    TextView Weight;
    @Bind(R.id.Sex_XuanZe)
    LinearLayout SexXuanZe;
    @Bind(R.id.height_text)
    TextView heightText;

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

    @OnClick({R.id.Name_XuanZe, R.id.Sex_XuanZe, R.id.Height_XuanZe, R.id.Weight_XuanZe, R.id.Day_XuanZe})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.left_image:
                finish();
                break;
            case R.id.Name_XuanZe:
                showDialog_Layout(this);
                break;
            case R.id.Sex_XuanZe:
                View outerView = LayoutInflater.from(this).inflate(R.layout.wheel_view, null);
                final whiledemo wv = (whiledemo) outerView.findViewById(R.id.WheelView);
                wv.setOffset(1);
                wv.setItems(Arrays.asList(PLANETS));
                wv.setSeletion(1);
                wv.setOnWheelViewListener(new whiledemo.OnWheelViewListener() {
                    @Override
                    public void onSelected(int selectedIndex, String item) {
                    }
                });

                new AlertDialog.Builder(this)
                        .setTitle("选择性别：")
                        .setView(outerView)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String item = wv.getSeletedItem();
                                TextNv.setText(item);
                                ToastUtils.showShortToast("修改成功~");
                            }
                        })
                        .show();
                break;
            case R.id.Height_XuanZe:
                View outerView1 = LayoutInflater.from(this).inflate(R.layout.wheel_view, null);
                final whiledemo wv1 = (whiledemo) outerView1.findViewById(R.id.WheelView);
                wv1.setOffset(1);
                wv1.setItems(Arrays.asList(PLANETSA));
                wv1.setSeletion(1);
                wv1.setOnWheelViewListener(new whiledemo.OnWheelViewListener() {
                    @Override
                    public void onSelected(int selectedIndex, String item) {
                        Log.d(TAG, "[Dialog]selectedIndex: " + selectedIndex + ", item: " + item);
                    }
                });

                new AlertDialog.Builder(this)
                        .setTitle("选择身高：")
                        .setView(outerView1)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String item = wv1.getSeletedItem();
                                heightText.setText(item);
                                ToastUtils.showShortToast("修改成功~");
                            }
                        })
                        .show();
                break;
            case R.id.Weight_XuanZe:
                View outerView2 = LayoutInflater.from(this).inflate(R.layout.wheel_view, null);
                final whiledemo wv2 = (whiledemo) outerView2.findViewById(R.id.WheelView);
                wv2.setOffset(1);
                wv2.setItems(Arrays.asList(PLANETSB));
                wv2.setSeletion(1);
                wv2.setOnWheelViewListener(new whiledemo.OnWheelViewListener() {
                    @Override
                    public void onSelected(int selectedIndex, String item) {
                        Log.d(TAG, "[Dialog]selectedIndex: " + selectedIndex + ", item: " + item);
                    }
                });

                new AlertDialog.Builder(this)
                        .setTitle("选择体重：")
                        .setView(outerView2)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String item = wv2.getSeletedItem();
                                Weight.setText(item);
                                ToastUtils.showShortToast("修改成功~");
                            }
                        })
                        .show();
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


    private void showDialog_Layout(Context context) {
        LayoutInflater inflater = LayoutInflater.from(this);
        final View textEntryView = inflater.inflate(
                R.layout.dialoglayout, null);
        final EditText edtInput = (EditText) textEntryView.findViewById(R.id.EditText_View);
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setTitle("修改姓名");
        builder.setView(textEntryView);
        builder.setPositiveButton("确认",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        setTitle(edtInput.getText());
                        TextName.setText(edtInput.getText());
                        ToastUtils.showShortToast("修改成功~");
                    }
                });
        builder.setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        setTitle("");
                    }
                });
        builder.show();
    }

}


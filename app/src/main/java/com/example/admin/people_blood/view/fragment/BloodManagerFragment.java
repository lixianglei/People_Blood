package com.example.admin.people_blood.view.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.people_blood.App;
import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseFragment;
import com.example.admin.people_blood.bean.CeLiangMesageBean;
import com.example.admin.people_blood.eventbus.ShuJuKuDetl;
import com.example.admin.people_blood.modle.db.Manager;
import com.example.admin.people_blood.presenter.BloodManagerPressenter;
import com.example.admin.people_blood.utils.DateUtils;
import com.example.admin.people_blood.view.activity.WenYiShengActivity;
import com.example.admin.people_blood.view.xueyaguanli.ShouDongCeLiangActivity;
import com.example.admin.people_blood.view.xueyaguanli.ShuJuKuListActivity;
import com.example.admin.people_blood.view.xueyaguanli.TiXingListActivity;
import com.example.admin.people_blood.view.xueyaguanli.XueYaZiXunActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lecho.lib.hellocharts.gesture.ContainerScrollType;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.view.LineChartView;

/**
 * 项目名称: 血压测量
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/9 20:29
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class BloodManagerFragment extends BaseFragment implements BloodManagerFragmentImpl {
    @Bind(R.id.xueyaceliang)
    ImageView xueyaceliang;
    @Bind(R.id.boold_shuju)
    TextView booldShuju;
    @Bind(R.id.tongji_day)
    RadioButton tongjiDay;
    @Bind(R.id.tongji_zhou)
    RadioButton tongjiZhou;
    @Bind(R.id.tongji_month)
    RadioButton tongjiMonth;
    @Bind(R.id.tongji_year)
    RadioButton tongjiYear;
    @Bind(R.id.boold_tongji)
    RadioGroup booldTongji;
    @Bind(R.id.boold_wendoctor)
    TextView booldWendoctor;
    @Bind(R.id.boold_zixun)
    TextView booldZixun;
    @Bind(R.id.boold_tixing)
    TextView booldTixing;
    @Bind(R.id.Boold_FrameLayout)
    LineChartView BooldFrameLayout;
    @Bind(R.id.load_text)
    TextView loadText;
    private boolean isboolean;
    private PopupWindow popupWindow;
    private BloodManagerPressenter bloodManagerPressenter;
    private List<AxisValue> listX;
    private List<AxisValue> listY;
    private List<PointValue> listGaoYa;
    private List<PointValue> listDiYa;
    private Manager manager;
    private List<CeLiangMesageBean> listshuju;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected int ViewID() {
        return R.layout.fragment_bloodmanager;
    }

    @Override
    protected void initView() {
        bloodManagerPressenter = new BloodManagerPressenter(this);
        manager = new Manager(App.baseActivity);
        EventBus.getDefault().register(this);
        listX = new ArrayList<>();
        listY = new ArrayList<>();
        listGaoYa = new ArrayList<>();
        listDiYa = new ArrayList<>();
        tongjiDay.setChecked(true);
        initpopwindow();
        Long date = System.currentTimeMillis();
        String date1 = DateUtils.format(date, "yyyy-MM-dd");
        Log.e("TAG", date1);
        listshuju = manager.query(date1);
        if (listshuju.isEmpty()) {
            loadText.setVisibility(View.VISIBLE);
            BooldFrameLayout.setVisibility(View.GONE);

        } else {
            loadText.setVisibility(View.GONE);
            BooldFrameLayout.setVisibility(View.VISIBLE);
            initDay();
            initY();
            initdian();
            initChatLine();
        }
    }

    private void initpopwindow() {
        View view = LayoutInflater.from(App.baseActivity).inflate(R.layout.pop_xuanzeceliang, null);
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#AFAFAF")));
        TextView shoudong = (TextView) view.findViewById(R.id.pop_shoudong);
        TextView kangbaobeo = (TextView) view.findViewById(R.id.pop_kangbaobei);
        TextView sfinsh = (TextView) view.findViewById(R.id.pop_finsh);
        shoudong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodManagerPressenter.shoudongCe();
            }
        });
        kangbaobeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodManagerPressenter.kangbaobei();
            }
        });
        sfinsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodManagerPressenter.finshpop();
            }
        });
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void listener() {
        radioGroupListener();
        BooldFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(App.baseActivity, ShuJuKuListActivity.class);
                EventBus.getDefault().postSticky(new ShuJuKuDetl(listshuju));
                startActivity(intent);

            }
        });
    }


    @Override
    public void shoudongshangchuan() {
        Intent intent = new Intent(App.baseActivity, ShouDongCeLiangActivity.class);
        startActivity(intent);
        popupWindow.dismiss();
    }

    @Override
    public void kangBaoBeiShangChuan() {
        Toast.makeText(App.baseActivity, "康宝贝测量", Toast.LENGTH_SHORT).show();
        popupWindow.dismiss();
    }

    @Override
    public void shuaxin(String text) {

    }

    @Override
    public void showPopWindow() {
        popupWindow.showAsDropDown(xueyaceliang);
    }

    @Override
    public void finshpop() {
        popupWindow.dismiss();
    }


    @OnClick({R.id.xueyaceliang, R.id.boold_shuju, R.id.boold_wendoctor, R.id.boold_tixing, R.id.boold_zixun})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //选择测量
            case R.id.xueyaceliang:
                bloodManagerPressenter.shangchuan();
                break;
            //更改 没用
            case R.id.boold_shuju:

                break;
            //提醒
            case R.id.boold_tixing:
                startActivity(new Intent(App.baseActivity, TiXingListActivity.class));
                break;
            //问医生
            case R.id.boold_wendoctor:
                Intent intent1 = new Intent(App.baseActivity, WenYiShengActivity.class);
                startActivity(intent1);
                break;
            //资讯
            case R.id.boold_zixun:
                Intent intent = new Intent(App.baseActivity, XueYaZiXunActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void radioGroupListener() {
        booldTongji.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.tongji_day:
                        dayShuaXin();
                        break;
                    case R.id.tongji_zhou:

                        break;
                    case R.id.tongji_month:
                        listshuju.clear();
                        List<CeLiangMesageBean> query = manager.query();
                        listshuju.addAll(query);
                        initMonth();
                        shuaxin();
                        break;
                    case R.id.tongji_year:
                        listshuju.clear();
                        List<CeLiangMesageBean> query1 = manager.query();
                        listshuju.addAll(query1);
                        initYear();
                        shuaxin();

                        break;
                }
            }
        });
    }

    private void dayShuaXin() {
        listshuju.clear();
        long date = System.currentTimeMillis();
        String date1 = DateUtils.format(date, "yyyy-MM-dd");
        List<CeLiangMesageBean> query2 = manager.query(date1);
        listshuju.addAll(query2);
        initDay();
        shuaxin();
    }

    private void shuaxin() {
        if (listshuju.isEmpty()) {
            BooldFrameLayout.setVisibility(View.GONE);
            loadText.setVisibility(View.VISIBLE);
        } else {
            BooldFrameLayout.setVisibility(View.VISIBLE);
            loadText.setVisibility(View.GONE);
            initdian();
            initChatLine();
        }
    }

    /**
     * 初始化统计表
     */
    private void initChatLine() {
        List<Line> lines = new ArrayList<>();
        //高压
        Line lineG = new Line(listGaoYa);
        lineG.setStrokeWidth(1);
        //设置点的颜色
        lineG.setPointColor(Color.parseColor("#6CCA77"));
        lineG.setColor(Color.parseColor("#6CCA77"));
        //设置点的半径
        lineG.setPointRadius(3);
        lineG.setShape(ValueShape.DIAMOND);
        lineG.setCubic(false);
        lineG.setFilled(false);
        lineG.setHasLines(true);
        lineG.setHasLabelsOnlyForSelected(true);
        lineG.setHasPoints(true);


        Line lineD = new Line(listDiYa);
        lineD.setStrokeWidth(1);
        lineD.setHasLines(true);
        //设置点的颜色
        lineD.setPointColor(Color.parseColor("#000000"));
        lineD.setColor(Color.parseColor("#000000"));
        //设置点的半径
        lineD.setPointRadius(3);
        lineD.setShape(ValueShape.DIAMOND);
        lineD.setCubic(false);
        lineD.setFilled(false);
        lineD.setHasLabelsOnlyForSelected(true);
        lineD.setHasPoints(true);
        lines.add(lineD);
        lines.add(lineG);


        LineChartData data = new LineChartData();
        data.setValueLabelBackgroundAuto(true);// 设置数据背景是否跟随节点颜色
        data.setLines(lines);


        Axis axisX = new Axis();
        //x轴坐标字体是斜的还是正的 true为斜的
        axisX.setHasTiltedLabels(false);
        //设置字体颜色
        axisX.setTextColor(Color.parseColor("#000000"));
        axisX.setHasSeparationLine(true);
        //设置字体类型
        axisX.setTypeface(Typeface.DEFAULT_BOLD);
        //设置字体大小
        axisX.setTextSize(10);
        //最多几个x轴坐标
//        axisX.setMaxLabelChars(8);
        //填充x轴的坐标名称
        axisX.setValues(listX);
        Log.e("TAG", listX.size() + "个");
        axisX.setHasLines(true);
        data.setAxisXBottom(axisX);


        Axis axisY = new Axis();
        axisY.setLineColor(Color.parseColor("#F15A24"));
        axisY.setTextColor(Color.parseColor("#000000"));
//        axisY.setValues(listY);
        axisY.setTextSize(10);
        //最多几个x轴坐标
        axisY.setMaxLabelChars(8);
        axisY.setHasLines(true);
        //x轴标注
        axisY.setName("");
        //Y轴设置在左边
        data.setAxisYLeft(axisY);


        BooldFrameLayout.setInteractive(true);
        BooldFrameLayout.setZoomType(ZoomType.HORIZONTAL);
        BooldFrameLayout.setZoomEnabled(false);
        BooldFrameLayout.setMaxZoom((float) 2);//最大方法比例
        BooldFrameLayout.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL);
        BooldFrameLayout.setLineChartData(data);
        BooldFrameLayout.setVisibility(View.VISIBLE);
    }

    /**
     * 设置为天是x轴的内容
     */
    private void initDay() {
        listX.clear();
        for (int i = 0; i < listshuju.size(); i++) {
            String time = listshuju.get(i).getTime();
            listX.add(new AxisValue(i).setLabel(time));
        }
    }

    /**
     * 设置为月x轴的内容
     */
    private void initMonth() {
        boolean boo;
        boo = false;
        List<CeLiangMesageBean> list = new ArrayList<>();

        for (int i = 0; i < listshuju.size(); i++) {
            if (listshuju.get(i).getDate().split("-")[0].equals(String.valueOf(DateUtils.getCurYear()))) {
                list.add(listshuju.get(i));
            }
        }

        listshuju.clear();
        listshuju.addAll(list);
        list.clear();
        for (int i = 0; i < listshuju.size(); i++) {
            if (i == 0) {
                list.add(listshuju.get(i));
            }
            boo = false;
            for (int i1 = 0; i1 < list.size(); i1++) {
                if (list.get(i1).getDate().equals(listshuju.get(i).getDate())) {
                    boo = true;
                }
                if (i1 == list.size() - 1) {
                    if (!boo) {
                        list.add(listshuju.get(i));
                    }
                }

            }

        }
        listshuju.clear();
        listshuju.addAll(list);
        listX.clear();
        for (int i = 0; i < listshuju.size(); i++) {
            String time = listshuju.get(i).getDate().split("-")[2];
            listX.add(new AxisValue(i).setLabel(time));
        }
        Log.d("BloodManagerFragment", "listX.size():" + listX.size());
    }

    /**
     * 设置为年的x轴显示内容
     */
    private void initYear() {
        boolean boo;
        boo = false;
        List<CeLiangMesageBean> list = new ArrayList<>();
        for (int i = 0; i < listshuju.size(); i++) {
            if (i == 0) {
                list.add(listshuju.get(i));
            }
            boo = false;
            for (int i1 = 0; i1 < list.size(); i1++) {
                if (list.get(i1).getDate().split("-")[0].equals(listshuju.get(i).getDate().split("-")[0])) {
                    boo = true;
                }
                if (i1 == list.size() - 1) {
                    if (!boo) {
                        list.add(listshuju.get(i));
                    }
                }
            }
        }
        listshuju.clear();
        listshuju.addAll(list);
        listX.clear();
        for (int i = 0; i < listshuju.size(); i++) {
            String time = listshuju.get(i).getDate().split("-")[0];
            listX.add(new AxisValue(i).setLabel(time));
        }
    }

    //设置点数据
    private void initdian() {
        listDiYa.clear();
        listGaoYa.clear();
        for (int i = 0; i < listshuju.size(); i++) {
            float gaoya = Float.parseFloat(listshuju.get(i).getGaoya());
            float diya = Float.parseFloat(listshuju.get(i).getDiya());
            listDiYa.add(new PointValue(i, diya));
            listGaoYa.add(new PointValue(i, gaoya));

        }
    }

    //设置Y轴内容
    private void initY() {
        listY.add(new AxisValue(0).setLabel("60"));
        listY.add(new AxisValue(1).setLabel("80"));
        listY.add(new AxisValue(2).setLabel("100"));
        listY.add(new AxisValue(3).setLabel("120"));
        listY.add(new AxisValue(4).setLabel("140"));
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getEvent(CeLiangMesageBean ceLiangMesageBean) {
        tongjiDay.setChecked(true);
        dayShuaXin();
        booldShuju.setText(ceLiangMesageBean.getGaoya() + "/" + ceLiangMesageBean.getDiya() + "  今天");
    }

}

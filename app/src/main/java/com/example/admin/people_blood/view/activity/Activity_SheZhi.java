package com.example.admin.people_blood.view.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.people_blood.R;
import com.example.admin.people_blood.base.BaseActivity;

import java.io.File;
import java.util.Properties;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by d on 2017/6/10.
 */

public class Activity_SheZhi extends BaseActivity {

    @Bind(R.id.left_image)
    ImageView leftImage;
    @Bind(R.id.left_layout)
    RelativeLayout leftLayout;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.ZhangHu)
    LinearLayout ZhangHu;
    @Bind(R.id.Clear)
    LinearLayout Clear;
    @Bind(R.id.AboutBoold)
    TextView AboutBoold;
    @Bind(R.id.About_Blood)
    LinearLayout AboutBlood;
    //------****** 缓存相关****----------
    private final int CLEAN_SUC = 1001;
    private final int CLEAN_FAIL = 1002;
    @Bind(R.id.tvCache)
    TextView tvCache;

    private void onClickCleanCache() {
        getConfirmDialog(getBaseContext(), "是否清空缓存?", new DialogInterface.OnClickListener
                () {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                clearAppCache();
                tvCache.setText("0KB");
            }
        }).show();
    }

    public static AlertDialog.Builder getConfirmDialog(Context context, String message, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = getDialog(context);
        builder.setMessage(Html.fromHtml(message));
        builder.setPositiveButton("确定", onClickListener);
        builder.setNegativeButton("取消", null);
        return builder;
    }

    public static AlertDialog.Builder getDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        return builder;
    }

    /**
     * 计算缓存的大小
     */
    private void caculateCacheSize() {
        long fileSize = 0;
        String cacheSize = "0KB";
        File filesDir = getBaseContext().getFilesDir();
        File cacheDir = getBaseContext().getCacheDir();

        fileSize += FileUtil.getDirSize(filesDir);
        fileSize += FileUtil.getDirSize(cacheDir);
        // 2.2版本才有将应用缓存转移到sd卡的功能
//        if (isMethodsCompat(Build.VERSION_CODES.FROYO)) {
//            File externalCacheDir = MethodsCompat
//                    .getExternalCacheDir(getBaseContext());
//            fileSize += FileUtil.getDirSize(externalCacheDir);
//            fileSize += FileUtil.getDirSize(new File(
//                    org.utils.FileUtils.getSDCardPath()
//                            + File.separator + "KJLibrary/cache"));
//        }
        if (fileSize > 0)
            cacheSize = FileUtil.formatFileSize(fileSize);
        tvCache.setText(cacheSize);
    }

    public static boolean isMethodsCompat(int VersionCode) {
        int currentVersion = Build.VERSION.SDK_INT;
        return currentVersion >= VersionCode;
    }

    /**
     * 清除app缓存
     */
    public void myclearaAppCache() {
//        DataCleanManager.cleanDatabases(getBaseContext());
        // 清除数据缓存
//        DataCleanManager.cleanInternalCache(getBaseContext());
        // 2.2版本才有将应用缓存转移到sd卡的功能
        if (isMethodsCompat(Build.VERSION_CODES.FROYO)) {
//            DataCleanManager.cleanCustomCache(MethodsCompat
//                    .getExternalCacheDir(getBaseContext()));
        }
        // 清除编辑器保存的临时内容
        Properties props = getProperties();
        for (Object key : props.keySet()) {
            String _key = key.toString();
            if (_key.startsWith("temp"))
                removeProperty(_key);
        }
//        Core.getKJBitmap().cleanCache();
    }

    /**
     * 清除保存的缓存
     */
    public Properties getProperties() {
        return AppConfig.getAppConfig(getBaseContext()).get();
    }

    public void removeProperty(String... key) {
        AppConfig.getAppConfig(getBaseContext()).remove(key);
    }

    /**
     * 清除app缓存
     *
     * @param
     */
    public void clearAppCache() {

        new Thread() {
            @Override
            public void run() {
                Message msg = new Message();
                try {
                    myclearaAppCache();
                    msg.what = CLEAN_SUC;
                } catch (Exception e) {
                    e.printStackTrace();
                    msg.what = CLEAN_FAIL;
                }
                handler.sendMessage(msg);
            }
        }.start();
    }

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CLEAN_FAIL:
//                    ToastUtils.show(SxApplication.getInstance(),"清除失败");
                    Toast.makeText(Activity_SheZhi.this, "清除失败", Toast.LENGTH_SHORT).show();
                    break;
                case CLEAN_SUC:
//                    ToastUtils.show(SxApplication.getInstancenstance(),"清除成功");
                    Toast.makeText(Activity_SheZhi.this, "清除成功", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        ;
    };

    @Override
    protected int layoutId() {
        return R.layout.shezhi_activity;
    }

    @Override
    protected void initView() {

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

    @OnClick({R.id.left_image, R.id.ZhangHu, R.id.Clear, R.id.About_Blood})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.left_image:
                finish();
                break;
            case R.id.ZhangHu:
                Intent intent1 = new Intent(this, Activity_ZhangHu.class);
                startActivity(intent1);
                break;
            case R.id.Clear:
                onClickCleanCache();
                break;
            case R.id.About_Blood:
                Intent intent = new Intent(this, Activity_About_Boold.class);
                startActivity(intent);
                break;
        }
    }

}

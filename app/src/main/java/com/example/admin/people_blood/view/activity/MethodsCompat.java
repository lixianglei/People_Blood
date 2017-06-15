package com.example.admin.people_blood.view.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.view.View;
import android.view.Window;

import java.io.File;

/**
 * Created by d on 2017/6/16.
 */

public class MethodsCompat {
    @TargetApi(5)
    public static void overridePendingTransition(Activity activity, int enter_anim, int exit_anim) {
        activity.overridePendingTransition(enter_anim, exit_anim);
    }

//    @TargetApi(7)
//    public static Bitmap getThumbnail(ContentResolver cr, long origId, int kind, PeerConnectionFactory.Options options) {
//        return MediaStore.Images.Thumbnails.getThumbnail(cr,origId,kind, options);
//    }

    @TargetApi(8)
    public static File getExternalCacheDir(Context context) {

//        // return context.getExternalCacheDir(); API level 8
//
//        // e.g. "<sdcard>/Android/data/<package_name>/cache/"
//        final File extCacheDir = new File(Environment.getExternalStorageDirectory(),
//            "/Android/data/" + context.getApplicationInfo().packageName + "/cache/");
//        extCacheDir.mkdirs();
//        return extCacheDir;

        return context.getExternalCacheDir();
    }

    @TargetApi(11)
    public static void recreate(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            activity.recreate();
        }
    }

    @TargetApi(11)
    public static void setLayerType(View view, int layerType, Paint paint) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            view.setLayerType(layerType, paint);
        }
    }

    @TargetApi(14)
    public static void setUiOptions(Window window, int uiOptions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            window.setUiOptions(uiOptions);
        }
    }
}

package com.example.admin.people_blood.modle.http;


import com.example.admin.people_blood.modle.callback.HttpCallBack;
import com.example.admin.people_blood.utils.GsonUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/9 16:50
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class RetrofitClient implements IHttp {
    private static RetrofitClient retrofitClient;
    private IAPiService iaPiService;
    private String baseul = IAPiService.HOST;

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseul)
                .build();
        iaPiService = retrofit.create(IAPiService.class);
    }

    public static RetrofitClient getInstance() {
        if (retrofitClient == null) {
            synchronized (RetrofitClient.class) {
                if (retrofitClient == null) {
                    retrofitClient = new RetrofitClient();
                }
            }
        }
        return retrofitClient;
    }

    @Override
    public void get(Class classBean, String url, Map<String, String> map, HttpCallBack httpCallBack) {
        get(classBean, url, map, httpCallBack, false);
    }

    @Override
    public void post(Class classBean, String url, Map<String, String> map, HttpCallBack httpCallBack) {
        post(classBean, url, map, httpCallBack, false);
    }

    public void post(Class classBean, String url, Map<String, String> map, HttpCallBack httpCallBack, boolean boo) {
        iaPiService.post(url, map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getConsumer(classBean, httpCallBack, boo), getThrowable(httpCallBack));
    }

    public void get(final Class classBean, String url, Map<String, String> map, final HttpCallBack httpCallBack, final boolean boo) {
        iaPiService.get(url, map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getConsumer(classBean, httpCallBack, boo), getThrowable(httpCallBack));
    }

    private Consumer<ResponseBody> getConsumer(final Class classBean, final HttpCallBack httpCallBack, final boolean boo) {
        Consumer<ResponseBody> consumer = new Consumer<ResponseBody>() {
            @Override
            public void accept(@NonNull ResponseBody responseBody) throws Exception {
                String res = responseBody.string();
                if (boo) {
                    httpCallBack.onSuccess(GsonUtils.gsonList(res, classBean));
                } else {
                    httpCallBack.onSuccess(GsonUtils.gsonBean(res, classBean));
                }
            }
        };
        return consumer;
    }

    private Consumer<Throwable> getThrowable(final HttpCallBack httpCallBack) {
        Consumer<Throwable> throwable = new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                httpCallBack.onFailure(throwable.getMessage());
            }
        };
        return throwable;
    }
}

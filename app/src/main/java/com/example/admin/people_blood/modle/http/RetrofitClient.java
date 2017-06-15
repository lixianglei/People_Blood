package com.example.admin.people_blood.modle.http;


import android.util.Log;

import com.example.admin.people_blood.modle.callback.HttpCallBack;
import com.example.admin.people_blood.utils.GsonUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;
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
        map = getStringStringMap(map);
        get(classBean, url, map, httpCallBack, false);
    }

    @android.support.annotation.NonNull
    private Map<String, String> getStringStringMap(Map<String, String> map) {
        if(map==null){
            map = new HashMap<>();
        }
        return map;
    }

    public void get(final Class classBean, String url, Map<String, String> map, final HttpCallBack httpCallBack, final boolean boo) {
        map = getStringStringMap(map);
        iaPiService.get(url, map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getConsumer(classBean, httpCallBack, boo), getThrowable(httpCallBack));
    }

    @Override
    public void post(Class classBean, String url, Map<String, String> map, HttpCallBack httpCallBack) {
        map = getStringStringMap(map);
        post(classBean, url, map, httpCallBack, false);
    }

    public void post(Class classBean, String url, Map<String, String> map, HttpCallBack httpCallBack, boolean boo) {
        map = getStringStringMap(map);
        iaPiService.post(url, map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getConsumer(classBean, httpCallBack, boo), getThrowable(httpCallBack));
    }

    @Override
    public void updateImage(Class classBean, Map<String, String> map, String url, String key, File fileimage, HttpCallBack httpCallBack) {
        if (fileimage == null || key.length() <= 0 || key.isEmpty() || !fileimage.exists()) {
            httpCallBack.onFailure("请检查文件路径");
            return;
        }
        RequestBody requestFile =
                RequestBody.create(MediaType.parse("multipart/form-data"), fileimage);
        MultipartBody.Part part = MultipartBody.Part.createFormData(
                key,
                fileimage.getName(),
                new ProgressRequestBody(requestFile, httpCallBack));
        iaPiService.upload(url, map, part)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getConsumer(classBean, httpCallBack, false), getThrowable(httpCallBack));
    }


    private Consumer<ResponseBody> getConsumer(final Class classBean, final HttpCallBack httpCallBack, final boolean boo) {
        Consumer<ResponseBody> consumer = new Consumer<ResponseBody>() {
            @Override
            public void accept(@NonNull ResponseBody responseBody) throws Exception {
                String res = responseBody.string();
                Log.e("集合", res);
                if (boo) {
                    httpCallBack.onSuccess(GsonUtils.gsonList(res, classBean));
                } else {
                    httpCallBack.onSuccess(GsonUtils.gsonBean(res, classBean));
                }
//                dialogManager.dimssDialog();
            }
        };
        return consumer;
    }

    private Consumer<Throwable> getThrowable(final HttpCallBack httpCallBack) {
        Consumer<Throwable> throwable = new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                httpCallBack.onFailure(throwable.getMessage());
//                dialogManager.dimssDialog();
            }
        };
        return throwable;
    }

    public class ProgressRequestBody extends RequestBody {
        //实际的待包装请求体
        private final RequestBody requestBody;
        //进度回调接口
        private HttpCallBack httpCallBack;
        //包装完成的BufferedSink
        private BufferedSink bufferedSink;
        private long contentlength;

        public ProgressRequestBody(RequestBody requestBody, HttpCallBack httpCallBack) {
            this.requestBody = requestBody;
            this.httpCallBack = httpCallBack;
        }

        /**
         * 实际的响应体
         *
         * @return
         */
        @Override
        public MediaType contentType() {
            return null;
        }

        @Override
        public void writeTo(BufferedSink sink) throws IOException {
            if (null == bufferedSink) {
                bufferedSink = Okio.buffer(sink(sink));
            }
            requestBody.writeTo(bufferedSink);
            //必须调用flush，否则最后一部分数据可能不会被写入
            bufferedSink.flush();
        }

        /**
         * 实际的长度
         *
         * @return
         * @throws IOException
         */
        @Override
        public long contentLength() throws IOException {
            contentlength = requestBody.contentLength();
            return requestBody.contentLength();
        }

        /**
         * 写入，回调进度接口
         *
         * @param sink Sink
         * @return Sink
         */
        private Sink sink(Sink sink) {
            return new ForwardingSink(sink) {
                //当前写入字节数
                long writtenBytesCount = 0L;
                //总字节长度，避免多次调用contentLength()方法
                long totalBytesCount = 0L;

                @Override
                public void write(Buffer source, long byteCount) throws IOException {
                    super.write(source, byteCount);
                    //增加当前写入的字节数
                    writtenBytesCount += byteCount;
                    //获得contentLength的值，后续不再调用
                    if (totalBytesCount == 0) {
                        totalBytesCount = contentLength();
                    }
                    Observable.just(writtenBytesCount).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Long>() {
                        @Override
                        public void accept(@NonNull Long aLong) throws Exception {
                            httpCallBack.upload((int) writtenBytesCount);
                        }
                    });
                }
            };
        }
    }

}

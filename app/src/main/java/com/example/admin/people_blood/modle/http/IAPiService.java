package com.example.admin.people_blood.modle.http;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * 项目名称: 城市通
 * 类描述:
 * 创建人: 田晓龙
 * 创建时间: 2017/6/9 16:36
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public interface IAPiService {
    public static final String HOST = "http://api.wws.xywy.com/";

    @GET("{url}")
    Observable<ResponseBody> get(@Path("url") String url, @QueryMap Map<String, String> map);

    @FormUrlEncoded
    @POST("{url}")
    Observable<ResponseBody> post(@Path("url") String url, @FieldMap Map<String, String> map);

}

package com.dc.baseproject.api;


import com.dc.baseproject.bean.HomeTopDataEntity;
import com.dc.baseproject.bean.UserEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Retrofit请求参数接口
 */
public interface RetrofitService {


    @POST("user/sendsms")
    @FormUrlEncoded
    Observable<String> getYzmCode(@Field("phoneNumber") String phone);


    @POST("login")
    @FormUrlEncoded
    Observable<UserEntity> login(@Field("account") String phone, @Field("password") String yzm, @Field("channel") String channel);

//    @POST()
//    @FormUrlEncoded
//    Observable<UserEntity> getUserInfoRx(@Field(""));


    @GET("show/showInfo")
//    @GET("show/showInfo")
    Observable<HomeTopDataEntity> getHomeTopData();
}

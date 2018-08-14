package com.dc.baseproject.api.manager;


import android.content.Context;

import com.dc.baseproject.api.Constants;
import com.dc.baseproject.api.RetrofitService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * 获取RetrofitService实例
 * Created by dingchao on 2017/6/27.
 */

public class RetrofitHelper {

    public static RetrofitHelper retrofitHelper;
    private RetrofitService retrofitService;
    private static Context mContext;

    /*public static RetrofitHelper getInstance() {
        return retrofitHelper == null ? retrofitHelper = new RetrofitHelper(mContext) : retrofitHelper;
    }*/

    public RetrofitHelper() {
        // 初始化Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(FastJsonConverterFactory.create()) // json解析,使用的FastJson，如果想使用Gson替换括号中的内容即可
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 支持RxJava
                .build();
        retrofitService = retrofit.create(RetrofitService.class);
    }

    public RetrofitService getRetrofitService() {
        return retrofitService;
    }


    /**
     * 单例模式，得到requestbusiness的实例
     *
     * @return
     */
    public static synchronized RetrofitHelper getInstance() {
        if (retrofitHelper == null) {
            retrofitHelper = new RetrofitHelper();
        }
        return retrofitHelper;
    }

}

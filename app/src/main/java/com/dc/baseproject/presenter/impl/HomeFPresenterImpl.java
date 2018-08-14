package com.dc.baseproject.presenter.impl;

import android.util.Log;

import com.dc.baseproject.api.manager.RetrofitHelper;
import com.dc.baseproject.bean.HomeTopDataEntity;
import com.dc.baseproject.model.impl.HomeFModelImpl;
import com.dc.baseproject.model.inter.IHomeFModel;
import com.dc.baseproject.presenter.inter.IHomeFPresenter;
import com.dc.baseproject.view.inter.IHomeFView;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.schedulers.Schedulers;

public class HomeFPresenterImpl implements IHomeFPresenter {
    private IHomeFView mIHomeFView;
    private IHomeFModel mIHomeFModel;

    public HomeFPresenterImpl(IHomeFView fIHomeFView) {
        mIHomeFView = fIHomeFView;
        mIHomeFModel = new HomeFModelImpl();
    }

    /**
     * 首页上半部分数据请求
     */
    @Override
    public void getHomeTopData() {
        Log.e("HomeFragment", "HomeFPresenterImpl-----40-->首页上半部分数据请求");
        //进行网络请求
        RetrofitHelper.getInstance().getRetrofitService().getHomeTopData()
                .subscribeOn(Schedulers.io())//在子线程中进行HTTP请求
                .observeOn(AndroidSchedulers.mainThread())//UI线程处理返回接口
                .subscribe(new DefaultObserver<HomeTopDataEntity>() {
                    @Override
                    public void onNext(HomeTopDataEntity homeTopDataEntity) {
                        //请求成功之后所做的处理
                        mIHomeFView.response(homeTopDataEntity, 1);
                        Log.e("HomeFragment", "HomeFPresenterImpl--onNext---41-->homeTopDataEntity" + homeTopDataEntity.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("HomeFragment", "HomeFPresenterImpl--onError---46-->homeTopDataEntity" + e);
                    }

                    @Override
                    public void onComplete() {
                        Log.e("HomeFragment", "HomeFPresenterImpl--onComplete---41-->homeTopDataEntity");
                    }
                });//订阅
    }
}

package com.dc.baseproject.presenter.impl;

import com.dc.baseproject.model.impl.MainAModelImpl;
import com.dc.baseproject.model.inter.IMainAModel;
import com.dc.baseproject.presenter.inter.IMainAPresenter;
import com.dc.baseproject.view.inter.IMainAView;

public class MainAPresenterImpl implements IMainAPresenter {
    private IMainAView mIMainAView;
    private IMainAModel mIMainAModel;

    public MainAPresenterImpl(IMainAView aIMainAView) {
        mIMainAView = aIMainAView;
        mIMainAModel = new MainAModelImpl();
    }
}

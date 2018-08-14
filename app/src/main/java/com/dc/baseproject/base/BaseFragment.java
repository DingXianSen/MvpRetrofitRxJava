package com.dc.baseproject.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dc.baseproject.R;
import com.dc.dcscreenadaptation.ScreenAdapterTools;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by Raul_lsj on 2018/3/9.
 */

public abstract class BaseFragment extends Fragment {

    protected View view;
    protected LayoutInflater inflater;
    private Unbinder unBinder;

    protected Activity mActivity;
    protected Context mContext;
    protected Context appContext;
    protected Application mApplication;

    private static Toast toast;



    /*懒加载相关*/

    protected boolean mIsViewInitiated;
    protected boolean mIsVisibleToUser;
    protected boolean mIsDataInitiated;

    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        appContext = mActivity.getApplicationContext();
        mApplication = mActivity.getApplication();
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayout(), container, false);
        //指出fragment愿意添加item到选项菜单
        //Fragment适配
        ScreenAdapterTools.getInstance().loadView(view);
//        setHasOptionsMenu(true);
        /**/
        unBinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initEvent();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inflater = onGetLayoutInflater(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        unBinder.unbind();
        super.onDestroyView();
    }

    public void showMsg(String msg) {
        toast = Toast.makeText(appContext, "", Toast.LENGTH_SHORT);
        toast.setText(msg);
        toast.show();
    }


    protected abstract int getLayout();

    protected abstract void initEvent();

    protected abstract void initView();

    /*懒加载相关*/
    /*数据加载*/
    protected abstract void fetchData();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        mIsVisibleToUser = isVisibleToUser;
        initFetchData();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mIsViewInitiated = true;
        initFetchData();
    }

    protected void initFetchData() {
        if (mIsVisibleToUser && mIsViewInitiated && !mIsDataInitiated) {
            fetchData();
            mIsDataInitiated = true;
        }
    }


}

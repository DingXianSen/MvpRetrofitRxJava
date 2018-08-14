package com.dc.baseproject.view.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dc.baseproject.R;
import com.dc.baseproject.base.BaseFragment;
import com.dc.baseproject.util.DialogUtil;

/**
 * @ClassName: PuFragment
 * @Description: 商铺Fragment
 * @Author: dingchao
 * @Date: 2018/7/20 11:46
 */
public class PuFragment extends BaseFragment {
    private View parent;
    private Context context;

    @Override
    protected int getLayout() {
        return R.layout.fragment_pu;
    }

    @Override
    protected void initEvent() {
        context=getContext();
        Toast.makeText(mActivity, "加载中。。。", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initView() {

    }


    /*数据加载*/
    @Override
    protected void fetchData() {
        Toast.makeText(mActivity, "数据加载中。。。", Toast.LENGTH_SHORT).show();

        Dialog dialog = DialogUtil.createLoadingDialog(context, "数据加载中...");
    }

    public static PuFragment newInstance() {
        PuFragment fragment = new PuFragment();
        return fragment;
    }
}

package com.dc.baseproject.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.dc.dcscreenadaptation.ScreenAdapterTools;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * @ClassName: BaseActivity
 * @Description: Activity基类
 * @Author: dingchao
 * @Date: 2018/8/8 13:50
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected Context mContext;
    protected Activity mActivity;
    protected Context appContext;
    protected Application mApplication;

    protected static Toast toast;
    protected Unbinder mUnbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mActivity = this;
        appContext = getApplicationContext();
        mApplication = getApplication();




        setContentView(getLayout());
//        注意绑定要在绑定试图之后写
        mUnbinder = ButterKnife.bind(this);


        setOrientation();
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0 全透明状态栏
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4 全透明状态栏
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }*/

        initEvent();
    }

    @Override
    protected void onDestroy() {
        mUnbinder.unbind();
        super.onDestroy();
    }

    public void showMsg(String msg) {
        toast = Toast.makeText(appContext, "", Toast.LENGTH_SHORT);
        toast.setText(msg);
        toast.show();
    }


    /**
     * 最新屏幕适配测试
     */

    public void setOrientation() {
//        Density.setDefault(mActivity);
        ScreenAdapterTools.getInstance().reset(this);//如果希望android7.0分屏也适配的话,加上这句
        ScreenAdapterTools.getInstance().loadView(getWindow().getDecorView());

    }

    protected abstract int getLayout();

    protected abstract void initEvent();
}


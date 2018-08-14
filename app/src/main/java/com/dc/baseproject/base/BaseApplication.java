package com.dc.baseproject.base;

import android.app.Application;
import android.content.res.Configuration;

import com.dc.dcscreenadaptation.ScreenAdapterTools;

/**
 * 项目启动配置Application
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            return;
//        }
//        LeakCanary.install(this);
        ScreenAdapterTools.init(this);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        ScreenAdapterTools.getInstance().reset(this);

    }
}
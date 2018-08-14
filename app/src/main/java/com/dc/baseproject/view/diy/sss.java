package com.dc.baseproject.view.diy;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * @ClassName: ViewPagerSlide
 * @Description: 控制ViewPager是否开启左右滑动,Fragment切换
 * @Author: dingchao
 * @Date: 2018/7/23 10:43
 */
public class sss extends ViewPager {
    //是否可以进行滑动
    private boolean isSlide = false;

    public void setSlide(boolean slide) {
        isSlide = slide;
    }
    public sss(Context context) {
        super(context);
    }

    public sss(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return isSlide;
    }
}

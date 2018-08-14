package com.dc.baseproject.view.diy.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;

/**
 * Author:dingchao
 * TIme:2018/5/30：17:44
 * Description:MyViewPager
 * 描述：首页轮播图
 */

public class MyViewPager extends ViewPager {
    private ViewGroup parent;
    private int downX;
    private int downY;

    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setNestedpParent(ViewGroup parent) {
        this.parent = parent;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 让当前viewpager的父控件不去拦截touch事件
                downX = (int) ev.getX();
                downY = (int) ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int moveX = (int) ev.getX();
                int moveY = (int) ev.getY();
                if (Math.abs(moveX - downX) >= Math.abs(moveY - downY)) {
                    // 滑动轮播图
                    getParent().getParent().getParent().getParent().requestDisallowInterceptTouchEvent(true);
                } else {
                    // 刷新listview
                    getParent().getParent().getParent().getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
        }
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return super.onTouchEvent(ev);
    }
}

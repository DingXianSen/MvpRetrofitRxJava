package com.dc.baseproject.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dc.baseproject.R;
import com.dc.baseproject.bean.HomeTopDataEntity;
import com.dc.baseproject.view.diy.home.MultipleItem;
import com.dc.baseproject.view.diy.viewpager.MyViewPager;

import java.util.List;

/**
 * @ClassName: MultipleItemQuickAdapter
 * @Description: 总的适配器
 * @Author: dingchao
 * @Date: 2018/8/10 16:06
 */
public class MultipleItemQuickAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {
    private Context context;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public MultipleItemQuickAdapter(List<MultipleItem> data, Context context) {
        super(data);
        this.context = context;

//        添加Type对应的布局
        addItemType(MultipleItem.TYPE_0, R.layout.head_rv_banner);//轮播图
        addItemType(MultipleItem.TYPE_1, R.layout.head_rv_av);//按钮
        addItemType(MultipleItem.TYPE_2, R.layout.head_rv_number);//数字
        addItemType(MultipleItem.TYPE_3, R.layout.head_rv_marqueeview);//资讯
        addItemType(MultipleItem.TYPE_4, R.layout.head_rv_pulist);//列表
    }


    /*轮播图自动滑动*/
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                if (head_viewPager != null) {
                    head_viewPager.setCurrentItem(head_viewPager.getCurrentItem() + 1);
                }
//                handler.sendEmptyMessageDelayed(0, 5000);
            }
        }
    };


    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
//        根据不同的type值处理不同的数据绑定
        switch (helper.getItemViewType()) {
            case MultipleItem.TYPE_0:
                initViewPager(helper, item.getImgUrlBeanList());
//                initViewPager(helper,item.getDataText());
                break;
            case MultipleItem.TYPE_1:
                initAn(helper, item.getDataText());
                break;
            case MultipleItem.TYPE_2:
                initNum(helper, item.getDataText());
                break;
            case MultipleItem.TYPE_3:
                initZx(helper, item.getDataText());
                break;
            case MultipleItem.TYPE_4:
                initList(helper, item.getDataText());
                break;
        }
    }

    private TextView tv_banner, tv_an, tv_num, tv_zx, tv_list;


    /*banner相关*/
    private MyViewPager head_viewPager;
    private LinearLayout mIndicator;
    private ImageView[] mImageView;
    private HomeBannerAdapter homeBannerAdapter;//首页轮播图适配器

    //初始化轮播图
    private void initViewPager(BaseViewHolder helper, List<HomeTopDataEntity.DataBean.ImgUrlBean> imgUrlBean) {
        Log.e("HomeFragment", "initViewPager-------74-->imgUrlBean.size():" + imgUrlBean.size());
//    private void initViewPager(BaseViewHolder helper, String dataText) {
        head_viewPager = helper.getView(R.id.head_viewPager);
        mIndicator = helper.getView(R.id.indicator);

        homeBannerAdapter = new HomeBannerAdapter(context, imgUrlBean);
        head_viewPager.setAdapter(homeBannerAdapter);

        int i = head_viewPager.getCurrentItem();

        head_viewPager.setCurrentItem(6000 * (i % imgUrlBean.size() + 1));

        if (imgUrlBean != null) {
            initIndicator(imgUrlBean);
        }

        head_viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setIndicator(position, imgUrlBean);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                /**
                 * state==1:正在滑动状态
                 * state==2:滑动完毕状态
                 * state==0:什么都没操作
                 */
                switch (state) {
                    case 0:
                        break;
                    case 1:
                        handler.removeCallbacksAndMessages(null);
                        break;
                    case 2:
                        handler.sendEmptyMessageDelayed(0, 5000);
                        break;
                }
            }
        });
        if (!handler.hasMessages(0)) {
            handler.sendEmptyMessage(0);
        }

    }

    //初始化按钮
    private void initAn(BaseViewHolder helper, String dataText) {
        tv_an = helper.getView(R.id.tv_av);
        tv_an.setText(dataText);
    }

    //初始化数字
    private void initNum(BaseViewHolder helper, String dataText) {
        tv_num = helper.getView(R.id.tv_num);
        tv_num.setText(dataText);
    }

    //初始化资讯
    private void initZx(BaseViewHolder helper, String dataText) {
        tv_zx = helper.getView(R.id.tv_zx);
        tv_zx.setText(dataText);
    }

    //初始化列表
    private void initList(BaseViewHolder helper, String dataText) {
        tv_list = helper.getView(R.id.tv_list);
        tv_list.setText(dataText);
    }


    /*设置轮播图的点*/
    private void initIndicator(List<HomeTopDataEntity.DataBean.ImgUrlBean> url) {
        mImageView = new ImageView[url.size()];
        for (int i = 0; i < url.size(); i++) {
            View view = LayoutInflater.from(context).inflate(R.layout.home_indicator_image, null);
            view.findViewById(R.id.indicator_iamge).setBackgroundResource(R.mipmap.hong_indicator);
            view.findViewById(R.id.indicator_iamge).setBackgroundResource(R.mipmap.hong_indicator);
            mImageView[i] = new ImageView(context);
            if (i == 0) {
                mImageView[i].setBackgroundResource(R.mipmap.hong_indicator);
            } else {
                mImageView[i].setBackgroundResource(R.mipmap.hui_indicator);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.setMargins(20, 0, 0, 0);
                mImageView[i].setLayoutParams(layoutParams);
            }
            mIndicator.addView(mImageView[i]);
        }
    }

    /*设置几个banner图动态生成*/
    private void setIndicator(int position, List<HomeTopDataEntity.DataBean.ImgUrlBean> url) {
        position %= url.size();
        for (int i = 0; i < url.size(); i++) {
            mImageView[i].setBackgroundResource(R.mipmap.hong_indicator);
            if (position != i) {
                mImageView[i].setBackgroundResource(R.mipmap.hui_indicator);
            }
        }
    }
}

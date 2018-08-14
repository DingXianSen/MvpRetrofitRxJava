package com.dc.baseproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.dc.baseproject.R;
import com.dc.baseproject.bean.HomeTopDataEntity;

import java.util.List;

/**
 * @ClassName: HomeBannerAdapter
 * @Description: 首页轮播图适配器
 * @Author: dingchao
 * @Date: 2018/8/13 17:04
 */
public class HomeBannerAdapter extends PagerAdapter {
    private Context context;
    private List<HomeTopDataEntity.DataBean.ImgUrlBean> imgUrlBeanList;

    public HomeBannerAdapter(Context context, List<HomeTopDataEntity.DataBean.ImgUrlBean> imgUrlBeanList) {
        this.context = context;
        this.imgUrlBeanList = imgUrlBeanList;
    }

    @Override
    public int getCount() {
        //因为要是实现无限循环功能，所以这里不规定Count
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(params);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        position %= imgUrlBeanList.size();
        if (position < 0) {
            position = imgUrlBeanList.size() + position;
        }
        //判断非空
        if (imgUrlBeanList.get(position % imgUrlBeanList.size()).getUrl() != null && !("").equals(imgUrlBeanList.get(position % imgUrlBeanList.size()).getUrl())) {
            //图片加载使用Glide4.7设置方法不同
            //override(400,400);//指定图片的尺寸
            //.circleCrop();//圆形图片

            RequestOptions options = new RequestOptions()
                    .placeholder(R.mipmap.dialog_loading_img)//加载成功之前的占位图
                    .error(R.mipmap.ic_launcher)//加载错误之后的错误图
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
            Glide.with(context)
                    .load(imgUrlBeanList.get(position % imgUrlBeanList.size()).getUrl())//加载的地址
                    .apply(options).into(imageView);

        }
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<HomeTopDataEntity.DataBean.ImgUrlBean> getImgUrlBeanList() {
        return imgUrlBeanList;
    }

    public void setImgUrlBeanList(List<HomeTopDataEntity.DataBean.ImgUrlBean> imgUrlBeanList) {
        this.imgUrlBeanList = imgUrlBeanList;
    }
}

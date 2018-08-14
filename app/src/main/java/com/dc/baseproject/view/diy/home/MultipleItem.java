package com.dc.baseproject.view.diy.home;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.dc.baseproject.bean.HomeTopDataEntity;

import java.util.List;

/**
 * @ClassName: MultipleItem
 * @Description: 首页多布局单项
 * @Author: dingchao
 * @Date: 2018/8/10 15:56
 */
public class MultipleItem implements MultiItemEntity {

    //添加type
    private int itemType;//判断是那种布局类型


    //暂时使用的数据
    private String dataText;

    //定义类型
    public static final int TYPE_0 = 0;//banner
    public static final int TYPE_1 = 1;//三个按钮区域
    public static final int TYPE_2 = 2;//数字区域
    public static final int TYPE_3 = 3;//咨询区域
    public static final int TYPE_4 = 4;//列表区域


    //    权重
    public static final int TYPE_SPAN_SIZE_1 = 1;
    public int spanSize;

    private List<HomeTopDataEntity.DataBean.ImgUrlBean> imgUrlBeanList;


    @Override
    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public String getDataText() {
        return dataText;
    }

    public void setDataText(String dataText) {
        this.dataText = dataText;
    }


    /*创建构造函数*/

    public MultipleItem(int itemType, int spanSize, String dataText) {
        this.itemType = itemType;
        this.dataText = dataText;
        this.spanSize = spanSize;
    }

    public MultipleItem(int itemType, int spanSize, List<HomeTopDataEntity.DataBean.ImgUrlBean> imgUrlBean) {
        this.itemType = itemType;
        this.spanSize = spanSize;
        this.imgUrlBeanList = imgUrlBean;
    }

    public int getSpanSize() {
        return spanSize;
    }

    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }

    public List<HomeTopDataEntity.DataBean.ImgUrlBean> getImgUrlBeanList() {
        return imgUrlBeanList;
    }

    public void setImgUrlBeanList(List<HomeTopDataEntity.DataBean.ImgUrlBean> imgUrlBeanList) {
        this.imgUrlBeanList = imgUrlBeanList;
    }
}

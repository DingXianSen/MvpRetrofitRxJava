package com.dc.baseproject.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dc.baseproject.R;
import com.dc.baseproject.adapter.MultipleItemQuickAdapter;
import com.dc.baseproject.base.BaseFragment;
import com.dc.baseproject.bean.HomeTopDataEntity;
import com.dc.baseproject.presenter.impl.HomeFPresenterImpl;
import com.dc.baseproject.presenter.inter.IHomeFPresenter;
import com.dc.baseproject.view.diy.home.MultipleItem;
import com.dc.baseproject.view.inter.IHomeFView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @ClassName: PuFragment
 * @Description: 商铺Fragment
 * @Author: dingchao
 * @Date: 2018/7/20 11:46
 */
public class HomeFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, IHomeFView {
    private View parent;
    private Context context;


    //    数据实体
    HomeTopDataEntity homeTopDataEntity;
    HomeTopDataEntity.DataBean.ImgUrlBean imgUrlBean = null;


    @BindView(R.id.type_item_recyclerview)
    RecyclerView mRecyclerView;

    @BindView(R.id.type_item_swipfreshlayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private IHomeFPresenter mIHomeFPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIHomeFPresenter = new HomeFPresenterImpl(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initEvent() {
        context = getContext();
    }

    @Override
    protected void initView() {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent, R.color.colorPrimaryDark);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        //实现首次自动显示加载提示
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
            }
        });

        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);//可防止Item切换
        mRecyclerView.setLayoutManager(layoutManager);
    }

    //    首页获取数据
    private List<MultipleItem> getMultipleItemData() {
        Log.e("HomeFragment", "HomeFragment-----87-->getMultipleItemData");
        List<MultipleItem> data = new ArrayList<>();
        String sss = null;
        data.add(new MultipleItem(MultipleItem.TYPE_0, MultipleItem.TYPE_SPAN_SIZE_1, homeTopDataEntity.getData().getImgUrl()));
//        data.add(new MultipleItem(MultipleItem.TYPE_1, MultipleItem.TYPE_SPAN_SIZE_1, "anniu"));
        data.add(new MultipleItem(MultipleItem.TYPE_1, MultipleItem.TYPE_SPAN_SIZE_1, sss));
        data.add(new MultipleItem(MultipleItem.TYPE_2, MultipleItem.TYPE_SPAN_SIZE_1, "number"));
        data.add(new MultipleItem(MultipleItem.TYPE_3, MultipleItem.TYPE_SPAN_SIZE_1, "zixun"));
        data.add(new MultipleItem(MultipleItem.TYPE_4, MultipleItem.TYPE_SPAN_SIZE_1, "list"));
        return data;
    }


    /*数据加载*/
    @Override
    protected void fetchData() {
        Toast.makeText(mActivity, "数据加载中。。。", Toast.LENGTH_SHORT).show();
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
        /*网络请求首页数据*/
        mIHomeFPresenter.getHomeTopData();

    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onRefresh() {
        fetchData();
    }

    @Override
    public <T> T request(int requestFlag) {
        return null;
    }

    @Override
    public <T> void response(T response, int responseFlag) {
        switch (responseFlag) {
            case 1://首页头部数据请求返回处理
                homeTopDataEntity = (HomeTopDataEntity) response;
                //        首页RecyclerView赋值操作
                if (homeTopDataEntity != null) {
                    String json = JSON.toJSONString(homeTopDataEntity);
                    Log.e("HomeFragment", "HomeFragment-----145-->!= null" + json);
                    MultipleItemQuickAdapter multipleItemQuickAdapter = new MultipleItemQuickAdapter(getMultipleItemData(), context);
                    GridLayoutManager manager = new GridLayoutManager(context, MultipleItem.TYPE_SPAN_SIZE_1);
                    mRecyclerView.setLayoutManager(manager);
                    multipleItemQuickAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
                        @Override
                        public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                            return getMultipleItemData().get(position).getSpanSize();
                        }
                    });
                    mRecyclerView.setAdapter(multipleItemQuickAdapter);
                    Log.e("HomeFragment", "HomeFragment-----145-->homeTopDataEntity" + homeTopDataEntity.toString());
                }
                break;
        }
    }
}

package com.fhx.wateraffairs.activity.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.adapter.HomeNewsNotifyAdapter;
import com.fhx.wateraffairs.base.AppUrl;
import com.fhx.wateraffairs.base.BaseActivity;
import com.fhx.wateraffairs.bean.HomeNewsNotifyBean;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewsNotifyActivity extends BaseActivity {
    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.recycle_news)
    RecyclerView recycleNews;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private HomeNewsNotifyAdapter adapter;
    private List<HomeNewsNotifyBean.RowsBean> mList = new ArrayList<>();

    int page = 1;

    @Override
    protected int initLayout() {
        return R.layout.activity_new_notify;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        tvTitle.setText("新闻公告");

        recycleNews.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HomeNewsNotifyAdapter(mList);

        recycleNews.setAdapter(adapter);
        page = 1;
        warnPageList(page);
    }

    @Override
    protected void initListen() {
        refresh.setOnRefreshListener(refreshLayout -> {
            mList.clear();
            page = 1;
            warnPageList(page);
        });
        refresh.setOnLoadMoreListener(refreshLayout -> {
            page++;
            warnPageList(page);
        });
    }

    @OnClick(R.id.image_back)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                FinishActivity();
                break;
        }
    }

    private void warnPageList(int page) {
        EasyHttp.get(AppUrl.WarnPageList)
                .headers("Authorization", mmkv.decodeString("token"))
                .params("pageNum", page + "")
                .params("pageSize", 10 + "")
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        refresh.finishLoadMore();
                        refresh.finishRefresh();
                    }

                    @Override
                    public void onSuccess(String s) {
                        refresh.finishLoadMore();
                        refresh.finishRefresh();
                        HomeNewsNotifyBean homeNewsNotifyBean = JSON.parseObject(s, HomeNewsNotifyBean.class);
                        if (homeNewsNotifyBean.getCode() == 200) {
                            mList.addAll(homeNewsNotifyBean.getRows());
                            adapter.notifyDataSetChanged();
                        }
                    }
                });

    }
}

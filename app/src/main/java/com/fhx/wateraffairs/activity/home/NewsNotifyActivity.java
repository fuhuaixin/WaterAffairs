package com.fhx.wateraffairs.activity.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.adapter.HomeNewsNotifyAdapter;
import com.fhx.wateraffairs.base.BaseActivity;
import com.fhx.wateraffairs.bean.HomeNewsNotifyBean;

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

    private HomeNewsNotifyAdapter adapter;
    private List<HomeNewsNotifyBean> mList =new ArrayList<>();

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
        LayoutInflater inflater=LayoutInflater.from(this);
        View inflate = inflater.inflate(R.layout.adapter_home_news_header,null);
        mList.add(new HomeNewsNotifyBean("这里是资讯标题","这里是简介文字，这里是简介文字...","2020/12/31",R.mipmap.ic_news_one));
        mList.add(new HomeNewsNotifyBean("这里是资讯标题2","这里是简介文字，这里是简介文字...","2020/12/31",R.mipmap.ic_news_two));
        mList.add(new HomeNewsNotifyBean("这里是资讯标题3","这里是简介文字，这里是简介文字...","2020/12/31",R.mipmap.ic_news_three));
        mList.add(new HomeNewsNotifyBean("这里是资讯标题4","这里是简介文字，这里是简介文字...","2020/12/31",R.mipmap.ic_news_four));
        recycleNews.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HomeNewsNotifyAdapter(mList);
        adapter.addHeaderView(inflate);
        recycleNews.setAdapter(adapter);
    }

    @Override
    protected void initListen() {

    }

    @OnClick(R.id.image_back)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.image_back:
                FinishActivity();
                break;
        }
    }
}

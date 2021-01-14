package com.fhx.wateraffairs.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.bean.HomeNewsNotifyBean;

import java.util.List;

public class HomeNewsNotifyAdapter extends BaseQuickAdapter<HomeNewsNotifyBean, BaseViewHolder> {
    public HomeNewsNotifyAdapter( @Nullable List<HomeNewsNotifyBean> data) {
        super(R.layout.adapter_home_news_notify, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeNewsNotifyBean item) {
        helper.setImageResource(R.id.image,item.getImage());
        helper.setText(R.id.tv_title,item.getTitle())
                .setText(R.id.tv_msg,item.getMsg())
                .setText(R.id.tv_time,item.getTime());

    }
}

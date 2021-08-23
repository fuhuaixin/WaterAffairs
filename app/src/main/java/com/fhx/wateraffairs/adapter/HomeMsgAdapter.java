package com.fhx.wateraffairs.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.bean.HomeMessageBean;

import java.util.List;

public class HomeMsgAdapter extends BaseQuickAdapter<HomeMessageBean.DataBean.RecordsBean, BaseViewHolder> {
    public HomeMsgAdapter(@Nullable List<HomeMessageBean.DataBean.RecordsBean> data) {
        super(R.layout.adapter_home_msg, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeMessageBean.DataBean.RecordsBean item) {

        helper.setText(R.id.tv_pass, item.getNewsTitle())
                .setText(R.id.tv_time, item.getCreateTime())
                .setText(R.id.tv_msg, item.getNewsContent());

    }
}

package com.fhx.wateraffairs.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.bean.HomeMessageBean;

import java.util.List;

public class HomeMsgAdapter extends BaseQuickAdapter<HomeMessageBean, BaseViewHolder> {
    public HomeMsgAdapter(@Nullable List<HomeMessageBean> data) {
        super(R.layout.adapter_home_msg, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeMessageBean item) {
        if (item.isPass()) {
            helper.setText(R.id.tv_pass, "审核成功通知");
            helper.setImageResource(R.id.view_pass, R.drawable.shape_green_dot);
        } else {
            helper.setText(R.id.tv_pass, "审核失败通知");
            helper.setImageResource(R.id.view_pass, R.drawable.shape_orgen_dot);
        }
        helper.setText(R.id.tv_time, item.getTime())
                .setText(R.id.tv_msg, item.getTitle());

    }
}

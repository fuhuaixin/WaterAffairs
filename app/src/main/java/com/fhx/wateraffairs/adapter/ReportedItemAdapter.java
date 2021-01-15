package com.fhx.wateraffairs.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.bean.ReportHistoryBean;
import com.fhx.wateraffairs.bean.WaterRecordListBean;

import java.util.List;

public class ReportedItemAdapter extends BaseQuickAdapter<ReportHistoryBean.HistoryItemBean, BaseViewHolder> {
    public ReportedItemAdapter(@Nullable List<ReportHistoryBean.HistoryItemBean> data) {
        super(R.layout.adapter_monitor_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ReportHistoryBean.HistoryItemBean item) {
        helper.setText(R.id.tv_title, item.getTitle());
        if (helper.getPosition() == 0) {
            helper.setVisible(R.id.view_line, false);
        } else {
            helper.setVisible(R.id.view_line, true);
        }

        helper.addOnClickListener(R.id.ll_item_item);
    }
}

package com.fhx.wateraffairs.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.bean.AnomalyRecordBean;

import java.util.List;

public class AnomalyRecordActAdapter extends BaseQuickAdapter<AnomalyRecordBean, BaseViewHolder> {
    public AnomalyRecordActAdapter( @Nullable List<AnomalyRecordBean> data) {
        super(R.layout.adapter_anomaly_record_act, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AnomalyRecordBean item) {
        helper.setText(R.id.tv_title,item.getTitle())
                .setText(R.id.tv_time,item.getTime());
        switch (item.getStatus()){
            case 0:
                helper.setText(R.id.tv_status,"已提交");
            helper.setImageResource(R.id.image_status,R.mipmap.icon_record_commit);

                break;
            case 1:
                helper.setText(R.id.tv_status,"处理中");
                helper.setImageResource(R.id.image_status,R.mipmap.icon_record_ing);
                break;
            case 2:
                helper.setText(R.id.tv_status,"已完成");
                helper.setImageResource(R.id.image_status,R.mipmap.icon_record_complant);
                break;
        }

        helper.addOnClickListener(R.id.ll_item);
    }
}

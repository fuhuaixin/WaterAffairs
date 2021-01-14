package com.fhx.wateraffairs.adapter;

import android.view.View;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.bean.AnomalyRecordBean;

import java.util.List;

public class AnomalyRecordAdapter extends BaseQuickAdapter<AnomalyRecordBean, BaseViewHolder> {

    public AnomalyRecordAdapter(@Nullable List<AnomalyRecordBean> data) {
        super(R.layout.adapter_anomaly_record,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AnomalyRecordBean item) {
        View view = helper.getView(R.id.view_top);
        if (helper.getPosition()==0){
            view.setVisibility(View.VISIBLE);
        }else {
            view.setVisibility(View.GONE);
        }

        switch (item.getStatus()){
            case 0:
                helper.setImageResource(R.id.image_status,R.mipmap.icon_anomaly_commit);
                break;
            case 1:
                helper.setImageResource(R.id.image_status,R.mipmap.icon_anomaly_ing);
                break;
            default:
                helper.setImageResource(R.id.image_status,R.mipmap.icon_anomaly_complant);

                break;
        }

        helper.setText(R.id.tv_title,item.getTitle())
                .setText(R.id.tv_time,item.getTime())
                .setText(R.id.tv_msg,item.getMsg());
    }
}

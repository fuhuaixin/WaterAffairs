package com.fhx.wateraffairs.adapter;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.base.AppUrl;
import com.fhx.wateraffairs.bean.MonitorVideoListBean;

import java.util.List;

public class MonitorVideoListAdapter extends BaseQuickAdapter<MonitorVideoListBean.DataBean.AllVideoUrlBean, BaseViewHolder> {

    private Context context;

    public MonitorVideoListAdapter( @Nullable List<MonitorVideoListBean.DataBean.AllVideoUrlBean> data, Context context) {
        super(R.layout.item_monitor_list, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, MonitorVideoListBean.DataBean.AllVideoUrlBean item) {

        helper.setText(R.id.tv_title, item.getVideoname());
        if (item.getImg() != null && !item.getImg().equals("")) {
            ImageView image_mes = helper.getView(R.id.image_mes);
            Glide.with(context).load(AppUrl.BASEURL + "zhjd" + item.getImg()).into(image_mes);
        }
        helper.addOnClickListener(R.id.ll_item);
    }
}

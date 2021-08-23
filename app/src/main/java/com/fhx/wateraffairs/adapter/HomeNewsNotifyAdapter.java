package com.fhx.wateraffairs.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.bean.HomeNewsNotifyBean;
import com.fhx.wateraffairs.utils.DateUtil;

import java.util.List;

public class HomeNewsNotifyAdapter extends BaseQuickAdapter<HomeNewsNotifyBean.RowsBean, BaseViewHolder> {
    public HomeNewsNotifyAdapter(@Nullable List<HomeNewsNotifyBean.RowsBean> data) {
        super(R.layout.adapter_home_news_notify, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeNewsNotifyBean.RowsBean item) {
        String createTime = item.getCreateTime();
        long yyyyMMddHHmmss = DateUtil.getStringToDate(createTime, "yyyyMMddHHmmss");
        String dateToString = DateUtil.getDateToString(yyyyMMddHHmmss, "yyyy-MM-dd");
        helper.setText(R.id.tv_title, item.getEquipId())
                .setText(R.id.tv_msg, item.getWarnData())
                .setText(R.id.tv_time, dateToString);

    }
}

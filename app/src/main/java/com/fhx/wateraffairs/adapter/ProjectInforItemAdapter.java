package com.fhx.wateraffairs.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.bean.ProjectInformationBean;

import java.util.List;

public class ProjectInforItemAdapter extends BaseQuickAdapter<ProjectInformationBean.ItemBean, BaseViewHolder> {
    public ProjectInforItemAdapter(@Nullable List<ProjectInformationBean.ItemBean> data) {
        super(R.layout.adapter_project_infor_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProjectInformationBean.ItemBean item) {
        helper.setText(R.id.tv_type, item.getType())
                .setText(R.id.tv_result, item.getMsg());
    }
}

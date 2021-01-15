package com.fhx.wateraffairs.adapter;

import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.bean.ProjectInformationBean;

import java.util.List;

public class ProjectInformationAdapter extends BaseQuickAdapter<ProjectInformationBean, BaseViewHolder> {

    ProjectInforItemAdapter itemAdapter;
    List<ProjectInformationBean> mList;

    public ProjectInformationAdapter(@Nullable List<ProjectInformationBean> data) {
        super(R.layout.adapter_project_information, data);
        this.mList = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, ProjectInformationBean item) {
        helper.setText(R.id.tv_title, item.getTitle());
        RecyclerView recycleItem = helper.getView(R.id.recycle_item);
        if (item.isIfOpen()) {
            helper.setImageResource(R.id.image, R.mipmap.icon_item_down);
            recycleItem.setVisibility(View.VISIBLE);
        } else {
            helper.setImageResource(R.id.image, R.mipmap.icon_item_right);
            recycleItem.setVisibility(View.GONE);
        }


        itemAdapter = new ProjectInforItemAdapter(item.getItemList());
        recycleItem.setLayoutManager(new LinearLayoutManager(mContext));
        recycleItem.setAdapter(itemAdapter);

        helper.addOnClickListener(R.id.ll_item);
    }
}

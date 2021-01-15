package com.fhx.wateraffairs.adapter;

import android.app.Activity;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.activity.home.MonitoringMsgActivity;
import com.fhx.wateraffairs.activity.home.ReportedHistoryMsgActivity;
import com.fhx.wateraffairs.bean.MonitorListBean;
import com.fhx.wateraffairs.bean.ReportHistoryBean;
import com.fhx.wateraffairs.utils.CutToUtils;

import java.util.List;

public class ReportHistoryAdapter extends BaseQuickAdapter<ReportHistoryBean, BaseViewHolder> {
    RecyclerView recycleItem;
    ReportedItemAdapter itemAdapter;
    private Activity activity;

    public ReportHistoryAdapter(Activity activity, @Nullable List<ReportHistoryBean> data) {
        super(R.layout.adapter_monitor_list, data);
        this.activity = activity;
    }


    @Override
    protected void convert(BaseViewHolder helper, ReportHistoryBean item) {
        helper.setText(R.id.tv_title, item.getTitle());
        recycleItem = helper.getView(R.id.recycle_item);
        if (item.isOpen()) {
            helper.setImageResource(R.id.image, R.mipmap.icon_item_down);
            recycleItem.setVisibility(View.VISIBLE);
        } else {
            helper.setImageResource(R.id.image, R.mipmap.icon_item_right);
            recycleItem.setVisibility(View.GONE);
        }

        recycleItem.setLayoutManager(new LinearLayoutManager(mContext));
        itemAdapter = new ReportedItemAdapter(item.getItemBeanList());
        recycleItem.setAdapter(itemAdapter);
        itemAdapter.setOnItemChildClickListener((adapter, view, position) ->
//                Toast.makeText(mContext, "点击了" + item.getTitle()+position, Toast.LENGTH_SHORT).show()
                        CutToUtils.getInstance().JumpTo(activity, ReportedHistoryMsgActivity.class)
        );

        helper.addOnClickListener(R.id.ll_item);
    }
}

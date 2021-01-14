package com.fhx.wateraffairs.adapter;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.activity.home.MonitoringMsgActivity;
import com.fhx.wateraffairs.bean.MonitorListBean;
import com.fhx.wateraffairs.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

public class MonitorListAdapter extends BaseQuickAdapter<MonitorListBean, BaseViewHolder> {
    RecyclerView recycleItem;
    MonitorItemAdapter itemAdapter;
    private Activity activity;
    public MonitorListAdapter(Activity activity,@Nullable List<MonitorListBean> data) {
        super(R.layout.adapter_monitor_list, data);
        this.activity =activity;
    }



    @Override
    protected void convert(BaseViewHolder helper, MonitorListBean item) {
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
        itemAdapter = new MonitorItemAdapter(item.getItemBeanList());
        recycleItem.setAdapter(itemAdapter);
        itemAdapter.setOnItemChildClickListener((adapter, view, position) ->
//                Toast.makeText(mContext, "点击了" + item.getTitle()+position, Toast.LENGTH_SHORT).show()
                        CutToUtils.getInstance().JumpTo(activity, MonitoringMsgActivity.class)
        );

        helper.addOnClickListener(R.id.ll_item);
    }
}

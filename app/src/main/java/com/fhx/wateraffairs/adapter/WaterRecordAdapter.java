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
import com.fhx.wateraffairs.activity.home.ChangeWaterRecordActivity;
import com.fhx.wateraffairs.activity.home.MonitoringMsgActivity;
import com.fhx.wateraffairs.activity.home.WaterCollectRecordActivity;
import com.fhx.wateraffairs.bean.MonitorListBean;
import com.fhx.wateraffairs.bean.WaterRecordListBean;
import com.fhx.wateraffairs.utils.CutToUtils;

import java.util.List;

public class WaterRecordAdapter extends BaseQuickAdapter<WaterRecordListBean, BaseViewHolder> {
    RecyclerView recycleItem;
    WaterRecordItemAdapter itemAdapter;
    WaterCollectRecordActivity activity;
    public WaterRecordAdapter(WaterCollectRecordActivity activity, @Nullable List<WaterRecordListBean> data) {
        super(R.layout.adapter_monitor_list, data);
        this.activity =activity;
    }



    @Override
    protected void convert(BaseViewHolder helper, WaterRecordListBean item) {
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
        itemAdapter = new WaterRecordItemAdapter(item.getItemBeanList());
        recycleItem.setAdapter(itemAdapter);
        itemAdapter.setOnItemChildClickListener((adapter, view, position) ->{
            switch (view.getId()){
                case R.id.btnDel:
                    activity.Try(helper.getAdapterPosition(),position);
                    break;
                case R.id.ll_item_item:
//                    Toast.makeText(mContext, "点击了" + item.getTitle()+position, Toast.LENGTH_SHORT).show()
                    CutToUtils.getInstance().JumpTo(activity, ChangeWaterRecordActivity.class);
                    break;

            }
                }
//
        );


        helper.addOnClickListener(R.id.ll_item);
    }
}

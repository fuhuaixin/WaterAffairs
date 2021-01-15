package com.fhx.wateraffairs.adapter;

import android.app.Activity;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.activity.home.ContactsActivity;
import com.fhx.wateraffairs.activity.home.ContactsMsgActivity;
import com.fhx.wateraffairs.activity.patrol.AnomalyRecordMsgActivity;
import com.fhx.wateraffairs.bean.ContactsBean;
import com.fhx.wateraffairs.utils.CutToUtils;

import java.util.List;

public class ContactsTopAdapter extends BaseQuickAdapter<ContactsBean, BaseViewHolder> {
    Activity activity;
    public ContactsTopAdapter(Activity activity,@Nullable List<ContactsBean> data) {
        super(R.layout.adapter_contacts, data);
        this.activity =activity;
    }

    RecyclerView recycleItem;
    ContactsTopItemAdapter itemAdapter;
    @Override
    protected void convert(BaseViewHolder helper, ContactsBean item) {
        if (helper.getAdapterPosition()==0){
            helper.setVisible(R.id.view_line,false);
        }else {
            helper.setVisible(R.id.view_line,true);
        }
        helper.setText(R.id.tv_title,item.getTitle()+"("+item.getTotal()+")");
        recycleItem = helper.getView(R.id.recycle_item);
        if (item.isOpen()){
            helper.setImageResource(R.id.image_down,R.mipmap.icon_monitor_up);
            recycleItem.setVisibility(View.VISIBLE);
            recycleItem.setLayoutManager(new LinearLayoutManager(mContext));
            itemAdapter =new ContactsTopItemAdapter(item.getItemList());
            recycleItem.setAdapter(itemAdapter);
            itemAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
                @Override
                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                    CutToUtils.getInstance().JumpTo(activity, ContactsMsgActivity.class);
                }
            });
        }else {
            helper.setImageResource(R.id.image_down,R.mipmap.icon_monitor_down);
            recycleItem.setVisibility(View.GONE);
        }


        helper.addOnClickListener(R.id.ll_item);
    }
}

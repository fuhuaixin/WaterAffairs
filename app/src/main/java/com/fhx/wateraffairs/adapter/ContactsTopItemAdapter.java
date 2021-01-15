package com.fhx.wateraffairs.adapter;


import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.bean.ContactsBean;

import java.util.List;

public class ContactsTopItemAdapter extends BaseQuickAdapter<ContactsBean.ContactsMsgBean, BaseViewHolder> {
    public ContactsTopItemAdapter(@Nullable List<ContactsBean.ContactsMsgBean> data) {
        super(R.layout.adapter_contacts_top_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ContactsBean.ContactsMsgBean item) {
        if (helper.getAdapterPosition()==0){
            helper.setVisible(R.id.view_line,false);
        }else {
            helper.setVisible(R.id.view_line,true);
        }
        helper.setText(R.id.tv_name,item.getName())
        .setText(R.id.tv_job,item.getJob())
        .setText(R.id.tv_phone,item.getPhone());

        helper.addOnClickListener(R.id.ll_item);
    }
}

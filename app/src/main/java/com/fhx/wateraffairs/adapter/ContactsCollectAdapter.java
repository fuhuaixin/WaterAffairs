package com.fhx.wateraffairs.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.bean.ContactsCollectBean;

import java.util.List;

public class ContactsCollectAdapter extends BaseQuickAdapter<ContactsCollectBean, BaseViewHolder> {
    public ContactsCollectAdapter( @Nullable List<ContactsCollectBean> data) {
        super(R.layout.adapter_contacts_top_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ContactsCollectBean item) {
        helper.setText(R.id.tv_name,item.getName())
                .setText(R.id.tv_job,item.getJob())
                .setText(R.id.tv_phone,item.getPhone());

        helper.addOnClickListener(R.id.ll_item,R.id.ll_call);
    }
}

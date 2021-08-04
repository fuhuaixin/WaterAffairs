package com.fhx.wateraffairs.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.wateraffairs.R;

import java.util.List;

public class RecordWriteAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public RecordWriteAdapter(@Nullable List<String> data) {
        super(R.layout.adapter_record_write, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_title, item);
        helper.addOnClickListener(R.id.ll_item);
    }
}

package com.fhx.wateraffairs.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.wateraffairs.R;

import java.util.List;

public class ListDailogAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public ListDailogAdapter(@Nullable List<String> data) {
        super(R.layout.adapter_list_dialog, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        if (helper.getPosition()==0){
            helper.setVisible(R.id.view_line,false);
        }else {
            helper.setVisible(R.id.view_line,true);
        }

        helper.setText(R.id.tv_choose,item);

        helper.addOnClickListener(R.id.ll_item);
    }
}

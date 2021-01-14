package com.fhx.wateraffairs.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.bean.MineListBean;

import java.util.List;

public class MineListAdapter extends BaseQuickAdapter<MineListBean, BaseViewHolder> {
    public MineListAdapter( @Nullable List<MineListBean> data) {
        super(R.layout.adapter_mine_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MineListBean item) {
        helper.setText(R.id.tv_title,item.getName());
        helper.setImageResource(R.id.image,item.getIcon());
        if (item.isIfShow()){
            helper.setVisible(R.id.view_red_dot,true);
            helper.setVisible(R.id.tv_new,true);
        }else {
            helper.setVisible(R.id.view_red_dot,false);
            helper.setVisible(R.id.tv_new,false);
        }

        helper.addOnClickListener(R.id.ll_item);
    }
}

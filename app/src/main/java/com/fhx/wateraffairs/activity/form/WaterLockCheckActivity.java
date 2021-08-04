package com.fhx.wateraffairs.activity.form;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.adapter.BaseExpandAdapter;
import com.fhx.wateraffairs.base.BaseActivity;
import com.fhx.wateraffairs.bean.BaseGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 水闸外观形态检测
 */
public class WaterLockCheckActivity extends BaseActivity {
    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.image_right)
    ImageView imageRight;
    @BindView(R.id.expand_listview)
    ExpandableListView expandListview;

    BaseExpandAdapter expandAdapter;
    List<BaseGroup> mGroupList;
    List<BaseGroup.Item> mItemList ;
    @Override
    protected int initLayout() {
        return R.layout.activity_water_lock_check;
    }

    @Override
    protected void initView() {
        tvTitle.setText("水闸外观形态检测记录表");
        imageRight.setImageResource(R.mipmap.icon_title_right_confirm);
    }

    @Override
    protected void initData() {
        mGroupList =new ArrayList<>();
        mItemList =new ArrayList<>();

        mItemList.add(new BaseGroup.Item("枢纽名称：","请输入"));
        mItemList.add(new BaseGroup.Item("工程名称：","请输入"));
        mItemList.add(new BaseGroup.Item(" 闸孔号：","请输入"));
        mGroupList.add(new BaseGroup("基础内容",mItemList));

        mItemList =new ArrayList<>();
        mItemList.add(new BaseGroup.Item("门体：","请输入"));
        mItemList.add(new BaseGroup.Item("焊缝：","请输入"));
        mItemList.add(new BaseGroup.Item("吊耳、吊钩、吊杆：","请输入"));
        mItemList.add(new BaseGroup.Item("连接螺栓：","请输入"));
        mItemList.add(new BaseGroup.Item("充水阀：","请输入"));
        mItemList.add(new BaseGroup.Item("止水装置：","请输入"));
        mItemList.add(new BaseGroup.Item("制动器：","请输入"));
        mItemList.add(new BaseGroup.Item("锁定装置：","请输入"));
        mItemList.add(new BaseGroup.Item("滑轮组：","请输入"));
        mItemList.add(new BaseGroup.Item("侧反向支承：","请输入"));
        mItemList.add(new BaseGroup.Item("行走支承：","请输入"));
        mItemList.add(new BaseGroup.Item("埋设件：","请输入"));
        mItemList.add(new BaseGroup.Item("启闭机机架：","请输入"));
        mItemList.add(new BaseGroup.Item("传动轴：","请输入"));
        mItemList.add(new BaseGroup.Item("开式齿轮：","请输入"));
        mItemList.add(new BaseGroup.Item("卷筒：","请输入"));
        mItemList.add(new BaseGroup.Item("螺杆、螺母：","请输入"));
        mItemList.add(new BaseGroup.Item("液压启闭机：","请输入"));
        mGroupList.add(new BaseGroup("检查内容",mItemList));

        expandAdapter =new BaseExpandAdapter(mGroupList,this);
        expandListview.setAdapter(expandAdapter);
        for(int i = 0; i < expandAdapter.getGroupCount(); i++){
            expandListview.expandGroup(i);
        }
    }

    @Override
    protected void initListen() {
        expandListview.setOnGroupClickListener((parent, v, groupPosition, id) -> true);
    }

    @OnClick({R.id.image_back,R.id.image_right})
    public void ViewClick(View view){
        switch (view.getId()){
            case R.id.image_back:
                FinishActivity();
                break;
            case R.id.image_right:

                break;
        }
    }
}

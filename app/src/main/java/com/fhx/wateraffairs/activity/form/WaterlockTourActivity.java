package com.fhx.wateraffairs.activity.form;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
 * 附录A  水闸巡视检查记录表
 */
public class WaterlockTourActivity extends BaseActivity {
    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.image_right)
    ImageView imageRight;
    @BindView(R.id.expand_listview)
    ExpandableListView expandableListView;
    BaseExpandAdapter expandAdapter;

    List<BaseGroup> mGroupList;
    List<BaseGroup.Item> mItemList ;
    @Override
    protected int initLayout() {
        return R.layout.activity_water_lock_tour;
    }

    @Override
    protected void initView() {
        tvTitle.setText("水闸巡视检查记录表");
        imageRight.setImageResource(R.mipmap.icon_title_right_confirm);
    }

    @Override
    protected void initData() {
        mGroupList=new ArrayList<>();
        mItemList =new ArrayList<>();
        mItemList.add(new BaseGroup.Item("枢纽名称：","请输入"));
        mItemList.add(new BaseGroup.Item("工程名称：","请输入"));
        mItemList.add(new BaseGroup.Item(" 闸孔号：","请输入"));
        mGroupList.add(new BaseGroup("基础内容",mItemList));

        mItemList =new ArrayList<>();
        mItemList.add(new BaseGroup.Item("水流状态：","请输入"));
        mItemList.add(new BaseGroup.Item("漏水状况：","请输入"));
        mItemList.add(new BaseGroup.Item("闸墩：","请输入"));
        mItemList.add(new BaseGroup.Item("门墩：","请输入"));
        mItemList.add(new BaseGroup.Item("门槽：","请输入"));
        mItemList.add(new BaseGroup.Item("胸墙：","请输入"));
        mItemList.add(new BaseGroup.Item("牛腿：","请输入"));
        mItemList.add(new BaseGroup.Item("底板伸缩缝：","请输入"));
        mItemList.add(new BaseGroup.Item("通气孔：","请输入"));
        mItemList.add(new BaseGroup.Item("启闭机室：","请输入"));
        mItemList.add(new BaseGroup.Item("附属设施：","请输入"));
        mItemList.add(new BaseGroup.Item("防冻设施：","请输入"));
        mItemList.add(new BaseGroup.Item("电器设备：","请输入"));
        mItemList.add(new BaseGroup.Item("自备电源：","请输入"));
        mGroupList.add(new BaseGroup("检查内容",mItemList));

        expandAdapter =new BaseExpandAdapter(mGroupList,this);
        expandableListView.setAdapter(expandAdapter);
        for(int i = 0; i < expandAdapter.getGroupCount(); i++){
            expandableListView.expandGroup(i);
        }
    }

    @Override
    protected void initListen() {
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });

    }

    @OnClick({R.id.image_back,R.id.image_right})
    public  void  ViewClick(View view){
        switch (view.getId()){
            case R.id.image_back:
                FinishActivity();
                break;
            case R.id.image_right:
                Log.e("fhxxx",mGroupList.toString());
                Log.e("fhxxx",mGroupList.get(0).getItemList().toString());
                break;
        }
    }
}

package com.fhx.wateraffairs.activity.form;

import android.util.Log;
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
import butterknife.OnClick;

/**
 * 水库工程检查记录表
 */
public class ReservoirRecordActivity extends BaseActivity {
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
        tvTitle.setText("水库工程检查记录表");
        imageRight.setImageResource(R.mipmap.icon_title_right_confirm);
    }

    @Override
    protected void initData() {
        mGroupList=new ArrayList<>();
        mItemList =new ArrayList<>();
        mItemList.add(new BaseGroup.Item("渠道名称：","请输入"));
        mItemList.add(new BaseGroup.Item("检查日期：","请输入"));
        mItemList.add(new BaseGroup.Item("上次检查日期：","请输入"));
        mItemList.add(new BaseGroup.Item("检查类别：","填专项或巡视"));
        mGroupList.add(new BaseGroup("基础内容",mItemList));

        mItemList =new ArrayList<>();
        mItemList.add(new BaseGroup.Item("上游坝坡问题：","请输入"));
        mItemList.add(new BaseGroup.Item(" — 处理意见：","请输入"));
        mItemList.add(new BaseGroup.Item("下游坝坡问题：","请输入"));
        mItemList.add(new BaseGroup.Item(" — 处理意见：","请输入"));
        mItemList.add(new BaseGroup.Item("坝顶问题：","请输入"));
        mItemList.add(new BaseGroup.Item(" — 处理意见：","请输入"));
        mItemList.add(new BaseGroup.Item("防浪墙问题：","请输入"));
        mItemList.add(new BaseGroup.Item(" — 处理意见：","请输入"));
        mItemList.add(new BaseGroup.Item("坝脚问题：","请输入"));
        mItemList.add(new BaseGroup.Item(" — 处理意见：","请输入"));
        mGroupList.add(new BaseGroup("坝身",mItemList));


        mItemList =new ArrayList<>();
        mItemList.add(new BaseGroup.Item("上游坝坡排水沟：","请输入"));
        mItemList.add(new BaseGroup.Item(" — 处理意见：","请输入"));
        mItemList.add(new BaseGroup.Item("下游坝坡排水沟：","请输入"));
        mItemList.add(new BaseGroup.Item(" — 处理意见：","请输入"));
        mItemList.add(new BaseGroup.Item("堤顶排水沟：","请输入"));
        mItemList.add(new BaseGroup.Item(" — 处理意见：","请输入"));
        mGroupList.add(new BaseGroup("排水系统",mItemList));

        mItemList =new ArrayList<>();
        mItemList.add(new BaseGroup.Item("闸门问题：","请输入"));
        mItemList.add(new BaseGroup.Item(" — 处理意见：","请输入"));
        mItemList.add(new BaseGroup.Item("启闭机问题：","请输入"));
        mItemList.add(new BaseGroup.Item(" — 处理意见：","请输入"));
        mItemList.add(new BaseGroup.Item("辅助设备问题：","请输入"));
        mItemList.add(new BaseGroup.Item(" — 处理意见：","请输入"));
        mGroupList.add(new BaseGroup("启闭设备",mItemList));

        mItemList =new ArrayList<>();
        mItemList.add(new BaseGroup.Item("上游坝坡问题：","请输入"));
        mItemList.add(new BaseGroup.Item(" — 处理意见：","请输入"));
        mItemList.add(new BaseGroup.Item("下游坝坡问题：","请输入"));
        mItemList.add(new BaseGroup.Item(" — 处理意见：","请输入"));
        mItemList.add(new BaseGroup.Item("闸室问题：","请输入"));
        mItemList.add(new BaseGroup.Item(" — 处理意见：","请输入"));
        mGroupList.add(new BaseGroup("溢洪道",mItemList));

        mItemList =new ArrayList<>();
        mItemList.add(new BaseGroup.Item("市电问题：","请输入"));
        mItemList.add(new BaseGroup.Item(" — 处理意见：","请输入"));
        mItemList.add(new BaseGroup.Item("发电机组问题：","请输入"));
        mItemList.add(new BaseGroup.Item(" — 处理意见：","请输入"));
        mItemList.add(new BaseGroup.Item("供电线路问题：","请输入"));
        mItemList.add(new BaseGroup.Item(" — 处理意见：","请输入"));
        mGroupList.add(new BaseGroup("电力系统",mItemList));

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

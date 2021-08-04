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
 * 商丘市引黄灌区市直管水工程
 * 书面正式调度指令纪录表
 */
public class DispatchRecordActivity extends BaseActivity {
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
        tvTitle.setText("调度指令纪录表");
        imageRight.setImageResource(R.mipmap.icon_title_right_confirm);
    }

    @Override
    protected void initData() {
        mGroupList=new ArrayList<>();
        mItemList =new ArrayList<>();
        mItemList.add(new BaseGroup.Item("年份：","请输入"));
        mItemList.add(new BaseGroup.Item("日期：","请输入"));
        mItemList.add(new BaseGroup.Item("时间：","请输入"));
        mItemList.add(new BaseGroup.Item("水库名称：","请输入"));
        mItemList.add(new BaseGroup.Item("水闸名称：","请输入"));
        mItemList.add(new BaseGroup.Item("流量：","请输入"));
        mItemList.add(new BaseGroup.Item("发令人：","请输入"));
        mItemList.add(new BaseGroup.Item("接令人：","请输入"));
        mItemList.add(new BaseGroup.Item("备注：","请输入"));
        mGroupList.add(new BaseGroup("基础内容",mItemList));

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

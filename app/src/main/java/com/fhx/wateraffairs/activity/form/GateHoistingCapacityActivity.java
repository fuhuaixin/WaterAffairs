package com.fhx.wateraffairs.activity.form;

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
 * 闸门启闭力检测记录表
 */
public class GateHoistingCapacityActivity extends BaseActivity {
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
    List<BaseGroup.Item> mItemList;

    @Override
    protected int initLayout() {
        return R.layout.activity_water_lock_check;
    }

    @Override
    protected void initView() {
        tvTitle.setText("闸门启闭力检测记录表");
        imageRight.setImageResource(R.mipmap.icon_title_right_confirm);
    }

    @Override
    protected void initData() {

        mGroupList = new ArrayList<>();
        mItemList = new ArrayList<>();

        mItemList.add(new BaseGroup.Item("枢纽名称：", "请输入"));
        mItemList.add(new BaseGroup.Item("工程名称：", "请输入"));
        mItemList.add(new BaseGroup.Item(" 闸孔号：", "请输入"));
        mGroupList.add(new BaseGroup("基础内容", mItemList));

        mItemList = new ArrayList<>();
        mItemList.add(new BaseGroup.Item("1 实际水头（m）：", "请输入"));
        mItemList.add(new BaseGroup.Item("1 设计水头（m）：", "请输入"));
        mItemList.add(new BaseGroup.Item("2 实际水头（m）：", "请输入"));
        mItemList.add(new BaseGroup.Item("2 设计水头（m）：", "请输入"));
        mItemList.add(new BaseGroup.Item("3 实际水头（m）：", "请输入"));
        mItemList.add(new BaseGroup.Item("3 设计水头（m）：", "请输入"));
        mGroupList.add(new BaseGroup("最大启门力（kN）", mItemList));

        mItemList = new ArrayList<>();
        mItemList.add(new BaseGroup.Item("1 实际水头（m）：", "请输入"));
        mItemList.add(new BaseGroup.Item("1 设计水头（m）：", "请输入"));
        mItemList.add(new BaseGroup.Item("2 实际水头（m）：", "请输入"));
        mItemList.add(new BaseGroup.Item("2 设计水头（m）：", "请输入"));
        mItemList.add(new BaseGroup.Item("3 实际水头（m）：", "请输入"));
        mItemList.add(new BaseGroup.Item("3 设计水头（m）：", "请输入"));
        mGroupList.add(new BaseGroup("最大闭门力（kN）", mItemList));

        mItemList = new ArrayList<>();
        mItemList.add(new BaseGroup.Item("1 实际水头（m）：", "请输入"));
        mItemList.add(new BaseGroup.Item("1 设计水头（m）：", "请输入"));
        mItemList.add(new BaseGroup.Item("2 实际水头（m）：", "请输入"));
        mItemList.add(new BaseGroup.Item("2 设计水头（m）：", "请输入"));
        mItemList.add(new BaseGroup.Item("3 实际水头（m）：", "请输入"));
        mItemList.add(new BaseGroup.Item("3 设计水头（m）：", "请输入"));
        mGroupList.add(new BaseGroup("最大持住力（kN）", mItemList));

        mItemList = new ArrayList<>();
        mItemList.add(new BaseGroup.Item("1 实际水头（m）：", "请输入"));
        mItemList.add(new BaseGroup.Item("1 设计水头（m）：", "请输入"));
        mItemList.add(new BaseGroup.Item("2 实际水头（m）：", "请输入"));
        mItemList.add(new BaseGroup.Item("2 设计水头（m）：", "请输入"));
        mItemList.add(new BaseGroup.Item("3 实际水头（m）：", "请输入"));
        mItemList.add(new BaseGroup.Item("3 设计水头（m）：", "请输入"));
        mGroupList.add(new BaseGroup("启闭力过程线", mItemList));

        expandAdapter = new BaseExpandAdapter(mGroupList, this);
        expandListview.setAdapter(expandAdapter);
        for (int i = 0; i < expandAdapter.getGroupCount(); i++) {
            expandListview.expandGroup(i);
        }
    }

    @Override
    protected void initListen() {
        expandListview.setOnGroupClickListener((parent, v, groupPosition, id) -> true);

    }

    @OnClick({R.id.image_back, R.id.image_right})
    public void ViewClick(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                FinishActivity();
                break;
            case R.id.image_right:

                break;
        }
    }
}

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
 * 启闭机考核记录表
 */
public class GateHoistRecordActivity extends BaseActivity {
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
        mItemList.add(new BaseGroup.Item("试验次数 1：", "请输入"));
        mItemList.add(new BaseGroup.Item("试验次数 2：", "请输入"));
        mItemList.add(new BaseGroup.Item("试验次数 3：", "请输入"));
        mItemList.add(new BaseGroup.Item("荷载 1：", "请输入"));
        mItemList.add(new BaseGroup.Item("荷载 2：", "请输入"));
        mItemList.add(new BaseGroup.Item("荷载 3：", "请输入"));
        mItemList.add(new BaseGroup.Item("历时 1：", "请输入"));
        mItemList.add(new BaseGroup.Item("历时 2：", "请输入"));
        mItemList.add(new BaseGroup.Item("历时 3：", "请输入"));
        mItemList.add(new BaseGroup.Item("加载位置 1：", "请输入"));
        mItemList.add(new BaseGroup.Item("加载位置 2：", "请输入"));
        mItemList.add(new BaseGroup.Item("加载位置 3：", "请输入"));
        mItemList.add(new BaseGroup.Item("检查情况 1：", "请输入"));
        mItemList.add(new BaseGroup.Item("检查情况 2：", "请输入"));
        mItemList.add(new BaseGroup.Item("检查情况 3：", "请输入"));
        mItemList.add(new BaseGroup.Item("结论：", "请输入"));
        mGroupList.add(new BaseGroup("静载试验", mItemList));

        mItemList = new ArrayList<>();
        mItemList.add(new BaseGroup.Item("试验次数 1：", "请输入"));
        mItemList.add(new BaseGroup.Item("试验次数 2：", "请输入"));
        mItemList.add(new BaseGroup.Item("试验次数 3：", "请输入"));
        mItemList.add(new BaseGroup.Item("荷载 1：", "请输入"));
        mItemList.add(new BaseGroup.Item("荷载 2：", "请输入"));
        mItemList.add(new BaseGroup.Item("荷载 3：", "请输入"));
        mItemList.add(new BaseGroup.Item("历时 1：", "请输入"));
        mItemList.add(new BaseGroup.Item("历时 2：", "请输入"));
        mItemList.add(new BaseGroup.Item("历时 3：", "请输入"));
        mItemList.add(new BaseGroup.Item("加载位置 1：", "请输入"));
        mItemList.add(new BaseGroup.Item("加载位置 2：", "请输入"));
        mItemList.add(new BaseGroup.Item("加载位置 3：", "请输入"));
        mItemList.add(new BaseGroup.Item("检查情况 1：", "请输入"));
        mItemList.add(new BaseGroup.Item("检查情况 2：", "请输入"));
        mItemList.add(new BaseGroup.Item("检查情况 3：", "请输入"));
        mItemList.add(new BaseGroup.Item("结论：", "请输入"));
        mGroupList.add(new BaseGroup("动载试验", mItemList));

        mItemList = new ArrayList<>();
        mItemList.add(new BaseGroup.Item("试验次数 1：", "请输入"));
        mItemList.add(new BaseGroup.Item("试验次数 2：", "请输入"));
        mItemList.add(new BaseGroup.Item("试验次数 3：", "请输入"));
        mItemList.add(new BaseGroup.Item("荷载 1：", "请输入"));
        mItemList.add(new BaseGroup.Item("荷载 2：", "请输入"));
        mItemList.add(new BaseGroup.Item("荷载 3：", "请输入"));
        mItemList.add(new BaseGroup.Item("历时 1：", "请输入"));
        mItemList.add(new BaseGroup.Item("历时 2：", "请输入"));
        mItemList.add(new BaseGroup.Item("历时 3：", "请输入"));
        mItemList.add(new BaseGroup.Item("加载位置 1：", "请输入"));
        mItemList.add(new BaseGroup.Item("加载位置 2：", "请输入"));
        mItemList.add(new BaseGroup.Item("加载位置 3：", "请输入"));
        mItemList.add(new BaseGroup.Item("检查情况 1：", "请输入"));
        mItemList.add(new BaseGroup.Item("检查情况 2：", "请输入"));
        mItemList.add(new BaseGroup.Item("检查情况 3：", "请输入"));
        mItemList.add(new BaseGroup.Item("结论：", "请输入"));
        mGroupList.add(new BaseGroup("稳定性试验", mItemList));

        mItemList = new ArrayList<>();
        mItemList.add(new BaseGroup.Item("试验次数 1：", "请输入"));
        mItemList.add(new BaseGroup.Item("试验次数 2：", "请输入"));
        mItemList.add(new BaseGroup.Item("试验次数 3：", "请输入"));
        mItemList.add(new BaseGroup.Item("荷载 1：", "请输入"));
        mItemList.add(new BaseGroup.Item("荷载 2：", "请输入"));
        mItemList.add(new BaseGroup.Item("荷载 3：", "请输入"));
        mItemList.add(new BaseGroup.Item("历时 1：", "请输入"));
        mItemList.add(new BaseGroup.Item("历时 2：", "请输入"));
        mItemList.add(new BaseGroup.Item("历时 3：", "请输入"));
        mItemList.add(new BaseGroup.Item("加载位置 1：", "请输入"));
        mItemList.add(new BaseGroup.Item("加载位置 2：", "请输入"));
        mItemList.add(new BaseGroup.Item("加载位置 3：", "请输入"));
        mItemList.add(new BaseGroup.Item("检查情况 1：", "请输入"));
        mItemList.add(new BaseGroup.Item("检查情况 2：", "请输入"));
        mItemList.add(new BaseGroup.Item("检查情况 3：", "请输入"));
        mItemList.add(new BaseGroup.Item("结论：", "请输入"));
        mGroupList.add(new BaseGroup("行走试验", mItemList));

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

package com.fhx.wateraffairs.activity.patrol;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.adapter.AnomalyRecordActAdapter;
import com.fhx.wateraffairs.base.BaseActivity;
import com.fhx.wateraffairs.bean.AnomalyRecordBean;
import com.fhx.wateraffairs.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 异常记录
 */
public class AnomalyRecordActivity extends BaseActivity {
    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.image_search)
    ImageView imageSearch;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.recycle_monitor)
    RecyclerView recycleMonitor;

    private AnomalyRecordActAdapter  adapter;
    private List<AnomalyRecordBean> mList =new ArrayList<>();
    @Override
    protected int initLayout() {
        return R.layout.activity_monitoring;
    }

    @Override
    protected void initView() {
        tvTitle.setText("异常记录");
        etSearch.setHint("搜索异常记录");
    }

    @Override
    protected void initData() {
        mList.add(new AnomalyRecordBean(0,"张庄桥某段阀门生锈","","张庄桥 | 2020-12-25"));
        mList.add(new AnomalyRecordBean(1,"某段水流量过大，注意紧急规避风险","","张庄桥 | 2020-12-20"));
        mList.add(new AnomalyRecordBean(1,"设备损坏，急需人工处理","","设备损坏，急需人工处理"));
        mList.add(new AnomalyRecordBean(2,"系统信息不准确","","系统信息不准确"));
        recycleMonitor.setLayoutManager(new LinearLayoutManager(this));
        adapter =new AnomalyRecordActAdapter(mList);
        recycleMonitor.setAdapter(adapter);
    }

    @Override
    protected void initListen() {
        etSearch.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                //关闭软键盘
                InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(etSearch.getWindowToken(),0);
                //do something
                //doSearch();
                ToastShort("点击了软键盘的搜索按钮---------》"+etSearch.getText().toString());
                return true;
            }
            return false;
        });

        adapter.setOnItemChildClickListener((adapter, view, position) -> {
                    CutToUtils.getInstance().JumpTo(AnomalyRecordActivity.this,AnomalyRecordMsgActivity.class);
                }
        );
    }


    @OnClick({R.id.image_back, R.id.image_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                FinishActivity();
                break;
            case R.id.image_search:
                break;
        }
    }
}

package com.fhx.wateraffairs.activity.home;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
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
import com.fhx.wateraffairs.adapter.MonitorListAdapter;
import com.fhx.wateraffairs.base.BaseActivity;
import com.fhx.wateraffairs.bean.MonitorListBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 监测点
 */
public class MonitoringActivity extends BaseActivity {


    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.recycle_monitor)
    RecyclerView recycleMonitor;

    private MonitorListAdapter listAdapter ;
    private List<MonitorListBean> monitorListBeanList =new ArrayList<>();
    private List<MonitorListBean.MonitorItemBean> itemBeanList =new ArrayList<>();
    @Override
    protected int initLayout() {
        return R.layout.activity_monitoring;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        tvTitle.setText("监测点");

        monitorListBeanList.add(new MonitorListBean(false,"庞各庄监测点",itemBeanList));
        monitorListBeanList.add(new MonitorListBean(false,"青龙欢监测点",itemBeanList));
        monitorListBeanList.add(new MonitorListBean(false,"犀牛湖监测点",itemBeanList));
        recycleMonitor.setLayoutManager(new LinearLayoutManager(this));
        listAdapter =new MonitorListAdapter(this,monitorListBeanList);
        recycleMonitor.setAdapter(listAdapter);

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

        listAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            for (int i = 0; i < monitorListBeanList.size(); i++) {
                if (i!=position){
                    monitorListBeanList.get(i).setOpen(false);
                }
            }
            if ( monitorListBeanList.get(position).isOpen()){
                monitorListBeanList.get(position).setOpen(false);
            }else {
                monitorListBeanList.get(position).setOpen(true);
            }
            itemBeanList.clear();
            for (int i = 0; i < 5; i++) {
                itemBeanList.add(new MonitorListBean.MonitorItemBean(position+monitorListBeanList.get(position).getTitle()+i));
            }

            listAdapter.notifyDataSetChanged();
        });
    }


    @OnClick({R.id.image_back, R.id.image_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                FinishActivity();
                break;
            case R.id.image_search:
                ToastShort("搜索");
                break;
        }
    }
}

package com.fhx.wateraffairs.activity.home;

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
import com.fhx.wateraffairs.adapter.ReportHistoryAdapter;
import com.fhx.wateraffairs.base.BaseActivity;
import com.fhx.wateraffairs.bean.ReportHistoryBean;
import com.fhx.wateraffairs.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 信息上班 提示
 */
public class ReportedHistoryActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.recycle_monitor)
    RecyclerView recycleMonitor;
    @BindView(R.id.image_search)
    ImageView imageSearch;
    private ReportHistoryAdapter reportHistoryAdapter;
    private List<ReportHistoryBean> mList =new ArrayList<>();
    private List<ReportHistoryBean.HistoryItemBean> itemBeanList =new ArrayList<>();

    @Override
    protected int initLayout() {
        return R.layout.activity_monitoring;
    }

    @Override
    protected void initView() {
        etSearch.setHint("搜索上报信息");
    }

    @Override
    protected void initData() {
        tvTitle.setText("上报记录");
        mList.add(new ReportHistoryBean(false,"2021-1-14",itemBeanList));
        mList.add(new ReportHistoryBean(false,"2021-1-15",itemBeanList));
        mList.add(new ReportHistoryBean(false,"2021-1-16",itemBeanList));
        recycleMonitor.setLayoutManager(new LinearLayoutManager(this));
        reportHistoryAdapter =new ReportHistoryAdapter(this,mList);
        recycleMonitor.setAdapter(reportHistoryAdapter);
    }

    @Override
    protected void initListen() {

        reportHistoryAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            for (int i = 0; i < mList.size(); i++) {
                if (i!=position){
                    mList.get(i).setOpen(false);
                }
            }
            if ( mList.get(position).isOpen()){
                mList.get(position).setOpen(false);
            }else {
                mList.get(position).setOpen(true);
            }
            itemBeanList.clear();
            for (int i = 0; i < 5; i++) {
                itemBeanList.add(new ReportHistoryBean.HistoryItemBean(position+mList.get(position).getTitle()+i));
            }

            reportHistoryAdapter.notifyDataSetChanged();
        });


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
    }


    @OnClick({R.id.image_search,R.id.image_back})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.image_back:
                FinishActivity();
                break;
            case R.id.image_search:
                CutToUtils.getInstance().JumpTo(ReportedHistoryActivity.this,ReportedHistoryMsgActivity.class);
                break;
        }
    }
}

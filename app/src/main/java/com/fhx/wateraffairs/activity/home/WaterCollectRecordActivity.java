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
import com.fhx.wateraffairs.adapter.WaterRecordAdapter;
import com.fhx.wateraffairs.base.BaseActivity;
import com.fhx.wateraffairs.bean.WaterRecordListBean;
import com.fhx.wateraffairs.dialog.CommonDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 取水记录
 */
public class WaterCollectRecordActivity extends BaseActivity {

    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.recycle_record)
    RecyclerView recycleRecord;

    private WaterRecordAdapter recordAdapter;
    private List<WaterRecordListBean> mList =new ArrayList<>();
    private List<WaterRecordListBean.RecordItemBean> mItemList =new ArrayList<>();

    @Override
    protected int initLayout() {
        return R.layout.activity_water_collect_record;
    }

    @Override
    protected void initView() {
        tvTitle.setText("历史记录");
    }

    @Override
    protected void initData() {
        mList.add(new WaterRecordListBean(false,"2020年1月13日",mItemList));
        mList.add(new WaterRecordListBean(false,"2020年1月14日",mItemList));
        mList.add(new WaterRecordListBean(false,"2020年1月15日",mItemList));
        recycleRecord.setLayoutManager(new LinearLayoutManager(this));
        recordAdapter =new WaterRecordAdapter(this,mList);
        recycleRecord.setAdapter(recordAdapter);

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
                ToastShort("点击了软键盘的搜索按钮");
                return true;
            }
            return false;
        });

        recordAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
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
                mItemList.clear();
                for (int i = 0; i < 3; i++) {
                    mItemList.add(new WaterRecordListBean.RecordItemBean(mList.get(position).getTitle()+i));
                }

                recordAdapter.notifyDataSetChanged();
            }
        });
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

    public void Try(int position,int itemPosition){
        CommonDialog commonDialog = new CommonDialog(this);
        commonDialog.setSingle(false);
        commonDialog.setImageResId(R.mipmap.icon_tip_warn);
//        commonDialog.setTitle("系统提示");
        commonDialog.setMessage("确认删除?");
        commonDialog.setOnClickBottomListener(new CommonDialog.OnClickBottomListener() {
            @Override
            public void onPositiveClick() {
                ToastShort("确认");
                mItemList.remove(itemPosition);
                recordAdapter.notifyDataSetChanged();
                commonDialog.dismiss();
            }

            @Override
            public void onNegtiveClick() {
                ToastShort("取消");
                commonDialog.dismiss();
            }
        });
        commonDialog.show();
    }
}

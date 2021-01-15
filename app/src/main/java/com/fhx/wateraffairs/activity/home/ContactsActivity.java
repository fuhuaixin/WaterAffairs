package com.fhx.wateraffairs.activity.home;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.fhx.wateraffairs.adapter.ContactsCollectAdapter;
import com.fhx.wateraffairs.adapter.ContactsTopAdapter;
import com.fhx.wateraffairs.base.BaseActivity;
import com.fhx.wateraffairs.bean.ContactsBean;
import com.fhx.wateraffairs.bean.ContactsCollectBean;
import com.fhx.wateraffairs.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 通讯录
 */
public class ContactsActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_company_name)
    TextView tvCompanyName;
    @BindView(R.id.recycle_branch)
    RecyclerView recycleBranch;
    @BindView(R.id.recycle_collect)
    RecyclerView recycleCollect;
    @BindView(R.id.image_search)
    ImageView imageSearch;
    @BindView(R.id.et_search)
    EditText etSearch;

    private ContactsTopAdapter topAdapter;
    private List<ContactsBean> mList = new ArrayList<>();
    private List<ContactsBean.ContactsMsgBean> mItemList = new ArrayList<>();

    private ContactsCollectAdapter collectAdapter;
    private List<ContactsCollectBean> collectList = new ArrayList<>();

    @Override
    protected int initLayout() {
        return R.layout.activity_contacts;
    }

    @Override
    protected void initView() {
        tvTitle.setText("通讯录");
        mItemList.add(new ContactsBean.ContactsMsgBean("张三", "河长", "15825802580"));
        mItemList.add(new ContactsBean.ContactsMsgBean("里斯", "副河长", "15811111111"));
        mItemList.add(new ContactsBean.ContactsMsgBean("王五", "副河长", "15822222222"));

        mList.add(new ContactsBean(false, "总干渠", "23", mItemList));
        mList.add(new ContactsBean(false, "东风支干渠", "11", mItemList));
        mList.add(new ContactsBean(false, "南风支干渠", "13", mItemList));
        mList.add(new ContactsBean(false, "北风支干渠", "20", mItemList));

        collectList.add(new ContactsCollectBean("张三", "河长", "15825802580"));
        collectList.add(new ContactsCollectBean("里斯", "2区河长", "15825802580"));
        collectList.add(new ContactsCollectBean("王五", "河长", "15825802580"));
    }

    @Override
    protected void initData() {
        recycleBranch.setLayoutManager(new LinearLayoutManager(this));
        topAdapter = new ContactsTopAdapter(this,mList);
        recycleBranch.setAdapter(topAdapter);

        recycleCollect.setLayoutManager(new LinearLayoutManager(this));
        collectAdapter = new ContactsCollectAdapter(collectList);
        recycleCollect.setAdapter(collectAdapter);
    }

    @Override
    protected void initListen() {
        etSearch.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                //关闭软键盘
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(etSearch.getWindowToken(), 0);
                //do something
                //doSearch();
                ToastShort("点击了软键盘的搜索按钮---------》" + etSearch.getText().toString());
                return true;
            }
            return false;
        });

        topAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            for (int i = 0; i < mList.size(); i++) {
                if (i != position) {
                    mList.get(i).setOpen(false);
                }
            }
            if (mList.get(position).isOpen()) {
                mList.get(position).setOpen(false);
            } else {
                mList.get(position).setOpen(true);
            }
            topAdapter.notifyDataSetChanged();
        });
        collectAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            switch (view.getId()){
                case R.id.ll_item:
                    CutToUtils.getInstance().JumpTo(ContactsActivity.this, ContactsMsgActivity.class);

                    break;
                case R.id.ll_call:
                    Intent myCallIntent = new Intent(Intent.ACTION_DIAL,
                            Uri.parse("tel:" + collectList.get(position).getPhone()));
                    startActivity(myCallIntent);
                    break;
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
}

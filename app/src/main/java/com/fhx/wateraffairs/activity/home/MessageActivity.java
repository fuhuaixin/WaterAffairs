package com.fhx.wateraffairs.activity.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.adapter.HomeMsgAdapter;
import com.fhx.wateraffairs.base.AppUrl;
import com.fhx.wateraffairs.base.BaseActivity;
import com.fhx.wateraffairs.bean.HomeMessageBean;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 消息通知
 */
public class MessageActivity extends BaseActivity {
    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.recycle_msg)
    RecyclerView recycleMsg;
    @BindView(R.id.refresh)
    SmartRefreshLayout refresh;

    private HomeMsgAdapter msgAdapter;
    private List<HomeMessageBean.DataBean.RecordsBean> messageBeanList = new ArrayList<>();

    int page = 1;

    @Override
    protected int initLayout() {
        return R.layout.activity_message;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        tvTitle.setText("系统通知");

        msgAdapter = new HomeMsgAdapter(messageBeanList);
        recycleMsg.setLayoutManager(new LinearLayoutManager(this));
        recycleMsg.setAdapter(msgAdapter);
        page = 1;
        getNoticeList(page);


    }

    @Override
    protected void initListen() {
        refresh.setOnLoadMoreListener(refreshLayout -> {
            page++;
            getNoticeList(page);
        });
        refresh.setOnRefreshListener(refreshLayout -> {
            messageBeanList.clear();
            page = 1;
            getNoticeList(page);
        });
    }


    @OnClick(R.id.image_back)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                FinishActivity();
                break;
        }
    }

    private void getNoticeList(int page) {
        EasyHttp.get(AppUrl.NoticeList)
                .headers("Authorization", mmkv.decodeString("token"))
                .params("pageNum", page + "")
                .params("pageSize", 10 + "")
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        refresh.finishRefresh();
                        refresh.finishLoadMore();
                    }

                    @Override
                    public void onSuccess(String s) {
                        refresh.finishRefresh();
                        refresh.finishLoadMore();
                        HomeMessageBean bean = JSON.parseObject(s, HomeMessageBean.class);
                        if (bean.isSuccess()) {
                            messageBeanList.addAll(bean.getData().getRecords());
                            msgAdapter.notifyDataSetChanged();
                        }
                    }
                });
    }


}

package com.fhx.wateraffairs.activity.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.adapter.HomeMsgAdapter;
import com.fhx.wateraffairs.base.BaseActivity;
import com.fhx.wateraffairs.bean.HomeMessageBean;

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

    private HomeMsgAdapter msgAdapter;
    private List<HomeMessageBean> messageBeanList = new ArrayList<>();

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
        messageBeanList.add(new HomeMessageBean(true, "您提交的信息已通过了我们的系统审核，正在联系相关人员维修处理！", "12-30 13:26"));
        messageBeanList.add(new HomeMessageBean(false, "很抱歉，你提交的资料审核失败，请联系工作人 员，重新提交审核！", "12-30 13:26"));
        messageBeanList.add(new HomeMessageBean(true, "您提交的信息已通过了我们的系统审核，正在联系相关人员维修处理！", "12-30 13:26"));
        messageBeanList.add(new HomeMessageBean(true, "您提交的信息已通过了我们的系统审核，正在联系相关人员维修处理！", "12-30 13:26"));
        messageBeanList.add(new HomeMessageBean(true, "您提交的信息已通过了我们的系统审核，正在联系相关人员维修处理！", "12-30 13:26"));
        messageBeanList.add(new HomeMessageBean(true, "您提交的信息已通过了我们的系统审核，正在联系相关人员维修处理！", "12-30 13:26"));
        msgAdapter = new HomeMsgAdapter(messageBeanList);
        recycleMsg.setLayoutManager(new LinearLayoutManager(this));
        recycleMsg.setAdapter(msgAdapter);

    }

    @Override
    protected void initListen() {

    }


    @OnClick(R.id.image_back)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                FinishActivity();
                break;
        }
    }
}

package com.fhx.wateraffairs.activity.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 通讯录人员详情
 */
public class ContactsMsgActivity extends BaseActivity {

    @BindView(R.id.image_left)
    ImageView imageLeft;

    @Override
    protected int initLayout() {
        return R.layout.activity_contacts_msg;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListen() {

    }

    @OnClick(R.id.image_left)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_left:
                FinishActivity();
                break;
        }
    }
}

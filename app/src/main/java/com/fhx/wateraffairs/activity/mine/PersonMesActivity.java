package com.fhx.wateraffairs.activity.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 个人信息
 */
public class PersonMesActivity extends BaseActivity {
    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected int initLayout() {
        return R.layout.activity_mine_person_msg;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        tvTitle.setText("个人信息");
    }

    @Override
    protected void initListen() {

    }


    @OnClick(R.id.image_back)
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.image_back:
                FinishActivity();
                break;
        }
    }
}

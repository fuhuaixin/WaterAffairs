package com.fhx.wateraffairs.activity.home;

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
 * 修改取水记录
 */
public class ChangeWaterRecordActivity extends BaseActivity {

    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_water_type)
    TextView tvWaterType;
    @BindView(R.id.tv_get_water_mode)
    TextView tvGetWaterMode;

    @Override
    protected int initLayout() {
        return R.layout.activity_change_water_record;
    }

    @Override
    protected void initView() {
        tvTitle.setText("信息修改");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListen() {

    }


    @OnClick({R.id.image_back, R.id.tv_water_type, R.id.tv_get_water_mode, R.id.tv_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                FinishActivity();
                break;
            case R.id.tv_water_type:
                break;
            case R.id.tv_get_water_mode:
                break;
            case R.id.tv_commit:
                ToastShort("修改");
                break;
        }
    }
}

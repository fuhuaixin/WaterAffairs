package com.fhx.wateraffairs.activity.form;

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
 * 水库降水量观测记录表
 */
public class ReservoirPrecipitationActivity extends BaseActivity {
    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.image_right)
    ImageView imageRight;

    @Override
    protected int initLayout() {
        return R.layout.activity_reservoir_percipitation;
    }

    @Override
    protected void initView() {
        tvTitle.setText("水库降水量观测记录表");
        imageRight.setImageResource(R.mipmap.icon_title_right_confirm);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListen() {

    }

    @OnClick({R.id.image_back,R.id.image_right})
    public void ViewClick(View view){
        switch (view.getId()){
            case R.id.image_back:
                FinishActivity();
                break;
            case R.id.image_right:

                break;
        }
    }

}

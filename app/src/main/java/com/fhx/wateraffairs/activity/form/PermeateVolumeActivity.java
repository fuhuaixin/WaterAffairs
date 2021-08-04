package com.fhx.wateraffairs.activity.form;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 渗透流量观测记录表（容积法）
 */
public class PermeateVolumeActivity extends BaseActivity {
    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.image_right)
    ImageView imageRight;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_csrj)
    TextView tvCsrj;
    @BindView(R.id.tv_cssj)
    TextView tvCssj;
    @BindView(R.id.tv_stll)
    TextView tvStll;
    @BindView(R.id.ll_qw)
    LinearLayout llQw;

    private String type;

    @Override
    protected int initLayout() {
        return R.layout.activity_permeate_volume;
    }

    @Override
    protected void initView() {
        type = getIntent().getStringExtra("jumpOne");
        if (type.equals("容积法")) {
            tvTitle.setText("渗透流量观测记录表（容积法）");
        } else if (type.equals("量水堰法")) {
            tvTitle.setText("渗透流量观测记录表（量水堰法）");
            tvAddress.setText("量水堰编号：");
            tvCsrj.setText("堰上水头（m）：");
            tvCssj.setText("渗透流量（l/s）：");
            tvStll.setText("渗水透明度：");
            llQw.setVisibility(View.GONE);
        }
        imageRight.setImageResource(R.mipmap.icon_title_right_confirm);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListen() {

    }

    @OnClick({R.id.image_back})
    public void ViewOnClick(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                FinishActivity();
                break;
        }
    }


}

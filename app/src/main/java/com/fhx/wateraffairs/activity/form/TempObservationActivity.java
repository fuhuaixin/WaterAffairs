package com.fhx.wateraffairs.activity.form;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 温度计观测记录表（气温）
 * 温度计观测记录表（库水温）
 */
public class TempObservationActivity extends BaseActivity {

    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.image_right)
    ImageView imageRight;
    private String type;

    @Override
    protected int initLayout() {
        return R.layout.activity_temp_observation;
    }

    @Override
    protected void initView() {
        type = getIntent().getStringExtra("jumpOne");
        if (type.equals("气温")) {
            tvTitle.setText("温度计观测记录表（气温）");
        } else if (type.equals("库水温")) {
            tvTitle.setText("温度计观测记录表（库水温）");
        }
        imageRight.setImageResource(R.mipmap.icon_title_right_confirm);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListen() {

    }

    @OnClick({R.id.image_back, R.id.image_right})
    public void ViewClick(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                FinishActivity();
                break;
            case R.id.image_right:

                break;

        }
    }

}
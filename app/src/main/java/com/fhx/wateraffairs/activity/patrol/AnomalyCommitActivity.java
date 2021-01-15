package com.fhx.wateraffairs.activity.patrol;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 异常上报提交
 */
public class AnomalyCommitActivity extends BaseActivity {
    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.image_right)
    ImageView imageRight;

    @Override
    protected int initLayout() {
        return R.layout.activity_anomaly_commit;
    }

    @Override
    protected void initView() {
        tvTitle.setText("异常上报");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListen() {

    }


    @OnClick({R.id.image_back, R.id.image_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                FinishActivity();
                break;
            case R.id.image_right:
                break;
        }
    }
}

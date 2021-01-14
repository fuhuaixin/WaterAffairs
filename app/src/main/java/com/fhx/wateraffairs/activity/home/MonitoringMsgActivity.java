package com.fhx.wateraffairs.activity.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ZoomControls;

import com.baidu.mapapi.map.MapView;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.base.BaseActivity;
import com.fhx.wateraffairs.utils.CutToUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 监测点实时数据
 */
public class MonitoringMsgActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.image_right)
    ImageView imageRight;
    @BindView(R.id.mapView)
    MapView mapView;
    @BindView(R.id.ll_base)
    LinearLayout llBase;
    @BindView(R.id.ll_monitor_actual)
    LinearLayout llMonitorActual;
    @BindView(R.id.image_base_down)
    ImageView imageBaseDown;
    @BindView(R.id.image_act_down)
    ImageView imageActDown;

    boolean ifBaseShow = false;
    boolean ifActShow = false;

    @Override
    protected int initLayout() {
        return R.layout.activity_monitor_msg;
    }

    @Override
    protected void initView() {

        // 隐藏logo
        View child = mapView.getChildAt(1);
        if (child != null && (child instanceof ImageView || child instanceof ZoomControls)) {
            child.setVisibility(View.INVISIBLE);
        }
        //地图上比例尺
        mapView.showScaleControl(false);
        // 隐藏缩放控件
        mapView.showZoomControls(false);

    }

    @Override
    protected void initData() {
        tvTitle.setText("实时数据");
        imageRight.setImageResource(R.mipmap.icon_monitor_history);

    }

    @Override
    protected void initListen() {

    }


    @OnClick({R.id.image_back, R.id.image_right, R.id.rl_base, R.id.rl_actual})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                FinishActivity();
                break;
            case R.id.image_right:
                CutToUtils.getInstance().JumpTo(this, MonitorHistoryActivity.class);
                break;
            case R.id.rl_base:
                if (ifBaseShow) {
                    ifBaseShow = false;
                    imageBaseDown.setImageResource(R.mipmap.icon_monitor_down);
                    llBase.setVisibility(View.GONE);
                } else {
                    ifBaseShow = true;
                    imageBaseDown.setImageResource(R.mipmap.icon_monitor_up);
                    llBase.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.rl_actual:
                if (ifActShow) {
                    ifActShow = false;
                    imageActDown.setImageResource(R.mipmap.icon_monitor_down);
                    llMonitorActual.setVisibility(View.GONE);
                } else {
                    ifActShow = true;
                    imageActDown.setImageResource(R.mipmap.icon_monitor_up);
                    llMonitorActual.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

}

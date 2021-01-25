package com.fhx.wateraffairs.activity.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ZoomControls;

import com.baidu.mapapi.map.TextureMapView;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.base.BaseActivity;
import com.fhx.wateraffairs.dialog.ListDialog;
import com.fhx.wateraffairs.utils.BaiduMapContainer;
import com.fhx.wateraffairs.utils.CutToUtils;
import com.fhx.wateraffairs.utils.MyScrollview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 水量采集
 */
public class WaterCollectActivity extends BaseActivity {
    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.image_right)
    ImageView imageRight;
    @BindView(R.id.mapView)
    TextureMapView mapView;
    @BindView(R.id.tv_water_type)
    TextView tvWaterType;
    @BindView(R.id.tv_get_water_mode)
    TextView tvGetWaterMode;
    @BindView(R.id.map_container)
    BaiduMapContainer mapContainer;
    @BindView(R.id.my_scrollView)
    MyScrollview myScrollView;

    private ListDialog listDialog;
    private List<String> titleList = new ArrayList<>();
    String title;

    @Override
    protected int initLayout() {
        return R.layout.activity_water_collect;
    }

    @Override
    protected void initView() {
        tvTitle.setText("水量采集");
        imageRight.setImageResource(R.mipmap.icon_monitor_history);
        mapContainer.setScrollView(myScrollView);

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
        listDialog = new ListDialog(this);

    }

    @Override
    protected void initListen() {
        listDialog.setListener((adapter, view, position) -> {
            switch (title) {
                case "水源类型":
                    tvWaterType.setText(titleList.get(position));
                    break;
                case "取水方式":
                    tvGetWaterMode.setText(titleList.get(position));
                    break;
            }
            listDialog.dismiss();
        });
    }


    @OnClick({R.id.image_back, R.id.image_right, R.id.tv_water_type, R.id.tv_get_water_mode, R.id.tv_commit})
    public void onViewClicked(View view) {
        titleList.clear();
        switch (view.getId()) {
            case R.id.image_back:
                FinishActivity();
                break;
            case R.id.image_right:
                CutToUtils.getInstance().JumpTo(this, WaterCollectRecordActivity.class);
                break;
            case R.id.tv_water_type:
                title = "水源类型";

                titleList.add("Ⅰ类");
                titleList.add("Ⅱ类");
                titleList.add("Ⅲ类");
                listDialog.setList(titleList);
                listDialog.setTitle(title);
                listDialog.show();
                break;
            case R.id.tv_get_water_mode:
                title = "取水方式";
                titleList.add("单独用水");
                titleList.add("混合取水");
                titleList.add("这样取水");
                titleList.add("那样取水");
                titleList.add("某某取水");
                listDialog.setList(titleList);
                listDialog.setTitle(title);
                listDialog.show();
                break;
            case R.id.tv_commit:
                ToastShort("提交数据");
                break;
        }
    }

}

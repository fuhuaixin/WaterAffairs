package com.fhx.wateraffairs.adapter;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ZoomControls;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.SectionEntity;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.bean.PatrolRecordSectionBean;

import java.util.List;

public class PatrolRecordAdapter extends BaseSectionQuickAdapter<PatrolRecordSectionBean, BaseViewHolder> {


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     * <p>
     * 参数一  子条目布局
     * 参数二  头部布局
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public PatrolRecordAdapter(List<PatrolRecordSectionBean> data) {
        super(R.layout.adapter_patrol_item, R.layout.adapter_patrol_item_header, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, PatrolRecordSectionBean item) {
        helper.setText(R.id.tv_month, item.header);
    }

    TextureMapView mapView;

    @Override
    protected void convert(BaseViewHolder helper, PatrolRecordSectionBean item) {
        helper.setText(R.id.tv_title, item.t.getTitle())
                .setText(R.id.tv_time, item.t.getData());
        mapView = helper.getView(R.id.mapView);
        hideMapView(mapView, item.t.getLatLngList());

    }

    private void hideMapView(TextureMapView mapView, List<LatLng> points) {
        // 隐藏logo
        View child = mapView.getChildAt(1);
        if (child != null && (child instanceof ImageView || child instanceof ZoomControls)) {
            child.setVisibility(View.INVISIBLE);
        }
        //地图上比例尺
        mapView.showScaleControl(false);
        // 隐藏缩放控件
        mapView.showZoomControls(false);

        BaiduMap map = mapView.getMap();
        UiSettings uiSettings = map.getUiSettings();
        uiSettings.setAllGesturesEnabled(false);

        //设置折线的属性
        OverlayOptions mOverlayOptions = new PolylineOptions()
                .width(5)
                .color(0xAA346CFF)
        //      .customTexture(m)//设置纹理图
                .points(points);
        //在地图上绘制折线
        //mPloyline 折线对象
        map.addOverlay(mOverlayOptions);

        int i  = points.size()/2;
        Log.e("fhxx",i+"===");
        MapStatusUpdate msu = MapStatusUpdateFactory.newLatLngZoom(points.get(i), 17);
//                MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(latLng);
        map.animateMapStatus(msu);
    }
}

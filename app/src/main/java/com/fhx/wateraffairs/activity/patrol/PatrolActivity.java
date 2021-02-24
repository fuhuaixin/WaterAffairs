package com.fhx.wateraffairs.activity.patrol;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ZoomControls;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.base.BaseActivity;
import com.fhx.wateraffairs.utils.CutToUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 巡检
 */
public class PatrolActivity extends BaseActivity {


    @BindView(R.id.mapView)
    MapView mapView;
    @BindView(R.id.image_back)
    ImageView imageBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.image_right)
    ImageView imageRight;
    @BindView(R.id.ll_title)
    LinearLayout llTitle;
    @BindView(R.id.ll_patrol_start)
    LinearLayout llPatrolStart;
    @BindView(R.id.ll_patrol_end)
    LinearLayout llPatrolEnd;
    @BindView(R.id.rl_anomaly)
    RelativeLayout rlAnomaly;

    private TranslateAnimation mShowAnim;
    private TranslateAnimation HiddenAmin;

    boolean ifShow = true;
    private BaiduMap mBaiduMap;
    private LocationClient mLocationClient;
    private boolean isFirstLocation = true;  //第一次定位
    double mLatitude, mLongitude;
    private GeoCoder geoCoder;
    private MapStatus mapStatus;//百度地图状态
    private boolean ifClose = false;
    //存储巡检位置列表
    private List<LatLng> mPatrolList = new ArrayList<>();
    BitmapDescriptor bitmap;//自定义折线

    @Override
    protected int initLayout() {
        return R.layout.activity_patrol;
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mapView.onPause();
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

        setAnimation();
        imageRight.setImageResource(R.mipmap.icon_anomaly_right);
    }

    @Override
    protected void initData() {
        tvTitle.setText("巡查");
        geoCoder = GeoCoder.newInstance();

        mBaiduMap = mapView.getMap();
        mBaiduMap.setMyLocationEnabled(true);
        bitmap = BitmapDescriptorFactory
                .fromResource(R.mipmap.icon_patrol_line);
        Location();

    }

    @Override
    protected void initListen() {
        mBaiduMap.setOnMapClickListener(listener);
        mBaiduMap.setOnMapStatusChangeListener(onMapStatusChangeListener);

        geoCoder.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() {
            @Override
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {

            }

            @Override
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                Log.e("fhxx", reverseGeoCodeResult.getAddress() + "--" + reverseGeoCodeResult.getSematicDescription());
            }
        });
    }

    private void Location() {
        //定位初始化
        mLocationClient = new LocationClient(this);

        //通过LocationClientOption设置LocationClient相关参数
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);

        //设置locationClientOption
        mLocationClient.setLocOption(option);

        //注册LocationListener监听器
        MyLocationListener myLocationListener = new MyLocationListener();
        mLocationClient.registerLocationListener(myLocationListener);
        //开启地图定位图层
        mLocationClient.start();

        //        new MyLocationConfiguration( MyLocationConfiguration.LocationMode.FOLLOWING,true,)

    }

    private void setAnimation() {
        //控件显示的动画
        mShowAnim = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF
                , -1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        mShowAnim.setDuration(500);

        //控件隐藏的动画
        HiddenAmin = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF
                , 0.0f, Animation.RELATIVE_TO_SELF, -1.0f);
        HiddenAmin.setDuration(500);
    }

    @OnClick({R.id.image_back, R.id.image_right, R.id.rl_anomaly,
            R.id.image_location, R.id.image_add_level, R.id.image_subtract_level,
            R.id.ll_patrol_start, R.id.ll_patrol_end})
    public void onViewClicked(View view) {
        mapStatus = mBaiduMap.getMapStatus();
        LatLng latLng = new LatLng(mLatitude, mLongitude);
        //构建Marker图标
        BitmapDescriptor bitmap;
        //构建MarkerOption，用于在地图上添加Marker
        OverlayOptions option;
        switch (view.getId()) {
            case R.id.image_back:
                FinishActivity();
                break;
            case R.id.image_right:
                CutToUtils.getInstance().JumpTo(PatrolActivity.this, PatrolRecordActivity.class);
                break;
            case R.id.rl_anomaly:
                Intent intent = new Intent(PatrolActivity.this, AnomalyCommitActivity.class);
                intent.putExtra("lat", mLatitude);
                intent.putExtra("lng", mLongitude);
                startActivity(intent);
                overridePendingTransition(R.anim.activity_in_from_anim, R.anim.activity_in_to_anim);
                break;
            case R.id.image_location:
                MapStatusUpdate msu = MapStatusUpdateFactory.newLatLngZoom(latLng, 19);
//                MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(latLng);
                mBaiduMap.animateMapStatus(msu);
                break;
            case R.id.image_add_level:
                mBaiduMap.setMapStatus(MapStatusUpdateFactory.zoomTo(mapStatus.zoom + 1));
                break;
            case R.id.image_subtract_level:
                mBaiduMap.setMapStatus(MapStatusUpdateFactory.zoomTo(mapStatus.zoom - 1));
                break;
            case R.id.ll_patrol_start:
                ifClose = true;
                llPatrolEnd.setVisibility(View.VISIBLE);
                llPatrolStart.setVisibility(View.GONE);
                bitmap = BitmapDescriptorFactory
                        .fromResource(R.mipmap.icon_patrol_map_start);

                option = new MarkerOptions()
                        .position(latLng)
                        .icon(bitmap);
                //在地图上添加Marker，并显示
                mBaiduMap.addOverlay(option);
                break;
            case R.id.ll_patrol_end:
                ifClose = false;
                llPatrolEnd.setVisibility(View.GONE);
                llPatrolStart.setVisibility(View.VISIBLE);
                bitmap = BitmapDescriptorFactory
                        .fromResource(R.mipmap.icon_patrol_map_end);
                //构建MarkerOption，用于在地图上添加Marker
                option = new MarkerOptions()
                        .position(latLng)
                        .icon(bitmap);
                //在地图上添加Marker，并显示
                mBaiduMap.addOverlay(option);
                break;
        }
    }

    BaiduMap.OnMapClickListener listener = new BaiduMap.OnMapClickListener() {
        /**
         * 地图单击事件回调函数
         *
         * @param point 点击的地理坐标
         */
        @Override
        public void onMapClick(LatLng point) {
            if (ifShow) {
                llTitle.startAnimation(HiddenAmin);
                llTitle.setVisibility(View.GONE);
//                rlAnomaly.set
                ifShow = false;
            } else {
                llTitle.startAnimation(mShowAnim);
                llTitle.setVisibility(View.VISIBLE);
                ifShow = true;
            }

            ToastShort(ifShow + "-----");
        }

        /**
         * 地图内 Poi 单击事件回调函数
         *
         * @param mapPoi 点击的 poi 信息
         */
        @Override
        public void onMapPoiClick(MapPoi mapPoi) {

        }
    };

    BaiduMap.OnMapStatusChangeListener onMapStatusChangeListener = new BaiduMap.OnMapStatusChangeListener() {


        @Override
        public void onMapStatusChangeStart(MapStatus mapStatus) {

        }

        @Override
        public void onMapStatusChangeStart(MapStatus mapStatus, int i) {
        }

        @Override
        public void onMapStatusChange(MapStatus mapStatus) {

        }

        @Override
        public void onMapStatusChangeFinish(MapStatus mapStatus) {
            Log.e("fhxx", mapStatus.target.toString() + "-----");
//            MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(mapStatus.target);
//            mBaiduMap.animateMapStatus(msu);
            geoCoder.reverseGeoCode(new ReverseGeoCodeOption().location(mapStatus.target).pageNum(0).pageSize(100));
        }
    };


    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //mapView 销毁后不在处理新接收的位置
            if (location == null || mapView == null) {
                return;
            }
            mLatitude = location.getLatitude();
            mLongitude = location.getLongitude();
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(location.getDirection()).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mBaiduMap.setMyLocationData(locData);

            if (isFirstLocation) {
                isFirstLocation = false;
                LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                MapStatusUpdate msu = MapStatusUpdateFactory.newLatLngZoom(latLng, 19);
//              MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(latLng);
                mBaiduMap.animateMapStatus(msu);
            }

            //开启时 进行地图绘制
            if (ifClose) {
                mPatrolList.add(new LatLng(mLatitude, mLongitude));
                //mPatrolList超过两条才能设置 否则会出现崩溃
                if (mPatrolList.size() > 2) {
                    OverlayOptions mOverlayOptions = new PolylineOptions()
                            .width(10)
                            .customTexture(bitmap)
                            .points(mPatrolList)
                            .dottedLine(true);
                    mBaiduMap.addOverlay(mOverlayOptions);
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mapView.onDestroy();
    }

}

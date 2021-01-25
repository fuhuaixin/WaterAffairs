package com.fhx.wateraffairs.activity.patrol;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ZoomControls;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.fhx.wateraffairs.R;
import com.fhx.wateraffairs.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 巡检定位
 */
public class PatrolLocationActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.mapView)
    TextureMapView mapView;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.image_location)
    ImageView imageLocation;
    @BindView(R.id.tv_address_details)
    TextView tvAddressDetails;
    @BindView(R.id.tv_location)
    TextView tvLocation;

    private BaiduMap mBaiduMap;
    private MapStatus mapStatus;//百度地图状态
    private LocationClient mLocationClient;
    private boolean isFirstLocation = true;  //第一次定位
    double mLatitude, mLongitude;
    private GeoCoder geoCoder;
    String intAddress;
    LatLng intLatLng;

    @Override
    protected int initLayout() {
        return R.layout.activity_patrol_location;
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
    }

    @Override
    protected void initData() {
        tvTitle.setText("定位");
        geoCoder = GeoCoder.newInstance();

        mBaiduMap = mapView.getMap();
        mBaiduMap.setMyLocationEnabled(true);
        Location();
    }

    @Override
    protected void initListen() {

        mBaiduMap.setOnMapStatusChangeListener(onMapStatusChangeListener);

        geoCoder.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() {
            @Override
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {

            }

            @Override
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                Log.e("fhxx", reverseGeoCodeResult.getAddress() + "--" + reverseGeoCodeResult.getSematicDescription());
                intAddress = reverseGeoCodeResult.getAddress();
                tvAddress.setText(reverseGeoCodeResult.getAddress());
                tvAddressDetails.setText(reverseGeoCodeResult.getSematicDescription());
            }
        });
    }


    @OnClick({R.id.image_back, R.id.tv_location, R.id.image_location, R.id.image_add_level, R.id.image_subtract_level})
    public void onViewClicked(View view) {
        mapStatus = mBaiduMap.getMapStatus();
//        ToastShort("level：" + mapStatus);
        switch (view.getId()) {
            case R.id.image_back:
                FinishActivity();
                break;
            case R.id.tv_location:
                Intent i = new Intent();
                i.putExtra("address", intAddress);
                setResult(666, i);
                finish();
                overridePendingTransition(R.anim.activity_out_from_animation, R.anim.activity_out_to_animation);
                break;
            case R.id.image_location:

                LatLng latLng = new LatLng(mLatitude, mLongitude);
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

        }
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
            intLatLng = mapStatus.target;
//            MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(mapStatus.target);
//            mBaiduMap.animateMapStatus(msu);
            geoCoder.reverseGeoCode(new ReverseGeoCodeOption().location(mapStatus.target).pageNum(0).pageSize(5));
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
//                MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(latLng);
                mBaiduMap.animateMapStatus(msu);
                geoCoder.reverseGeoCode(new ReverseGeoCodeOption().location(latLng).pageNum(0).pageSize(5));

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

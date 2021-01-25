package com.fhx.wateraffairs.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * 百度地图scrollview 嵌套百度地图包裹
 * 使用方法：
 * baiduMapContainer.setScrollView(scrollview);
 */
public class BaiduMapContainer extends LinearLayout {
    private MyScrollview scrollView;
    public BaiduMapContainer(Context context) {
        super(context);
    }
    public BaiduMapContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public void setScrollView(MyScrollview scrollView) {
        this.scrollView = scrollView;
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_UP) {
            scrollView.requestDisallowInterceptTouchEvent(false);
        } else {
            scrollView.requestDisallowInterceptTouchEvent(true);
        }
        return false;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}
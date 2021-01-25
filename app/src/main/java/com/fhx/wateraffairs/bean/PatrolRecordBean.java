package com.fhx.wateraffairs.bean;

import com.baidu.mapapi.model.LatLng;

import java.util.List;

public class PatrolRecordBean {

    private String title;
    private String data;
    private List<LatLng> latLngList;

    public PatrolRecordBean(String title, String data, List<LatLng> latLngList) {
        this.title = title;
        this.data = data;
        this.latLngList = latLngList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<LatLng> getLatLngList() {
        return latLngList;
    }

    public void setLatLngList(List<LatLng> latLngList) {
        this.latLngList = latLngList;
    }


}

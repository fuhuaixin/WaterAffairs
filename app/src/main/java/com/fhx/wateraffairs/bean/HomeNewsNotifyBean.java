package com.fhx.wateraffairs.bean;

public class HomeNewsNotifyBean {
    private String title;
    private String msg;
    private String time;
    private int image;

    public HomeNewsNotifyBean(String title, String msg, String time, int image) {
        this.title = title;
        this.msg = msg;
        this.time = time;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

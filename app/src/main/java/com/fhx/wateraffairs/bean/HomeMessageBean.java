package com.fhx.wateraffairs.bean;

public class HomeMessageBean {
    private boolean isPass;
    private String title;
    private String time;

    public HomeMessageBean(boolean isPass, String title, String time) {
        this.isPass = isPass;
        this.title = title;
        this.time = time;
    }

    public boolean isPass() {
        return isPass;
    }

    public void setPass(boolean pass) {
        isPass = pass;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

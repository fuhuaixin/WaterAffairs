package com.fhx.wateraffairs.bean;

/**
 * yichang jilu
 */
public class AnomalyRecordBean {
    private int status;
    private String title;
    private String msg;
    private String time;

    public AnomalyRecordBean(int status, String title, String msg, String time) {
        this.status = status;
        this.title = title;
        this.msg = msg;
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
}

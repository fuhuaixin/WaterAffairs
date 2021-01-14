package com.fhx.wateraffairs.bean;

public class MineListBean {
    private String name;
    private int icon;
    private boolean ifShow;

    public MineListBean(String name, int icon, boolean ifShow) {
        this.name = name;
        this.icon = icon;
        this.ifShow = ifShow;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public boolean isIfShow() {
        return ifShow;
    }

    public void setIfShow(boolean ifShow) {
        this.ifShow = ifShow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

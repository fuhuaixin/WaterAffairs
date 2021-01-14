package com.fhx.wateraffairs.bean;

import java.util.List;

public class MonitorListBean  {
    private boolean isOpen;
    private String title;
    private List<MonitorItemBean> itemBeanList;


    public MonitorListBean(boolean isOpen, String title, List<MonitorItemBean> itemBeanList) {
        this.isOpen = isOpen;
        this.title = title;
        this.itemBeanList = itemBeanList;
    }

    public List<MonitorItemBean> getItemBeanList() {
        return itemBeanList;
    }

    public void setItemBeanList(List<MonitorItemBean> itemBeanList) {
        this.itemBeanList = itemBeanList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public static class MonitorItemBean{
        private String title;

        public MonitorItemBean(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}

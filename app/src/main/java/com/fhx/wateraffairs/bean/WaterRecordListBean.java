package com.fhx.wateraffairs.bean;

import java.util.List;

public class WaterRecordListBean {
    private boolean isOpen;
    private String title;
    private List<RecordItemBean> itemBeanList;


    public WaterRecordListBean(boolean isOpen, String title, List<RecordItemBean> itemBeanList) {
        this.isOpen = isOpen;
        this.title = title;
        this.itemBeanList = itemBeanList;
    }

    public List<RecordItemBean> getItemBeanList() {
        return itemBeanList;
    }

    public void setItemBeanList(List<RecordItemBean> itemBeanList) {
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

    public static class RecordItemBean{
        private String title;

        public RecordItemBean(String title) {
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

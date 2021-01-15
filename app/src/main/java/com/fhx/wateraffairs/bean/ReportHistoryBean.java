package com.fhx.wateraffairs.bean;

import java.util.List;

public class ReportHistoryBean {
    private boolean isOpen;
    private String title;
    private List<HistoryItemBean> itemBeanList;

    public ReportHistoryBean(boolean isOpen, String title, List<HistoryItemBean> itemBeanList) {
        this.isOpen = isOpen;
        this.title = title;
        this.itemBeanList = itemBeanList;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<HistoryItemBean> getItemBeanList() {
        return itemBeanList;
    }

    public void setItemBeanList(List<HistoryItemBean> itemBeanList) {
        this.itemBeanList = itemBeanList;
    }

    public static class HistoryItemBean {

        private String title;

        public HistoryItemBean(String title) {
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

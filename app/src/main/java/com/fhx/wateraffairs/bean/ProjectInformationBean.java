package com.fhx.wateraffairs.bean;

import java.util.List;

public class ProjectInformationBean {
    private boolean ifOpen;
    private String title;
    private List<ItemBean> itemList;

    public ProjectInformationBean(boolean ifOpen, String title, List<ItemBean> itemList) {
        this.ifOpen = ifOpen;
        this.title = title;
        this.itemList = itemList;
    }

    public boolean isIfOpen() {
        return ifOpen;
    }

    public void setIfOpen(boolean ifOpen) {
        this.ifOpen = ifOpen;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ItemBean> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemBean> itemList) {
        this.itemList = itemList;
    }

    public static class ItemBean{
        private String type;
        private String msg;

       public ItemBean(String type, String msg) {
           this.type = type;
           this.msg = msg;
       }

       public String getType() {
           return type;
       }

       public void setType(String type) {
           this.type = type;
       }

       public String getMsg() {
           return msg;
       }

       public void setMsg(String msg) {
           this.msg = msg;
       }
   }

}

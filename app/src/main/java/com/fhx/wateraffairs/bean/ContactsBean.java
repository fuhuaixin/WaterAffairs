package com.fhx.wateraffairs.bean;

import java.util.List;

public class ContactsBean {
    private boolean open;
    private String title;
    private String total;
    private List<ContactsMsgBean> itemList;

    public ContactsBean(boolean open, String title, String total, List<ContactsMsgBean> itemList) {
        this.open = open;
        this.title = title;
        this.total = total;
        this.itemList = itemList;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<ContactsMsgBean> getItemList() {
        return itemList;
    }

    public void setItemList(List<ContactsMsgBean> itemList) {
        this.itemList = itemList;
    }

    public static class ContactsMsgBean{
        private String name;
        private String job;
        private String phone;

        public ContactsMsgBean(String name, String job, String phone) {
            this.name = name;
            this.job = job;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}

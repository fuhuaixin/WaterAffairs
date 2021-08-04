package com.fhx.wateraffairs.bean;


import java.util.List;

public class BaseGroup {
    private String title;
    private List<Item> itemList;

    public BaseGroup(String title, List<Item> itemList) {
        this.title = title;
        this.itemList = itemList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public static class Item {
        private String text;
        private String eidt;
        private String editMsg;


        public Item(String text, String eidt) {
            this.text = text;
            this.eidt = eidt;
        }

        public String getEditMsg() {
            return editMsg;
        }

        public void setEditMsg(String editMsg) {
            this.editMsg = editMsg;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getEidt() {
            return eidt;
        }

        public void setEidt(String eidt) {
            this.eidt = eidt;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "text='" + text + '\'' +
                    ", eidt='" + eidt + '\'' +
                    ", editMsg='" + editMsg + '\'' +
                    '}';
        }
    }
}



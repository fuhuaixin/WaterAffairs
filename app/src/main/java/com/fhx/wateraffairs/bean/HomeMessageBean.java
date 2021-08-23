package com.fhx.wateraffairs.bean;

import java.util.List;

public class HomeMessageBean {

    /**
     * success : true
     * data : {"records":[{"newsId":"2","newsTitle":"会议通知","newsContent":"20210817日10时30分在商丘市水利局召开第一次巡检会议","postTime":"2021-08-17T10:07:56","createTime":"2021-08-17T10:07:59"},{"newsId":"1","newsTitle":"会议通知","newsContent":"20210817日10时30分在商丘市水利局召开第一次巡检会议","postTime":"2021-08-17T10:06:08","createTime":"2021-08-17T10:06:11"}],"total":2,"size":5,"current":1,"orders":[],"optimizeCountSql":true,"hitCount":false,"countId":null,"maxLimit":null,"searchCount":true,"pages":1}
     */

    private boolean success;
    private DataBean data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * records : [{"newsId":"2","newsTitle":"会议通知","newsContent":"20210817日10时30分在商丘市水利局召开第一次巡检会议","postTime":"2021-08-17T10:07:56","createTime":"2021-08-17T10:07:59"},{"newsId":"1","newsTitle":"会议通知","newsContent":"20210817日10时30分在商丘市水利局召开第一次巡检会议","postTime":"2021-08-17T10:06:08","createTime":"2021-08-17T10:06:11"}]
         * total : 2
         * size : 5
         * current : 1
         * orders : []
         * optimizeCountSql : true
         * hitCount : false
         * countId : null
         * maxLimit : null
         * searchCount : true
         * pages : 1
         */

        private int total;
        private int size;
        private int current;
        private boolean optimizeCountSql;
        private boolean hitCount;
        private Object countId;
        private Object maxLimit;
        private boolean searchCount;
        private int pages;
        private List<RecordsBean> records;
        private List<?> orders;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }

        public boolean isOptimizeCountSql() {
            return optimizeCountSql;
        }

        public void setOptimizeCountSql(boolean optimizeCountSql) {
            this.optimizeCountSql = optimizeCountSql;
        }

        public boolean isHitCount() {
            return hitCount;
        }

        public void setHitCount(boolean hitCount) {
            this.hitCount = hitCount;
        }

        public Object getCountId() {
            return countId;
        }

        public void setCountId(Object countId) {
            this.countId = countId;
        }

        public Object getMaxLimit() {
            return maxLimit;
        }

        public void setMaxLimit(Object maxLimit) {
            this.maxLimit = maxLimit;
        }

        public boolean isSearchCount() {
            return searchCount;
        }

        public void setSearchCount(boolean searchCount) {
            this.searchCount = searchCount;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public List<RecordsBean> getRecords() {
            return records;
        }

        public void setRecords(List<RecordsBean> records) {
            this.records = records;
        }

        public List<?> getOrders() {
            return orders;
        }

        public void setOrders(List<?> orders) {
            this.orders = orders;
        }

        public static class RecordsBean {
            /**
             * newsId : 2
             * newsTitle : 会议通知
             * newsContent : 20210817日10时30分在商丘市水利局召开第一次巡检会议
             * postTime : 2021-08-17T10:07:56
             * createTime : 2021-08-17T10:07:59
             */

            private String newsId;
            private String newsTitle;
            private String newsContent;
            private String postTime;
            private String createTime;

            public String getNewsId() {
                return newsId;
            }

            public void setNewsId(String newsId) {
                this.newsId = newsId;
            }

            public String getNewsTitle() {
                return newsTitle;
            }

            public void setNewsTitle(String newsTitle) {
                this.newsTitle = newsTitle;
            }

            public String getNewsContent() {
                return newsContent;
            }

            public void setNewsContent(String newsContent) {
                this.newsContent = newsContent;
            }

            public String getPostTime() {
                return postTime;
            }

            public void setPostTime(String postTime) {
                this.postTime = postTime;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }
        }
    }
}

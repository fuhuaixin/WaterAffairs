package com.fhx.wateraffairs.bean;

import java.util.List;

public class HomeNewsNotifyBean {

    /**
     * total : 5
     * rows : [{"warnId":"1","equipId":"0000000001","warnData":"小李庄水闸水位过高","createTime":"20210823113030","status":"1"},{"warnId":"2","equipId":"0000000001","warnData":"小李庄水闸水位过高","createTime":"20210823113030","status":"1"},{"warnId":"3","equipId":"0000000001","warnData":"小李庄水闸水位过高","createTime":"20210823113030","status":"1"},{"warnId":"4","equipId":"0000000001","warnData":"小李庄水闸水位过高","createTime":"20210823113030","status":"1"},{"warnId":"5","equipId":"0000000001","warnData":"小李庄水闸水位过高","createTime":"20210823113030","status":"1"}]
     * code : 200
     * msg : 查询成功
     */

    private int total;
    private int code;
    private String msg;
    private List<RowsBean> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * warnId : 1
         * equipId : 0000000001
         * warnData : 小李庄水闸水位过高
         * createTime : 20210823113030
         * status : 1
         */

        private String warnId;
        private String equipId;
        private String warnData;
        private String createTime;
        private String status;

        public String getWarnId() {
            return warnId;
        }

        public void setWarnId(String warnId) {
            this.warnId = warnId;
        }

        public String getEquipId() {
            return equipId;
        }

        public void setEquipId(String equipId) {
            this.equipId = equipId;
        }

        public String getWarnData() {
            return warnData;
        }

        public void setWarnData(String warnData) {
            this.warnData = warnData;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}

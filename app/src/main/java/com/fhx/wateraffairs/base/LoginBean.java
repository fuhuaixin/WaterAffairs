package com.fhx.wateraffairs.base;

import java.io.Serializable;
import java.util.List;

public class LoginBean implements Serializable {

    /**
     * success : true
     * data : {"roles":["SYS_ADMIN"],"user":{"userId":"admin","userName":"admin","nickName":"超级管理员","phone":"18686868866","email":"sdfs@werwe.com","sex":"0","avatar":"","deptId":"104","password":"$2a$10$6Uu48dgPDaYz5ZjAnGZKE.E27rEvujAoR5XnLnBFz5ts3dUELsaVm","userType":null,"isbaned":"0","isdeleted":"0","mark":null,"createBy":null,"createTime":"2021-03-04 11:01:50","updateBy":null,"updateTime":null,"loginIp":"123.456.789","loginDate":"2021-03-04 11:03:07","postIds":null,"roleIds":null,"duty":null,"status":null},"token":"eyJhbGciOiJIUzUxMiJ9.eyJsb2dpbl91c2VyX2tleSI6IjQ2ZDIyMDRmLTBkNjgtNDBmMi04ZDJlLWUyNGE3YmFjODMwOCJ9.nRh-fMhmU45FCx6i0datLQSpr7tVobMrHEyt4vwJUGOgL5F4Tax7q-WGupafZqmLyc0SefElNbEmoJmHjTXNpQ"}
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
         * roles : ["SYS_ADMIN"]
         * user : {"userId":"admin","userName":"admin","nickName":"超级管理员","phone":"18686868866","email":"sdfs@werwe.com","sex":"0","avatar":"","deptId":"104","password":"$2a$10$6Uu48dgPDaYz5ZjAnGZKE.E27rEvujAoR5XnLnBFz5ts3dUELsaVm","userType":null,"isbaned":"0","isdeleted":"0","mark":null,"createBy":null,"createTime":"2021-03-04 11:01:50","updateBy":null,"updateTime":null,"loginIp":"123.456.789","loginDate":"2021-03-04 11:03:07","postIds":null,"roleIds":null,"duty":null,"status":null}
         * token : eyJhbGciOiJIUzUxMiJ9.eyJsb2dpbl91c2VyX2tleSI6IjQ2ZDIyMDRmLTBkNjgtNDBmMi04ZDJlLWUyNGE3YmFjODMwOCJ9.nRh-fMhmU45FCx6i0datLQSpr7tVobMrHEyt4vwJUGOgL5F4Tax7q-WGupafZqmLyc0SefElNbEmoJmHjTXNpQ
         */

        private UserBean user;
        private String token;
        private List<String> roles;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public List<String> getRoles() {
            return roles;
        }

        public void setRoles(List<String> roles) {
            this.roles = roles;
        }

        public static class UserBean {
            /**
             * userId : admin
             * userName : admin
             * nickName : 超级管理员
             * phone : 18686868866
             * email : sdfs@werwe.com
             * sex : 0
             * avatar :
             * deptId : 104
             * password : $2a$10$6Uu48dgPDaYz5ZjAnGZKE.E27rEvujAoR5XnLnBFz5ts3dUELsaVm
             * userType : null
             * isbaned : 0
             * isdeleted : 0
             * mark : null
             * createBy : null
             * createTime : 2021-03-04 11:01:50
             * updateBy : null
             * updateTime : null
             * loginIp : 123.456.789
             * loginDate : 2021-03-04 11:03:07
             * postIds : null
             * roleIds : null
             * duty : null
             * status : null
             */

            private String userId;
            private String userName;
            private String nickName;
            private String phone;
            private String email;
            private String sex;
            private String avatar;
            private String deptId;
            private String password;
            private String userType;
            private String isbaned;
            private String isdeleted;
            private String mark;
            private String createBy;
            private String createTime;
            private String updateBy;
            private String updateTime;
            private String loginIp;
            private String loginDate;
            private String postIds;
            private String roleIds;
            private String duty;
            private String status;

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getDeptId() {
                return deptId;
            }

            public void setDeptId(String deptId) {
                this.deptId = deptId;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getUserType() {
                return userType;
            }

            public void setUserType(String userType) {
                this.userType = userType;
            }

            public String getIsbaned() {
                return isbaned;
            }

            public void setIsbaned(String isbaned) {
                this.isbaned = isbaned;
            }

            public String getIsdeleted() {
                return isdeleted;
            }

            public void setIsdeleted(String isdeleted) {
                this.isdeleted = isdeleted;
            }

            public String getMark() {
                return mark;
            }

            public void setMark(String mark) {
                this.mark = mark;
            }

            public String getCreateBy() {
                return createBy;
            }

            public void setCreateBy(String createBy) {
                this.createBy = createBy;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getUpdateBy() {
                return updateBy;
            }

            public void setUpdateBy(String updateBy) {
                this.updateBy = updateBy;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getLoginIp() {
                return loginIp;
            }

            public void setLoginIp(String loginIp) {
                this.loginIp = loginIp;
            }

            public String getLoginDate() {
                return loginDate;
            }

            public void setLoginDate(String loginDate) {
                this.loginDate = loginDate;
            }

            public String getPostIds() {
                return postIds;
            }

            public void setPostIds(String postIds) {
                this.postIds = postIds;
            }

            public String getRoleIds() {
                return roleIds;
            }

            public void setRoleIds(String roleIds) {
                this.roleIds = roleIds;
            }

            public String getDuty() {
                return duty;
            }

            public void setDuty(String duty) {
                this.duty = duty;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }
        }
    }
}

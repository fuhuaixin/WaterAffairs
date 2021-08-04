package com.fhx.wateraffairs.base;

public class AppUrl {
    public static final String BASEURL = "http://117.160.157.90:8055/"; //测试(测试环境)
//    public static final String BASEURL = "http://192.168.10.241:8083/"; //正式(测试环境)2

    //通知公告 资讯 baseUrl
    public static final String NEWSTITLEURL ="http://192.168.10.50:8055/smartbuilding_light/#/newsshow?id=";

    public static final String basePath = "zhjd/server/";
    //登录
    public static final String Login = basePath + "auth/login";

    //获取视频列表
    public static final String VideoVideos = basePath+"video/videos";
    //获取视频回放列表
    public static final String HistoryDatesDetial = basePath + "video/historyDatesDetial";
}

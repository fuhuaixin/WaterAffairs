package com.fhx.wateraffairs.base;

public class AppUrl {
    public static final String BASEURL = "http://123.54.5.82:8055/"; //测试(测试环境)
//    public static final String BASEURL = "http://192.168.10.241:8083/"; //正式(测试环境)2



    public static final String basePath =BASEURL+ "canal/";
    //登录
    public static final String Login = basePath + "login/check";

    //查询水利消息通知
    public static final String NoticeList = basePath + "sys/msgNotice/getNoticePageList";
    //查询预警信息
    public static final String WarnPageList = basePath + "sys/msgWaring/getWarnPageList";

    //获取视频列表
    public static final String VideoVideos = BASEURL+"video/videos";
    //获取视频回放列表
    public static final String HistoryDatesDetial = BASEURL + "video/historyDatesDetial";
}

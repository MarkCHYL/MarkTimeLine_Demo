package com.mark.marktimeline_demo;

/**
 * $desc$
 *
 * @Author mark 2285581945@qq.com
 * @Date 2018/7/17
 */
public class TimeLineBean {
    /** 时间 */
    private String acceptTime;
    /** 描述 */
    private String acceptStation;

    public TimeLineBean(String acceptTime, String acceptStation) {
        this.acceptTime = acceptTime;
        this.acceptStation = acceptStation;
    }

    public String getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getAcceptStation() {
        return acceptStation;
    }

    public void setAcceptStation(String acceptStation) {
        this.acceptStation = acceptStation;
    }

    @Override
    public String toString() {
        return "TimeLineBean{" +
                "acceptTime='" + acceptTime + '\'' +
                ", acceptStation='" + acceptStation + '\'' +
                '}';
    }
}

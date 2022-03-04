package com.heng.lostandfound.entity;

import java.sql.Timestamp;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/4/16:40
 * title：收藏表
 */
public class UserCollection {
    private String gName;  //物品名称
    private String uid;  //用户账号
    private Timestamp addTime;
    private Integer active;
    private String gUser;    //发启事的账号

    public UserCollection(String gName, String uid, Timestamp addTime, Integer active, String gUser) {
        this.gName = gName;
        this.uid = uid;
        this.addTime = addTime;
        this.active = active;
        this.gUser = gUser;
    }

    public UserCollection() {
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getgUser() {
        return gUser;
    }

    public void setgUser(String gUser) {
        this.gUser = gUser;
    }

    @Override
    public String toString() {
        return "collection{" +
                "gName='" + gName + '\'' +
                ", uid='" + uid + '\'' +
                ", addTime=" + addTime +
                ", active=" + active +
                ", gUser='" + gUser + '\'' +
                '}';
    }
}

package com.heng.lostandfound.entity;

import java.sql.Timestamp;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/4/16:36
 * title：评论表
 */
public class Comment {
    private String gName;
    private String uid;
    private String content;
    private Timestamp addTime;
    private Integer active;

    public Comment(String gName, String uid, String content, Timestamp addTime, Integer active) {
        this.gName = gName;
        this.uid = uid;
        this.content = content;
        this.addTime = addTime;
        this.active = active;
    }

    public Comment() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    @Override
    public String toString() {
        return "comment{" +
                "gName='" + gName + '\'' +
                ", uid='" + uid + '\'' +
                ", content='" + content + '\'' +
                ", addTime=" + addTime +
                ", active=" + active +
                '}';
    }
}

package com.heng.lostandfound.entity;

import java.sql.Timestamp;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/4/16:11
 * title：物品实体类
 */
public class Goods {
    private String gName;
    private String type;
    private Timestamp getTime;
    private Timestamp loseTime;
    private String content;
    private String gImage;

    public Goods() {
    }

    public Goods(String gName, String type, Timestamp getTime, Timestamp loseTime, String content, String gImage) {
        this.gName = gName;
        this.type = type;
        this.getTime = getTime;
        this.loseTime = loseTime;
        this.content = content;
        this.gImage = gImage;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getGetTime() {
        return getTime;
    }

    public void setGetTime(Timestamp getTime) {
        this.getTime = getTime;
    }

    public Timestamp getLoseTime() {
        return loseTime;
    }

    public void setLoseTime(Timestamp loseTime) {
        this.loseTime = loseTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getgImage() {
        return gImage;
    }

    public void setgImage(String gImage) {
        this.gImage = gImage;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gName='" + gName + '\'' +
                ", type='" + type + '\'' +
                ", getTime=" + getTime +
                ", loseTime=" + loseTime +
                ", content='" + content + '\'' +
                ", gImage='" + gImage + '\'' +
                '}';
    }
}

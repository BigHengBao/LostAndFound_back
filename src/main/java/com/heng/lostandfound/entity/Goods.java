package com.heng.lostandfound.entity;


/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/4/16:11
 * title：物品实体类
 */
public class Goods {
    private String gName;
    private String type;
    private String uAccount;
    private String getTime;
    private String loseTime;
    private String content;
    private String gImage;
    private String address;

    public Goods() {
    }

    public Goods(String gName, String type, String uAccount, String getTime, String loseTime, String content, String gImage, String address) {
        this.gName = gName;
        this.type = type;
        this.uAccount = uAccount;
        this.getTime = getTime;
        this.loseTime = loseTime;
        this.content = content;
        this.gImage = gImage;
        this.address = address;
    }

    public String getuAccount() {
        return uAccount;
    }

    public void setuAccount(String uAccount) {
        this.uAccount = uAccount;
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

    public String getGetTime() {
        return getTime;
    }

    public void setGetTime(String getTime) {
        this.getTime = getTime;
    }

    public String getLoseTime() {
        return loseTime;
    }

    public void setLoseTime(String loseTime) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gName='" + gName + '\'' +
                ", type='" + type + '\'' +
                ", uAccount='" + uAccount + '\'' +
                ", getTime=" + getTime +
                ", loseTime=" + loseTime +
                ", content='" + content + '\'' +
                ", gImage='" + gImage + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

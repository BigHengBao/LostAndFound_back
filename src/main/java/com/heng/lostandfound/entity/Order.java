package com.heng.lostandfound.entity;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/4/16:16
 * title：商品用户表
 */
public class Order {
    private String gName;
    private String uid;
    private Integer active;
    private Integer type;  //类型：0：寻物，1：招领

    public Order() {
    }

    public Order(String gName, String uid, Integer active, Integer type) {
        this.gName = gName;
        this.uid = uid;
        this.active = active;
        this.type = type;
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

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Order{" +
                "gName='" + gName + '\'' +
                ", uid='" + uid + '\'' +
                ", active=" + active +
                ", type=" + type +
                '}';
    }
}

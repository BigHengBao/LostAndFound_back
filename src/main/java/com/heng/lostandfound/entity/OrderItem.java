package com.heng.lostandfound.entity;

import java.io.File;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/10/15:13
 * title：用于封装order的中间类
 */
public class OrderItem {
    private String goodsName;
    private Integer orderType;
    private String authorName;
    private String goodsType;
    private String orderTime;
    private String goodsImage;

    public OrderItem(String goodsName, Integer orderType, String authorName, String goodsType, String orderTime, String goodsImage) {
        this.goodsName = goodsName;
        this.orderType = orderType;
        this.authorName = authorName;
        this.goodsType = goodsType;
        this.orderTime = orderTime;
        this.goodsImage = goodsImage;
    }

    public OrderItem() {
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "goodsName='" + goodsName + '\'' +
                ", orderType=" + orderType +
                ", authorName='" + authorName + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", orderTime=" + orderTime +
                '}';
    }
}

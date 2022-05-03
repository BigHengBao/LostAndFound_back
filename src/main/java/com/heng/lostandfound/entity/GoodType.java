package com.heng.lostandfound.entity;

import java.io.Serializable;
import java.util.stream.Stream;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/4/16:33
 * title：商品分类表
 */
public class GoodType implements Serializable {
    private String typeName;
    private Integer typeNum;
    private String typeImage;
    private Integer active;

    public GoodType(String typeName, Integer typeNum, String typeImage, Integer active) {
        this.typeName = typeName;
        this.typeNum = typeNum;
        this.typeImage = typeImage;
        this.active = active;
    }

    public GoodType() {
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getTypeNum() {
        return typeNum;
    }

    public void setTypeNum(Integer typeNum) {
        this.typeNum = typeNum;
    }

    public String getTypeImage() {
        return typeImage;
    }

    public void setTypeImage(String typeImage) {
        this.typeImage = typeImage;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "GoodType{" +
                "typeName='" + typeName + '\'' +
                ", typeNum=" + typeNum +
                ", active=" + active +
                '}';
    }
}

package com.heng.lostandfound.entity;

import java.io.File;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/10/18:51
 * title：用于封装GoodsType类
 */
public class GoodsTypeItem {
    private String itemName;
    private File ItemImg;
    private String userName;
    private String userAccount;

    public GoodsTypeItem(String itemName, File itemImg, String userName, String userAccount) {
        this.itemName = itemName;
        ItemImg = itemImg;
        this.userName = userName;
        this.userAccount = userAccount;
    }

    public GoodsTypeItem() {
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public File getItemImg() {
        return ItemImg;
    }

    public void setItemImg(File itemImg) {
        ItemImg = itemImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public String toString() {
        return "GoodsTypeItem{" +
                "itemName='" + itemName + '\'' +
                ", ItemImg=" + ItemImg +
                ", userName='" + userName + '\'' +
                ", userAccount='" + userAccount + '\'' +
                '}';
    }
}

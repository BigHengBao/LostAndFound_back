package com.heng.lostandfound.service;

import java.io.IOException;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/19/15:31
 * title：图片的service
 */

public interface ImageService {
    String saveUserImage(String imageStr, String userAccount, String imageUrl) throws IOException;

    String backUserImage(String userAccount) throws IOException;

    String saveGoodsImage(String imageStr,String imageName, String imageUrl) throws IOException;

    String backGoodsImage(String  imageName) throws IOException;
}

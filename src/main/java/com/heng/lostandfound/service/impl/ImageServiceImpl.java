package com.heng.lostandfound.service.impl;

import com.heng.lostandfound.service.ImageService;
import com.heng.lostandfound.utils.Constant;
import com.heng.lostandfound.utils.ImageTools;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.util.Base64;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/19/15:33
 * title：
 */
@Service(value = "imageService")
public class ImageServiceImpl implements ImageService {
    @Override
    public String saveUserImage(String imageStr, String userAccount, String imageUrl) throws IOException {
        return ImageTools.convertBase64ToImage(imageStr, imageUrl, userAccount);
    }

    @Override
    public String backUserImage(String userAccount) throws IOException {
        return ImageTools.convertImageToBase64Str(
                Constant.BASE_IMAGE_LOCATION + Constant.USER_IMAGE + "\\" + userAccount + ".jpg");
    }

    @Override
    public String saveGoodsImage(String imageStr, String imageName, String imageUrl) throws IOException {
        return ImageTools.convertBase64ToImage(imageStr, imageUrl, imageName);
    }

    @Override
    public String backGoodsImage(String imageName) throws IOException {
        return ImageTools.convertImageToBase64Str(
                Constant.BASE_IMAGE_LOCATION + Constant.GOODS_IMAGE + "\\" + imageName + ".jpg");
    }
}


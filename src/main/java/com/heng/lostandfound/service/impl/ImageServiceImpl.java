package com.heng.lostandfound.service.impl;

import com.heng.lostandfound.service.ImageService;
import com.heng.lostandfound.utils.Constant;
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
        return convertBase64ToImage(imageStr, imageUrl, userAccount);
    }

    @Override
    public String backUserImage(String userAccount) throws IOException {
        return convertImageToBase64Str(
                Constant.BASE_IMAGE_LOCATION + Constant.USER_IMAGE + "\\" + userAccount + ".jpg");
    }


    /**
     * 将str转化为.jpg图片存储在resources/*images文件夹下
     */
    public static String convertBase64ToImage(String imgStr, String imgFilePath, String imgName) throws IOException {
        String imagePath = "";

        // 对字节数组字符串进行Base64解码并生成图片
        // 图像数据为空
        if (imgStr == null) {
            return imagePath;
        }
        File file = new File(imgFilePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        BASE64Decoder decoder = new BASE64Decoder();
        OutputStream out = null;
        try {
            imgName += ".jpg";
            out = new FileOutputStream(Constant.BASE_IMAGE_LOCATION + imgFilePath + "/" + imgName);
            // Base64解码
            imgStr = imgStr.replace("data:image/jpg;base64,", "")
                    .replace("data:image/png;base64,", "")
                    .replace("data:image/bmp;base64,", "")
                    .replace("data:image/gif;base64,", "")
                    .replace("data:image/jpeg;base64,", "");
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            out.write(b);
            imagePath = imgFilePath + "\\" + imgName;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
            return imagePath;
        }
    }

    /**
     * 将存储在resources/*images文件夹下.jpg图片转化为str
     *
     * @param imgFilePathName
     * @return
     * @throws IOException
     */
    public String convertImageToBase64Str(String imgFilePathName) throws IOException {
        FileInputStream inputStream = null;
        String base64Str = "";
        if (imgFilePathName == null) {
            return base64Str;
        }
        try {
            Base64.Encoder encoder = Base64.getEncoder();
            inputStream = new FileInputStream(imgFilePathName);
            if (inputStream != null) {
                int available = inputStream.available();
                byte[] bytes = new byte[available];
                inputStream.read(bytes);

                base64Str = encoder.encodeToString(bytes);
//            System.out.println(base64Str);
                inputStream.close();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return base64Str;
    }
}


package com.heng.lostandfound.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.heng.lostandfound.entity.MyResponse;
import com.heng.lostandfound.utils.Constant;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.util.HashMap;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/19/11:04
 * title：测试前后端图片传输的controller
 */

@RestController
@RequestMapping({"app/testImage"})
public class TestImageController {
    @RequestMapping(value = "/operateImage", method = RequestMethod.POST)
    public String operateImage(@RequestBody String mHashMapStr) throws IOException {
        String myResponseStr = null;
//        System.out.println("operateCollection requestStr:" + mHashMapStr);
        HashMap mHashMap = JSON.parseObject(mHashMapStr, HashMap.class);
        String imageStr = (String) mHashMap.get("imageStr");
        String userAccount = (String) mHashMap.get("userAccount");
        boolean operateImageFrag = false;
        String msg = "";
        if (mHashMap.get("front").toString().equals(Constant.FRONT_ANDROID)) {
            String property = System.getProperty("user.dir");
            operateImageFrag = convertBase64ToImage(imageStr, property + "\\src\\main\\resources\\images", userAccount);

//            System.out.println("System.getProperty->>>>>>>>>>>>" + property + "\\src\\main\\resources\\images");


        } else if (mHashMap.get("front").toString().equals(Constant.FRONT_PC)) {
        }
        MyResponse myResponse = new MyResponse((String) mHashMap.get("requestId"), (String) mHashMap.get("front"),
                operateImageFrag, msg);
        myResponseStr = JSONObject.toJSONString(myResponse);
        System.out.println("operateCollection request" + myResponseStr);
        return myResponseStr;
    }

    public static boolean convertBase64ToImage(String imgData, String imgFilePath, String imgName) throws IOException {
        // 对字节数组字符串进行Base64解码并生成图片
        // 图像数据为空
        if (imgData == null) {
            return false;
        }
        File file = new File(imgFilePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        BASE64Decoder decoder = new BASE64Decoder();
        OutputStream out = null;
        try {
            imgName += ".jpg";
            out = new FileOutputStream(imgFilePath + "/" + imgName);
            // Base64解码
            imgData = imgData.replace("data:image/jpg;base64,", "")
                    .replace("data:image/png;base64,", "")
                    .replace("data:image/bmp;base64,", "")
                    .replace("data:image/gif;base64,", "")
                    .replace("data:image/jpeg;base64,", "");
            byte[] b = decoder.decodeBuffer(imgData);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            out.write(b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
            return true;
        }
    }

}

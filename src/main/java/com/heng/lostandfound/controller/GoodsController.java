package com.heng.lostandfound.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.heng.lostandfound.entity.GoodsInfoItem;
import com.heng.lostandfound.entity.MyResponse;
import com.heng.lostandfound.service.GoodsService;
import com.heng.lostandfound.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/13/13:15
 * title：物品相关的controller
 */

@RestController
@RequestMapping({"app/goods"})
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping(value = "/getGoodsInfo", method = RequestMethod.POST)
    public String getGoodsInfo(@RequestBody String mHashMapStr) throws IOException {
        System.out.println("getGoodsInfo requestStr:" + mHashMapStr);
        HashMap mHashMap = JSON.parseObject(mHashMapStr, HashMap.class);
        String myResponseStr = null;
        boolean getGoodsInfoFlag = false;
        String msg = "";

        if (mHashMap.get("front").toString().equals(Constant.FRONT_ANDROID)) {
            String goodsName = (String) mHashMap.get("goodsName");
            String authorName = (String) mHashMap.get("authorName");

            GoodsInfoItem goodsInfoItem = goodsService.getGoodsById(goodsName, authorName);
            System.out.println("getGoodsInfo goods:  " + goodsInfoItem);
            if (goodsInfoItem != null) {
                getGoodsInfoFlag = true;
                msg = JSON.toJSON(goodsInfoItem).toString();
            }

            MyResponse myResponse = new MyResponse((String) mHashMap.get("requestId"),
                    (String) mHashMap.get("front"), getGoodsInfoFlag, msg);
            myResponseStr = JSONObject.toJSONString(myResponse);
//            System.out.println("getGoodsInfo response :->>" + myResponseStr);
        } else if (mHashMap.get("front").toString().equals(Constant.FRONT_PC)) {

        }
        return myResponseStr;
    }
}

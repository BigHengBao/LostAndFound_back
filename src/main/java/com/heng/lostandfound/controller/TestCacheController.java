package com.heng.lostandfound.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.heng.lostandfound.entity.MyResponse;
import com.heng.lostandfound.entity.OrderItem;
import com.heng.lostandfound.service.TestCacheService;
import com.heng.lostandfound.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/5/3/12:48
 * title：
 */
@RestController
@RequestMapping({"app/cache"})
public class TestCacheController {
    @Autowired
    TestCacheService cacheService;

    @RequestMapping(value = "/getCacheOrderList", method = RequestMethod.POST)
    public String getCacheOrders(@RequestBody String mHashMapStr) throws IOException {
        HashMap mHashMap = JSON.parseObject(mHashMapStr, HashMap.class);
        String myResponseStr = "";
        boolean getCacheOrderListFlag = false;
        List<OrderItem> allOrder = null;
        String msg = "";

        if (mHashMap.get("front").toString().equals(Constant.FRONT_ANDROID)) {
            allOrder = cacheService.getCacheOrders();
            if (allOrder != null) {
                getCacheOrderListFlag = true;
                msg = JSON.toJSON(allOrder).toString();
//                System.out.println("getCacheOrders msg: " + msg);
                System.out.println("getCacheOrders:-->" + allOrder);
            }

        } else if (mHashMap.get("front").toString().equals(Constant.FRONT_PC)) {

        }
        MyResponse myResponse = new MyResponse((String) mHashMap.get("requestId"),
                (String) mHashMap.get("front"), getCacheOrderListFlag, msg);
        myResponseStr = JSONObject.toJSONString(myResponse);
//        System.out.println("getCacheOrders myResponseStr" + myResponseStr);

        return myResponseStr;
    }
}

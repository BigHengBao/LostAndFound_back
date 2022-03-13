package com.heng.lostandfound.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.heng.lostandfound.entity.*;
import com.heng.lostandfound.mapper.TypeMapper;
import com.heng.lostandfound.service.OrderService;
import com.heng.lostandfound.service.TypeService;
import com.heng.lostandfound.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/9/13:15
 * title：用户--物品表的controller
 */
@RestController
@RequestMapping({"app/order"})
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    TypeService typeService;

    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public String addOrder(@RequestBody String mHashMapStr) {
        System.out.println("addOrder requestStr:" + mHashMapStr);
        HashMap mHashMap = JSON.parseObject(mHashMapStr, HashMap.class);
        String myResponseStr = null;

        if (mHashMap.get("front").toString().equals(Constant.FRONT_ANDROID)) {
            Goods goods = JSON.parseObject(mHashMap.get("goods").toString(), Goods.class);
            System.out.println("addOrder goods: " + goods);

            Integer orderType = (Integer) mHashMap.get("orderType");
            boolean addOrderFlag = orderService.addOrder(goods, orderType);
            MyResponse myResponse = new MyResponse((String) mHashMap.get("requestId"), (String) mHashMap.get("front"), addOrderFlag, "");
            myResponseStr = JSONObject.toJSONString(myResponse);
            System.out.println("addOrderFlag request" + myResponseStr);
        } else if (mHashMap.get("front").toString().equals(Constant.FRONT_PC)) {

        }
        return myResponseStr;
    }

    @RequestMapping(value = "/updateOrder", method = RequestMethod.POST)
    public String updateOrder(@RequestBody String mHashMapStr) {
        System.out.println("addOrder requestStr:" + mHashMapStr);
        HashMap mHashMap = JSON.parseObject(mHashMapStr, HashMap.class);
        String myResponseStr = null;

        if (mHashMap.get("front").toString().equals(Constant.FRONT_ANDROID)) {
            String goodsName = (String) mHashMap.get("goodsName");
            String userAccount = (String) mHashMap.get("userAccount");
            Integer active = (Integer) mHashMap.get("active");
            boolean adjustOrderFlag = orderService.adjustOrderActive(userAccount, goodsName, active);
            MyResponse myResponse = new MyResponse((String) mHashMap.get("requestId"), (String) mHashMap.get("front"), adjustOrderFlag, "");
            myResponseStr = JSONObject.toJSONString(myResponse);
            System.out.println("updateOrder request" + myResponseStr);
        } else if (mHashMap.get("front").toString().equals(Constant.FRONT_PC)) {

        }
        return myResponseStr;
    }

    @RequestMapping(value = "/getOrderList", method = RequestMethod.POST)
    public String getOrderList(@RequestBody String mHashMapStr) {
        System.out.println("getOrderList requestStr:" + mHashMapStr);
        HashMap mHashMap = JSON.parseObject(mHashMapStr, HashMap.class);
        String myResponseStr = null;
        boolean getOrderListFlag = false;
        List<OrderItem> allOrder = null;
        String msg = "";

        if (mHashMap.get("front").toString().equals(Constant.FRONT_ANDROID)) {
            allOrder = orderService.getAllOrder();
            if (allOrder != null) {
                getOrderListFlag = true;
                msg = JSON.toJSON(allOrder).toString();
                System.out.println("getOrderList msg: " + msg);
            }

        } else if (mHashMap.get("front").toString().equals(Constant.FRONT_PC)) {

        }
        MyResponse myResponse = new MyResponse((String) mHashMap.get("requestId"),
                (String) mHashMap.get("front"), getOrderListFlag, msg);
        myResponseStr = JSONObject.toJSONString(myResponse);
        System.out.println("getOrderList request" + myResponseStr);
        return myResponseStr;
    }

    @RequestMapping(value = "/getAllGoodsType", method = RequestMethod.POST)
    public String getAllGoodsType(@RequestBody String mHashMapStr) {
        System.out.println("getAllGoodsType requestStr:" + mHashMapStr);
        HashMap mHashMap = JSON.parseObject(mHashMapStr, HashMap.class);
        String myResponseStr = null;
        boolean getGoodsTypeFlag = false;
        List<GoodsTypeItem> goodsTypeList = null;
        String msg = "";

        if (mHashMap.get("front").toString().equals(Constant.FRONT_ANDROID)) {
//            allOrder = orderService.getAllOrder();
            goodsTypeList = typeService.getAllTypes();
            if (goodsTypeList != null) {
                getGoodsTypeFlag = true;
                msg = JSON.toJSON(goodsTypeList).toString();
                System.out.println("getAllGoodsType msg: " + msg);
            }

        } else if (mHashMap.get("front").toString().equals(Constant.FRONT_PC)) {

        }
        MyResponse myResponse = new MyResponse((String) mHashMap.get("requestId"), (String) mHashMap.get("front"), getGoodsTypeFlag, msg);
        myResponseStr = JSONObject.toJSONString(myResponse);
        System.out.println("getAllGoodsType request" + myResponseStr);
        return myResponseStr;
    }
}

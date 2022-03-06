package com.heng.lostandfound.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.heng.lostandfound.entity.MyResponse;
import com.heng.lostandfound.entity.User;
import com.heng.lostandfound.service.UserService;
import com.heng.lostandfound.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/4/20:21
 * title：用户层controller
 */
@RestController
@RequestMapping({"app/user"})
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String resist(@RequestBody String mHashMapStr) {
        System.out.println("register requestStr:" + mHashMapStr);
        HashMap mHashMap = JSON.parseObject(mHashMapStr, HashMap.class);
        String myResponseStr = null;

        if (mHashMap.get("front").toString().equals(Constant.FRONT_ANDROID)) {
            User user = JSON.parseObject(mHashMap.get("user").toString(), User.class);
//            System.out.println("register user" +JSON.parseObject(mHashMap.get("user").toString(), User.class));
            boolean registerUserFlag = userService.registerUser(user);
            MyResponse myResponse = new MyResponse((String) mHashMap.get("requestId"), (String) mHashMap.get("front"), registerUserFlag, "");
            myResponseStr = JSONObject.toJSONString(myResponse);
            System.out.println("request" + myResponseStr);
        } else if (mHashMap.get("front").toString().equals(Constant.FRONT_PC)) {

        }
        return myResponseStr;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody String mHashMapStr) {
        System.out.println("login requestStr:" + mHashMapStr);
        HashMap mHashMap = JSON.parseObject(mHashMapStr, HashMap.class);
        String myResponseStr = null;
        if (mHashMap.get("front").toString().equals(Constant.FRONT_ANDROID)) {
            MyResponse myResponse = new MyResponse(mHashMap.get("requestId").toString(), Constant.FRONT_ANDROID, userService.loginUser(mHashMap), "");
            myResponseStr = JSONObject.toJSONString(myResponse);
        } else if (mHashMap.get("front").toString().equals(Constant.FRONT_PC)) {
        }
        System.out.println(myResponseStr);
        return myResponseStr;
    }

    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public String cancel(@RequestParam String uid) {
        System.out.println("requestStr:" + uid);
        MyResponse myResponse = new MyResponse("cancel", Constant.FRONT_ANDROID, userService.cancelUser(uid), "");
        System.out.println(myResponse);
        String myResponseStr = JSONObject.toJSONString(myResponse);
        System.out.println(myResponseStr);
        return myResponseStr;
    }
}

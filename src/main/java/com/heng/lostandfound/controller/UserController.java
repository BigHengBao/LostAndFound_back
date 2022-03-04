package com.heng.lostandfound.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.heng.lostandfound.entity.MyResponse;
import com.heng.lostandfound.entity.User;
import com.heng.lostandfound.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/4/20:21
 * title：
 */
@RestController
@RequestMapping({"app/user"})
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public JSON resist(JSON requestStr){
        User user = JSON.toJavaObject(requestStr, User.class);
       return (JSON) JSON.toJSON(new MyResponse("register",userService.registerUser(user)));
    }

    @RequestMapping(value = "/cancel",method = RequestMethod.POST)
    public String cancel(@RequestParam String uid){
        System.out.println("requestStr:" + uid);
        MyResponse myResponse = new MyResponse("cancel", userService.cancelUser(uid));
        System.out.println(myResponse);
        String s = JSONObject.toJSONString(myResponse);
        System.out.println(s);
        return s;
    }
}

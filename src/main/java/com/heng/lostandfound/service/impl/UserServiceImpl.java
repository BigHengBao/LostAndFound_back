package com.heng.lostandfound.service.impl;

import com.heng.lostandfound.entity.User;
import com.heng.lostandfound.mapper.UserMapper;
import com.heng.lostandfound.service.ImageService;
import com.heng.lostandfound.service.UserService;
import com.heng.lostandfound.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/4/19:49
 * title：user业务层
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    ImageService imageService;

    @Override
    public boolean registerUser(User user) throws IOException {
//        System.out.println("registerUser:-=----------------->" + user);
        if (userMapper.queryUserByUid(user.getuAccount()) == null) {  //判断用户是否已存在
            //把客户端发来的图片存到resources/image*
            String userImagePath = imageService.saveUserImage(user.getUserImage(), user.getuAccount(), Constant.USER_IMAGE);
            user.setUserImage(userImagePath);

//            System.out.println("registerUser saveUserImage---------------->" + userImagePath);

            user.setActive(Constant.ACTIVE_TRUE);
            userMapper.insertUser(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean cancelUser(String uid) {
        User user = userMapper.queryUserByUid(uid);
        if (user != null) {  //判断用户是否已存在
            user.setActive(Constant.ACTIVE_FALSE);
            userMapper.updateUser(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean loginUser(HashMap<String, String> mHashMap) {
        User user = userMapper.loginCheck(mHashMap.get("account"), mHashMap.get("password"));
        System.out.println("loginUser: " + user);
        if (user != null && user.getActive() == Constant.ACTIVE_TRUE) {
            return true;
        }
        return false;
    }

    @Override
    public User getUserInfo(String uAccount) throws IOException {
        User user = userMapper.queryUserByUid(uAccount);
        String backUserImage = imageService.backUserImage(uAccount);
        user.setUserImage(backUserImage);
//        System.out.println("getUserInfo------------------>" + user);
        return user;
    }
}

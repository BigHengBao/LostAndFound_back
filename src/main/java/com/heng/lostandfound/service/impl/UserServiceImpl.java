package com.heng.lostandfound.service.impl;

import com.heng.lostandfound.entity.User;
import com.heng.lostandfound.mapper.UserMapper;
import com.heng.lostandfound.service.UserService;
import com.heng.lostandfound.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/4/19:49
 * title：
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean registerUser(User user) {
        if (userMapper.queryByUid(user.getUid()) == null) {  //判断用户是否已存在
            user.setActive(Constant.ACTIVE_TRUE);
            userMapper.insertUser(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean cancelUser(String uid) {
        User user = userMapper.queryByUid(uid);
        if (user != null) {  //判断用户是否已存在
            user.setActive(Constant.ACTIVE_FALSE);
            userMapper.updateUser(user);
            return true;
        }
        return false;
    }
}

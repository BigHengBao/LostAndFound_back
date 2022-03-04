package com.heng.lostandfound.service;

import com.heng.lostandfound.entity.User;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/4/19:42
 * title：
 */

public interface UserService {
    boolean registerUser(User user);
    boolean cancelUser(String uid);
}

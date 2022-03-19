package com.heng.lostandfound.service;

import com.heng.lostandfound.entity.User;

import java.io.IOException;
import java.util.HashMap;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/4/19:42
 * title：用户service
 */

public interface UserService {
    boolean registerUser(User user) throws IOException;

    boolean cancelUser(String uid);

    boolean loginUser(HashMap<String, String> mHashMap);

    User getUserInfo(String uAccount) throws IOException;
}

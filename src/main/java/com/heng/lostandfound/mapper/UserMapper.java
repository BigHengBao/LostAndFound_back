package com.heng.lostandfound.mapper;

import com.heng.lostandfound.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/4/16:57
 * title：用户类dao
 */
@Component(value = "userMapper")
public interface UserMapper {
    void insertUser(User user);

    List<User> queryUsers();
    User queryUserByUid(String uAccount);

    User loginCheck(String uAccount,String uPwd);

    Integer updateUser(User user);
}

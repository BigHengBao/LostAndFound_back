package com.heng.lostandfound.service;

import com.heng.lostandfound.entity.OrderItem;
import com.heng.lostandfound.entity.UserCollection;

import java.util.List;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/17/10:29
 * title：收藏表service
 */

public interface CollectionService {
    boolean addCollection(UserCollection collection);

    boolean deleteCollection(UserCollection collection);

    List<OrderItem> getAllCollections(String uAccount);
}

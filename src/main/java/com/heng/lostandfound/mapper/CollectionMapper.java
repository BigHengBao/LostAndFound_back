package com.heng.lostandfound.mapper;

import com.heng.lostandfound.entity.UserCollection;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/17/10:16
 * title：收藏表dao
 */
@Component(value = "collectionMapper")
public interface CollectionMapper {
    void insertCollection(UserCollection collection);

    List<UserCollection> queryAllCollections(String uAccount);

    UserCollection queryCollectionById(String goodsName, String authorName, String uAccount);

    void updateCollection(UserCollection collection);
}

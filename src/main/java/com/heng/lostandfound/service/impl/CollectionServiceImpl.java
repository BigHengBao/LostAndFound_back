package com.heng.lostandfound.service.impl;

import com.heng.lostandfound.entity.UserCollection;
import com.heng.lostandfound.mapper.CollectionMapper;
import com.heng.lostandfound.service.CollectionService;
import com.heng.lostandfound.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/17/10:31
 * title：
 */
@Service(value = "collectionService")
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    CollectionMapper collectionMapper;

    @Override
    public boolean addCollection(UserCollection collection) {
        UserCollection userCollection = collectionMapper.queryCollectionById(collection.getgName(),
                collection.getgAuthorName(), collection.getuAccount());
        if (userCollection == null) {

            collectionMapper.insertCollection(collection);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<UserCollection> getAllCollections(String uAccount) {
        List<UserCollection> collections = collectionMapper.queryAllCollections(uAccount);
        if (collections != null) {
            return collections;
        }
        return null;
    }
}

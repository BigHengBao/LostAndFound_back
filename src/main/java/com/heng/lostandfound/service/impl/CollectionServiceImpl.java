package com.heng.lostandfound.service.impl;

import com.heng.lostandfound.entity.Goods;
import com.heng.lostandfound.entity.Order;
import com.heng.lostandfound.entity.OrderItem;
import com.heng.lostandfound.entity.UserCollection;
import com.heng.lostandfound.mapper.CollectionMapper;
import com.heng.lostandfound.mapper.GoodsMapper;
import com.heng.lostandfound.mapper.OrderMapper;
import com.heng.lostandfound.mapper.UserMapper;
import com.heng.lostandfound.service.CollectionService;
import com.heng.lostandfound.service.ImageService;
import com.heng.lostandfound.utils.Constant;
import com.heng.lostandfound.utils.ImageTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
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

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    ImageService imageService;

    @Override
    public boolean addCollection(UserCollection collection) {
        UserCollection userCollection = collectionMapper.queryCollectionById(collection.getgName(),
                collection.getgAuthorName(), collection.getuAccount(), collection.getAddTime());

        collection.setActive(Constant.COLLECTION_ACTIVE_TRUE);
        if (userCollection == null) { //如果null，新增一条收藏
            collectionMapper.insertCollection(collection);
        } else { //如果！null，设置active为true
            collectionMapper.updateCollection(collection);
        }
        return true;
    }

    @Override
    public boolean deleteCollection(UserCollection collection) {
        UserCollection userCollection = collectionMapper.queryCollectionById(collection.getgName(),
                collection.getgAuthorName(), collection.getuAccount(), collection.getAddTime());
        if (userCollection == null) {
            return false;
        } else {
            collectionMapper.updateCollection(collection);
            return true;
        }
    }

    @Override
    public List<OrderItem> getAllCollections(String uAccount) throws IOException {
        List<OrderItem> collectionItems = new ArrayList<>();
        List<UserCollection> collections = collectionMapper.queryAllCollections(uAccount);
//        System.out.println("getAllCollections------------->" + collections);
        if (collections != null) {
            for (UserCollection collection : collections) {
                OrderItem orderItem = new OrderItem();
                Order order = orderMapper.queryOrderById(
                        userMapper.queryUserByuName(collection.getgAuthorName()).getuAccount(), collection.getgName());

//                System.out.println("getAllCollections------------->" + order);

                Goods goods = goodsMapper.queryGoodsById(order.getgName(), order.getuAccount());


                //设置图片
                String imageTime = "";
                if (order.getType().equals(Constant.ORDER_TYPE_GET)) {
                    imageTime = goods.getGetTime();

                } else if (order.getType().equals(Constant.ORDER_TYPE_LOOKING)) {
                    imageTime = goods.getLoseTime();
                }

                System.out.println("getUserAllOrder imageTime" + imageTime);
                String backGoodsImage = imageService.backGoodsImage(
                        goods.getuAccount() + "_" + ImageTools.operateTimeStr(imageTime));

                orderItem.setGoodsName(order.getgName());
                orderItem.setAuthorName(userMapper.queryUserByUid(order.getuAccount()).getrName());
                orderItem.setOrderType(order.getType());
                orderItem.setGoodsType(goods.getType());
                orderItem.setGoodsImage(backGoodsImage);
                if (order.getType().equals(Constant.ORDER_TYPE_LOOKING)) {
                    orderItem.setOrderTime(goods.getLoseTime());
                } else {
                    orderItem.setOrderTime((goods.getGetTime()));
                }

                System.out.println("getAllCollections------------->" + orderItem);
                collectionItems.add(orderItem);
            }
            return collectionItems;
        }

        return null;
    }
}

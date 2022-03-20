package com.heng.lostandfound.service.impl;

import com.heng.lostandfound.entity.Goods;
import com.heng.lostandfound.entity.GoodsInfoItem;
import com.heng.lostandfound.entity.Order;
import com.heng.lostandfound.entity.User;
import com.heng.lostandfound.mapper.GoodsMapper;
import com.heng.lostandfound.mapper.OrderMapper;
import com.heng.lostandfound.mapper.UserMapper;
import com.heng.lostandfound.service.GoodsService;
import com.heng.lostandfound.service.ImageService;
import com.heng.lostandfound.utils.Constant;
import com.heng.lostandfound.utils.ImageTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/9/11:27
 * title：
 */
@Service(value = "goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    ImageService imageService;

    @Override
    public boolean addGoods(Goods goods) {
        if (goodsMapper.queryGoodsById(goods.getgName(), goods.getuAccount()) == null) {
            goodsMapper.insertGoods(goods);
            return true;
        }
        return false;
    }

    @Override
    public List<Goods> getAllGoods() {
        List<Goods> goods = goodsMapper.queryAllGoods();
        if (goods != null) {
            return goods;
        }
        return null;
    }

    @Override
    public GoodsInfoItem getGoodsById(String goodsName, String uName) throws IOException {
        GoodsInfoItem goodsInfoItem = new GoodsInfoItem();
        User user = userMapper.queryUserByuName(uName);
//        System.out.println("getGoodsById user:------------->" + user);
        String uAccount = user.getuAccount();
//        System.out.println("getGoodsById uAccount:------------->" + uAccount);

        Order order = orderMapper.queryOrderById(uAccount, goodsName);
//        System.out.println("getGoodsById order:------------->" + order);

        Goods goods = goodsMapper.queryGoodsById(goodsName, uAccount);

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
        goods.setgImage(backGoodsImage);

        goodsInfoItem.setAuthorName(uName);
        goodsInfoItem.setGoods(goods);
        goodsInfoItem.setOrder(order);
        return goodsInfoItem;
    }
}

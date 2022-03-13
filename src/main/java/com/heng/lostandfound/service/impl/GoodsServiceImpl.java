package com.heng.lostandfound.service.impl;

import com.heng.lostandfound.entity.Goods;
import com.heng.lostandfound.entity.GoodsInfoItem;
import com.heng.lostandfound.entity.Order;
import com.heng.lostandfound.entity.User;
import com.heng.lostandfound.mapper.GoodsMapper;
import com.heng.lostandfound.mapper.OrderMapper;
import com.heng.lostandfound.mapper.UserMapper;
import com.heng.lostandfound.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public GoodsInfoItem getGoodsById(String goodsName, String uName) {
        GoodsInfoItem goodsInfoItem = new GoodsInfoItem();
        User user = userMapper.queryUserByuName(uName);
        String uAccount = user.getuAccount();

        Order order = orderMapper.queryOrderById(uAccount, goodsName);

        Goods goods = goodsMapper.queryGoodsById(goodsName, uAccount);
        goods.setgImage(null);
        goodsInfoItem.setAuthorName(uName);
        goodsInfoItem.setGoods(goods);
        goodsInfoItem.setOrder(order);
        return goodsInfoItem;
    }
}

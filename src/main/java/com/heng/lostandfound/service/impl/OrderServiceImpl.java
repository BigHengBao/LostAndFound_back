package com.heng.lostandfound.service.impl;

import com.heng.lostandfound.entity.Goods;
import com.heng.lostandfound.entity.Order;
import com.heng.lostandfound.mapper.OrderMapper;
import com.heng.lostandfound.service.GoodsService;
import com.heng.lostandfound.service.OrderService;
import com.heng.lostandfound.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/9/11:31
 * title：
 */

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    GoodsService goodsService;

    @Override
    public boolean addOrder(Goods goods, Integer noticeType) {
        Order order = new Order(goods.getgName(), goods.getuAccount(), Constant.ORDER_ACTIVE_WAITING, noticeType);
        if (orderMapper.queryOrderById(goods.getuAccount(), goods.getgName()) == null) {
            orderMapper.insertOrder(order);
            goodsService.addGoods(goods);
            return true;
        }
        return false;
    }
}

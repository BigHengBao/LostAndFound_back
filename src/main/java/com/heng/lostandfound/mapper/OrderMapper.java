package com.heng.lostandfound.mapper;

import com.heng.lostandfound.entity.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/9/10:51
 * title：用户-物品dao
 */
@Component(value = "orderMapper")
public interface OrderMapper {
    void insertOrder(Order order);

    Integer updateOrder(String userAccount, String goodsName, Integer active);

    Order queryOrderById(String userAccount, String goodsName);


    List<Order> queryAllOrder();

    List<Order> queryUserOrdersByUAccount(String userAccount);
}

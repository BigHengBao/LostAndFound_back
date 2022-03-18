package com.heng.lostandfound.service;

import com.heng.lostandfound.entity.Goods;
import com.heng.lostandfound.entity.OrderItem;

import java.util.List;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/9/11:30
 * title：用户--物品service
 */

public interface OrderService {
    boolean addOrder(Goods goods,Integer noticeType);
    boolean adjustOrderActive(String userAccount,String goodsName,Integer active);
    List<OrderItem> getAllOrder();
    List<OrderItem> getUserAllOrder(String uAccount);
}

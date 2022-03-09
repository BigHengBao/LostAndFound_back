package com.heng.lostandfound.service;

import com.heng.lostandfound.entity.Goods;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/9/11:30
 * title：用户--物品service
 */

public interface OrderService {
    boolean addOrder(Goods goods,Integer noticeType);
}

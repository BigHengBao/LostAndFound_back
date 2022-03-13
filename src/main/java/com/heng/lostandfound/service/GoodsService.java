package com.heng.lostandfound.service;

import com.heng.lostandfound.entity.Goods;
import com.heng.lostandfound.entity.GoodsInfoItem;

import java.util.List;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/9/11:26
 * title：物品service
 */

public interface GoodsService {
    boolean addGoods(Goods goods);

    List<Goods> getAllGoods();
    GoodsInfoItem getGoodsById(String goodsName, String uName);
}

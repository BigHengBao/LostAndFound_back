package com.heng.lostandfound.service.impl;

import com.heng.lostandfound.entity.Goods;
import com.heng.lostandfound.mapper.GoodsMapper;
import com.heng.lostandfound.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public boolean addGoods(Goods goods) {
        if (goodsMapper.queryGoodsById(goods.getgName(), goods.getuAccount()) == null) {
            goodsMapper.insertGoods(goods);
            return true;
        }
        return false;
    }
}

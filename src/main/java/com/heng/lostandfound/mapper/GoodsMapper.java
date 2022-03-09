package com.heng.lostandfound.mapper;

import com.heng.lostandfound.entity.Goods;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/9/10:45
 * title：物品dao
 * insert：   插入n条记录，返回影响行数n。(n>=1，n为0时实际为插入失败)
 * update：更新n条记录，返回影响行数n。(n>=0)
 * delete： 删除n条记录，返回影响行数n。(n>=0)
 */
@Component(value = "goodsMapper")
public interface GoodsMapper {
    void insertGoods(Goods goods);

    int deleteGoods(Goods goods);

    Integer updateGoods(Goods goods,String goodsName,String userAccount);

    Goods queryGoodsById(String goodsName,String userAccount);

    List<Goods> queryAllGoods();
}

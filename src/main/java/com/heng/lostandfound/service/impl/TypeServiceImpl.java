package com.heng.lostandfound.service.impl;

import com.heng.lostandfound.entity.GoodType;
import com.heng.lostandfound.entity.GoodsTypeItem;
import com.heng.lostandfound.mapper.TypeMapper;
import com.heng.lostandfound.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/9/16:08
 * title：物品类别service实现类
 */
@Service(value = "typeService")
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeMapper typeMapper;

    @Override
    public boolean addType(GoodType goodType) {
        if (typeMapper.queryTypeById(goodType.getTypeName()) == null) {
            typeMapper.insertType(goodType);
            return true;
        }
        return false;
    }

    @Override
    public List<GoodsTypeItem> getAllTypes() {
        List<GoodType> goodTypes = typeMapper.queryAllTypes();
        List<GoodsTypeItem> mGoodsTypes = new ArrayList<>();
        if (goodTypes != null) {
            for (GoodType goodType : goodTypes) {
                GoodsTypeItem goodsTypeItem = new GoodsTypeItem();
                goodsTypeItem.setItemName(goodType.getTypeName());
                goodsTypeItem.setItemImg(null);
                mGoodsTypes.add(goodsTypeItem);
            }
            return mGoodsTypes;
        }
        return null;
    }
}

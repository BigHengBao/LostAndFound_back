package com.heng.lostandfound.service.impl;

import com.heng.lostandfound.entity.GoodType;
import com.heng.lostandfound.mapper.TypeMapper;
import com.heng.lostandfound.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/9/16:08
 * title：物品类别service实现类
 */
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
    public List<GoodType> getAllTypes() {
        return typeMapper.queryAllTypes();
    }
}

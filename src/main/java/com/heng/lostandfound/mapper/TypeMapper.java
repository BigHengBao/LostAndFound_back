package com.heng.lostandfound.mapper;

import com.heng.lostandfound.entity.GoodType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/9/15:54
 * title：物品类别表
 */
@Component(value = "typeMapper")
public interface TypeMapper {
    void insertType(GoodType goodType);

    Integer updateType(String typeName);

    GoodType queryTypeById(String typeName);

    List<GoodType> queryAllTypes();
}

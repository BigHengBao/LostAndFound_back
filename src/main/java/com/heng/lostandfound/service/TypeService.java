package com.heng.lostandfound.service;

import com.heng.lostandfound.entity.GoodType;

import java.util.List;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/9/16:05
 * title：物品类别service
 */

public interface TypeService {
    boolean addType(GoodType goodType);

    List<GoodType> getAllTypes();
}
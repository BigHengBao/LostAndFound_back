package com.heng.lostandfound.service;

import com.heng.lostandfound.entity.OrderItem;

import java.io.IOException;
import java.util.List;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/5/3/12:52
 * title：
 */

public interface TestCacheService {
    List<OrderItem> getCacheOrders() throws IOException;
}

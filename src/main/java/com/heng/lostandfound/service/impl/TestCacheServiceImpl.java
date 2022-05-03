package com.heng.lostandfound.service.impl;

import com.alibaba.fastjson.JSON;
import com.heng.lostandfound.entity.OrderItem;
import com.heng.lostandfound.service.OrderService;
import com.heng.lostandfound.service.TestCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/5/3/12:54
 * title：
 */
@Service(value = "testCacheService")
public class TestCacheServiceImpl implements TestCacheService {
    @Autowired
    RedisTemplate redisTemplate;//专门操作key-value都是对象的

    @Autowired
    OrderService orderService;

    @Override
//    @Cacheable(value = {"ordersCache"}, key = "#root.method.name") //
    public List<OrderItem> getCacheOrders() throws IOException {
        List<OrderItem> redisOrders = new ArrayList<>();
        List redis_orders = redisTemplate.opsForList().range("redis_orders", 0, -1);
        System.out.println("redis_orders"+redis_orders);

        if (redisOrders.size() > 0) {
            for (OrderItem redisOrder : redisOrders) {
                redisOrders.add((OrderItem)JSON.parse(redisOrder.toString()));
            }
            System.out.println("redis有数据！");
        } else {
            redisOrders = orderService.getAllOrder();
            System.out.println("redis无数据！查询数据库");
            for (OrderItem redisOrder : redisOrders) {
                redisTemplate.opsForList().rightPush("redis_orders", JSON.toJSON(redisOrder).toString());
                redisTemplate.expire("redis_orders", Duration.ofSeconds(15));

            }
        }
        return redisOrders;
    }
}

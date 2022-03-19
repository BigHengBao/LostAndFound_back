package com.heng.lostandfound.service.impl;

import com.heng.lostandfound.entity.GoodType;
import com.heng.lostandfound.entity.Goods;
import com.heng.lostandfound.entity.Order;
import com.heng.lostandfound.entity.OrderItem;
import com.heng.lostandfound.mapper.GoodsMapper;
import com.heng.lostandfound.mapper.OrderMapper;
import com.heng.lostandfound.mapper.TypeMapper;
import com.heng.lostandfound.mapper.UserMapper;
import com.heng.lostandfound.service.ImageService;
import com.heng.lostandfound.service.OrderService;
import com.heng.lostandfound.utils.Constant;
import com.heng.lostandfound.utils.ImageTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Editor: hengBao
 * Wechat：zh17530588817
 * date: 2022/3/9/11:31
 * title：用户--物品service实现类
 */

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    TypeMapper typeMapper;

    @Autowired
    ImageService imageService;

    @Override
    public boolean addOrder(Goods goods, Integer noticeType) throws IOException {

        if (orderMapper.queryOrderById(goods.getuAccount(), goods.getgName()) == null) {
            Order order = new Order(goods.getgName(), goods.getuAccount(), Constant.ORDER_ACTIVE_WAITING, noticeType);

            //插入一个用户-商品列
            orderMapper.insertOrder(order);
            String imageTime = "";

            if (noticeType.equals(Constant.ORDER_TYPE_GET)) {
                imageTime = goods.getGetTime();

            } else if (noticeType.equals(Constant.ORDER_TYPE_LOOKING)) {
                imageTime = goods.getLoseTime();
            }

            // goods设置图片
            String goodsImagePath = imageService.saveGoodsImage(goods.getgImage(),
                    goods.getuAccount() + "_" + ImageTools.operateTimeStr(imageTime), Constant.GOODS_IMAGE);
            goods.setgImage(goodsImagePath);


            //插入一个物品
            goodsMapper.insertGoods(goods);
            String typeName = goods.getType();
            GoodType goodType = typeMapper.queryTypeById(typeName);
            if (goodType == null) {
                //如果type不存在，插入一个type行
                typeMapper.insertType(new GoodType(typeName, 1, null, Constant.ACTIVE_TRUE));
            } else {
                //如果type存在，数量+1
                typeMapper.updateType(typeName);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean adjustOrderActive(String userAccount, String goodsName, Integer active) {
        if (orderMapper.queryOrderById(userAccount, goodsName) != null) {
            orderMapper.updateOrder(userAccount, goodsName, active);
            return true;
        }
        return false;
    }

    @Override
    public List<OrderItem> getAllOrder() throws IOException {
        List<Order> orders = orderMapper.queryAllOrder();
        List<OrderItem> mOrder = new ArrayList<>();
        if (orders != null) {
            //封装
            for (Order order : orders) {
                OrderItem orderItem = new OrderItem();
                if (order.getActive() != Constant.ORDER_ACTIVE_END
                        && order.getActive() != Constant.ORDER_ACTIVE_CANCEL) {
                    Goods goods = goodsMapper.queryGoodsById(order.getgName(), order.getuAccount());

                    //设置图片
                    String imageTime = "";
                    if (order.getType().equals(Constant.ORDER_TYPE_GET)) {
                        imageTime = goods.getGetTime();

                    } else if (order.getType().equals(Constant.ORDER_TYPE_LOOKING)) {
                        imageTime = goods.getLoseTime();
                    }

                    System.out.println("getUserAllOrder imageTime" + imageTime);
                    String backUserImage = imageService.backGoodsImage(
                            goods.getuAccount() + "_" + ImageTools.operateTimeStr(imageTime));
                    orderItem.setGoodsName(order.getgName());
                    orderItem.setAuthorName(userMapper.queryUserByUid(order.getuAccount()).getrName());
                    orderItem.setOrderType(order.getType());
                    orderItem.setGoodsType(goods.getType());
                    orderItem.setGoodsImage(backUserImage);
                    if (order.getType().equals(Constant.ORDER_TYPE_LOOKING)) {
                        orderItem.setOrderTime(goods.getLoseTime());
                    } else {
                        orderItem.setOrderTime((goods.getGetTime()));
                    }
                    mOrder.add(orderItem);
                }
            }
            return mOrder;
        }
        return null;
    }

    @Override
    public List<OrderItem> getUserAllOrder(String uAccount) throws IOException {
        List<Order> userOrders = orderMapper.queryUserOrdersByUAccount(uAccount);
        List<OrderItem> mOrder = new ArrayList<>();
        if (userOrders != null) {
            //封装
            for (Order userorder : userOrders) {
                OrderItem orderItem = new OrderItem();
                if (userorder.getActive() != Constant.ORDER_ACTIVE_END
                        && userorder.getActive() != Constant.ORDER_ACTIVE_CANCEL) {
                    Goods goods = goodsMapper.queryGoodsById(userorder.getgName(), userorder.getuAccount());

                    //设置图片
                    String imageTime = "";
                    if (userorder.getType().equals(Constant.ORDER_TYPE_GET)) {
                        imageTime = goods.getGetTime();

                    } else if (userorder.getType().equals(Constant.ORDER_TYPE_LOOKING)) {
                        imageTime = goods.getLoseTime();
                    }

                    System.out.println("getUserAllOrder imageTime" + imageTime);
                    String backUserImage = imageService.backGoodsImage(
                            uAccount + "_" + ImageTools.operateTimeStr(imageTime));
                    //开始组装数据
                    orderItem.setGoodsName(userorder.getgName());
                    orderItem.setAuthorName(userMapper.queryUserByUid(userorder.getuAccount()).getrName());
                    orderItem.setOrderType(userorder.getType());
                    orderItem.setGoodsType(goods.getType());
                    orderItem.setGoodsImage(backUserImage);
                    if (userorder.getType().equals(Constant.ORDER_TYPE_LOOKING)) {
                        orderItem.setOrderTime(goods.getLoseTime());
                    } else {
                        orderItem.setOrderTime((goods.getGetTime()));
                    }
                    mOrder.add(orderItem);
                }
            }
//            System.out.println("getUserAllOrder-------------->: " + mOrder);
            return mOrder;
        }
        return null;
    }
}

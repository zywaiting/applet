package com.zy.applet.service.impl;

import com.zy.applet.mapper.OrderListMapper;
import com.zy.applet.pojo.Goods;
import com.zy.applet.pojo.Order;
import com.zy.applet.pojo.OrderGoods;
import com.zy.applet.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class OrderListServiceImpl implements OrderListService {

    @Autowired
    private OrderListMapper orderListMapper;

    @Override
    public List<Order> selectOrderList(Integer isPay,String openid,Integer isShip) {

        List<Order> orderList = orderListMapper.selectOrderByIsPay(isPay, openid, isShip);
        for (Order order : orderList) {

            List<OrderGoods> orderGoodsList = orderListMapper.selectOrderGoodsByOrderId(order.getId());
            for (OrderGoods orderGoods : orderGoodsList) {
                Goods goods = orderListMapper.selectGoodsByGoodsId(orderGoods.getGoodsId());
                orderGoods.setGoods(goods);
            }
            order.setOrderGoodsList(orderGoodsList);
        }

        return orderList;
    }

}

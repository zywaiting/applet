package com.zy.applet.service.impl;

import com.zy.applet.mapper.OrderListMapper;
import com.zy.applet.pojo.Goods;
import com.zy.applet.pojo.Order;
import com.zy.applet.pojo.OrderGoods;
import com.zy.applet.service.OrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderListServiceImpl implements OrderListService {

    @Autowired
    private OrderListMapper orderListMapper;

    @Override
    public Map selectOrderList(String openid) {

        Map map = new HashMap();
        //未付款,未发货
        List<Order> orderListNoPay = orderListMapper.selectOrderByIsPay(0, openid, 0);
        map.put("nopay",order(orderListNoPay));

        List<Order> orderListNoShip = orderListMapper.selectOrderByIsPay(1, openid, 0);
        map.put("noship",order(orderListNoShip));

        List<Order> orderListShip = orderListMapper.selectOrderByIsPay(1, openid, 1);
        map.put("ship",order(orderListShip));

        return map;
    }

    private List<Order> order(List<Order> orderList){
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

package com.zy.applet.service;

import com.zy.applet.pojo.Order;

import java.util.List;

public interface OrderListService {

    List<Order> selectOrderList(Integer isPay, String openid, Integer isShip);
}

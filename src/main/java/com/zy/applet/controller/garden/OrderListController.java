package com.zy.applet.controller.garden;

import com.zy.applet.pojo.Order;
import com.zy.applet.service.OrderListService;
import com.zy.applet.utils.ResponseMessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderListController {

    @Autowired
    private OrderListService orderListService;

    public ResponseMessageUtils selectOrderList(Integer isPay,String openid,Integer isShip) {
        List<Order> orderList = orderListService.selectOrderList(isPay, openid, isShip);
        return ResponseMessageUtils.ok(orderList);
    }
}

package com.zy.applet.controller.garden;

import com.zy.applet.pojo.Order;
import com.zy.applet.service.OrderListService;
import com.zy.applet.utils.ResponseMessageUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OrderListController {

    @Autowired
    private OrderListService orderListService;

    @RequestMapping("shop")
    @ApiOperation(value = "123")
    public ResponseMessageUtils selectOrderList(Integer isPay,String openid,Integer isShip) {
        List<Order> orderList = orderListService.selectOrderList(isPay, openid, isShip);
        return ResponseMessageUtils.ok(orderList);
    }
}

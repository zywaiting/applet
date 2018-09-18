package com.zy.applet.controller.garden;

import com.zy.applet.pojo.Order;
import com.zy.applet.service.OrderListService;
import com.zy.applet.utils.ResponseMessageUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OrderListController {

    @Autowired
    private OrderListService orderListService;

    @RequestMapping("shop/order")
    @ApiOperation(value = "商品订单")
    public ResponseMessageUtils selectOrderList(String openid) {
        Map map = orderListService.selectOrderList(openid);
        return ResponseMessageUtils.ok(map);
    }
}

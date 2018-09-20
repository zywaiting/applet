package com.zy.applet.controller.garden;

import com.zy.applet.service.OrderExpressService;
import com.zy.applet.utils.ResponseMessageUtils;
import com.zy.applet.utils.aliyun.ExpressUtils;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class OrderExpressController {

    private final static Logger logger = LoggerFactory.getLogger(OrderExpressController.class);

    @Autowired
    private OrderExpressService orderExpressService;


    @RequestMapping("expressinquiry")
    @ApiOperation(value = "查询快递地址")
    public ResponseMessageUtils expressInquiry(String openid,String shipNmber,String orderNumber,String shipName) {
        ExpressUtils.Result result = orderExpressService.selectExpressContentByExpressNo(openid, shipNmber, orderNumber, shipName);
        return ResponseMessageUtils.ok(result);
    }

}

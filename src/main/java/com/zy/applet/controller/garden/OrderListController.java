package com.zy.applet.controller.garden;

import com.zy.applet.pojo.CreateOrder;
import com.zy.applet.pojo.Goods;
import com.zy.applet.pojo.GoodsShopcar;
import com.zy.applet.pojo.Order;
import com.zy.applet.service.OrderListService;
import com.zy.applet.utils.ResponseMessageUtils;
import com.zy.applet.utils.Utils;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

@RestController
public class OrderListController {

    private final static Logger logger = LoggerFactory.getLogger(OrderListController.class);

    @Autowired
    private OrderListService orderListService;

    @RequestMapping("shop/order")
    @ApiOperation(value = "商品订单")
    public ResponseMessageUtils order(String openid) {
        Map map = orderListService.selectOrderList(openid);
        return ResponseMessageUtils.ok(map);
    }

    @RequestMapping("shop/shopcar")
    @ApiOperation(value = "购物车列表")
    public ResponseMessageUtils shopcar(String openid) {
        Map map = new HashMap();
        BigDecimal sumPrice = new BigDecimal(0);
        List<Goods> goodsList = orderListService.selectGoodsShopcarList(openid);
        for (Goods goods : goodsList) {
            BigDecimal prices = new BigDecimal(goods.getNum()).multiply(goods.getShopPrice());
            sumPrice = sumPrice.add(prices);
        }
        map.put("goodsList",goodsList);
        map.put("sumPrice",sumPrice);
        map.put("goodsNumber",goodsList.size());
        return ResponseMessageUtils.ok(map);
    }

    @RequestMapping("shop/shopcarAddOrDel")
    @ApiOperation(value = "购物车商品数量增减")
    public ResponseMessageUtils shopcarAddOrDel(String openid, Integer goodsId, Integer goodsNum) {

        Map map = new HashMap();
        Integer integer = orderListService.updateGoodsShopcarGoodsNum(openid, goodsId, goodsNum);
        if (integer > 0) {
            BigDecimal sumPrice = new BigDecimal(0);
            List<Goods> goodsList = orderListService.selectGoodsShopcarList(openid);
            for (Goods goods : goodsList) {
                BigDecimal prices = new BigDecimal(goods.getNum()).multiply(goods.getShopPrice());
                sumPrice = sumPrice.add(prices);
            }
            map.put("goodsList",goodsList);
            map.put("sumPrice",sumPrice);
            map.put("goodsNumber",goodsList.size());
        }
        return ResponseMessageUtils.ok(map);
    }

    @RequestMapping("shop/createOrder")
    @ApiOperation(value = "购物车转成订单")
    public ResponseMessageUtils createOrder(String openid, String createOrderJson) {
        logger.info("createOrderJson:,{}",createOrderJson);
        String orderNumber = orderListService.createOrder(openid, createOrderJson);
        return ResponseMessageUtils.ok(orderNumber);
    }

    @RequestMapping("shop/orderItem")
    @ApiOperation(value = "购物车转成订单")
    public ResponseMessageUtils orderItem(String orderNumber) {
        Order order = orderListService.selectOrderItem(orderNumber);
        return ResponseMessageUtils.ok(order);
    }


    @RequestMapping("shop/goodsItem")
    @ApiOperation(value = "查询产品信息")
    public ResponseMessageUtils goodsItem(Integer id) {
        Goods goods = orderListService.selectGoodsById(id);
        return ResponseMessageUtils.ok(goods);
    }

    @RequestMapping("shop/addGoodsToShopcar")
    @ApiOperation(value = "查询产品信息")
    public ResponseMessageUtils addGoodsToShopcar(String openid, Integer goodsId) {
        GoodsShopcar goodsShopcar = orderListService.selectGoodsShopcarByGoodsIdAndOpenid(openid, goodsId);
        if (goodsShopcar != null) {
            orderListService.updateGoodsShopcarGoodsNum(openid, goodsId, goodsShopcar.getNum()+1);
        } else {
            orderListService.insterGoodsShopcar(openid, goodsId);
        }
        return ResponseMessageUtils.ok();
    }
}

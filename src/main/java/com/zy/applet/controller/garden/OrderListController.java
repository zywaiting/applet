package com.zy.applet.controller.garden;

import com.zy.applet.pojo.Goods;
import com.zy.applet.pojo.Order;
import com.zy.applet.service.OrderListService;
import com.zy.applet.utils.ResponseMessageUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OrderListController {

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
    public ResponseMessageUtils shopcarAddOrDel(String openid, String goodsId, Integer goodsNum) {

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
}

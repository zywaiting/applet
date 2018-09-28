package com.zy.applet.service;

import com.zy.applet.pojo.Goods;
import com.zy.applet.pojo.GoodsShopcar;
import com.zy.applet.pojo.Order;

import java.util.List;
import java.util.Map;

public interface OrderListService {

    Map selectOrderList(String openid);

    List<Goods> selectGoodsShopcarList(String openid);

    //更新购物车商品数量
    Integer updateGoodsShopcarGoodsNum(String openid, Integer goodsId, Integer goodsNum);

    //添加一笔订单
    String createOrder(String openid, String createOrderJson);

    //查询某一单详情
    Order selectOrderItem(String orderNumber);

    //查询商品信息
    Goods selectGoodsById(Integer id);

    //网购物车添加商品
    Integer insterGoodsShopcar(String openid, Integer goodsId);

    //查询用户是否购物车中已有该产品
    GoodsShopcar selectGoodsShopcarByGoodsIdAndOpenid(String openid, Integer goodsId);

    //更新订单地址
    Integer updateOrderOfAdderss(String orderNumber,Integer addAddressId);
}

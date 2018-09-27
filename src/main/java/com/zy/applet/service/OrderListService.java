package com.zy.applet.service;

import com.zy.applet.pojo.Goods;

import java.util.List;
import java.util.Map;

public interface OrderListService {

    Map selectOrderList(String openid);

    List<Goods> selectGoodsShopcarList(String openid);

    //更新购物车商品数量
    Integer updateGoodsShopcarGoodsNum(String openid, String goodsId, Integer goodsNum);
}

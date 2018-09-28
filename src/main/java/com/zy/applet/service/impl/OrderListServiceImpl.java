package com.zy.applet.service.impl;

import com.zy.applet.mapper.OrderListMapper;
import com.zy.applet.pojo.*;
import com.zy.applet.service.OrderListService;
import com.zy.applet.utils.Utils;
import org.apache.commons.lang3.StringUtils;
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

    @Override
    public List<Goods> selectGoodsShopcarList(String openid) {
        List<GoodsShopcar> goodsShopcarList = orderListMapper.selectGoodsShopcarList(openid, 1);
        List<Goods> goodsList = new ArrayList<>();
        for (GoodsShopcar goodsShopcar : goodsShopcarList) {
            Goods goods = orderListMapper.selectGoodsByGoodsId(goodsShopcar.getGoodsId());
            goods.setNum(goodsShopcar.getNum());
            goodsList.add(goods);
        }
        return goodsList;
    }

    @Override
    public Integer updateGoodsShopcarGoodsNum(String openid, Integer goodsId, Integer goodsNum) {
        return orderListMapper.updateGoodsShopcarGoodsNum(goodsNum, openid, goodsId, 1);
    }

    @Override
    public String createOrder(String openid, String createOrderJson) {
        String orderNumber = UUID.randomUUID().toString().replaceAll("-","");
        CreateOrder createOrder = Utils.json(createOrderJson, CreateOrder.class);
        Order order = new Order();
        order.setOrderNumber(orderNumber);
        order.setOpenid(openid);
        order.setPayPrice(createOrder.getSumPrice());
        order.setIsPay(0);
        order.setPayTime(new Date());
        order.setIsShip(0);
        order.setShipTime(new Date());
        order.setIsReceipt(0);
        order.setReceiptTime(new Date());
        order.setStatus(1);
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        Integer integer = orderListMapper.insterOrder(order);
        Integer integer1 = orderListMapper.updateGoodsShopcarStatus(1);
        if (integer > 0 && integer1 > 0) {
            Order orderByOrderNumber = orderListMapper.selectOrderByOrderNumber(orderNumber);
            for (Goods goods : createOrder.getGoodsList()) {
                OrderGoods orderGoods = new OrderGoods();
                orderGoods.setOrderId(orderByOrderNumber.getId());
                orderGoods.setGoodsId(goods.getId());
                orderGoods.setGoodsNum(goods.getNum());
                orderGoods.setGoodsPrice(goods.getShopPrice());
                orderGoods.setStatus(1);
                orderGoods.setCreateTime(new Date());
                orderGoods.setUpdateTime(new Date());
                orderListMapper.insterOrderGoods(orderGoods);
            }
        }
        return orderNumber;
    }

    @Override
    public Order selectOrderItem(String orderNumber) {
        Order order = orderListMapper.selectOrderByOrderNumber(orderNumber);
        List<OrderGoods> orderGoodsList = orderListMapper.selectOrderGoodsByOrderId(order.getId());
        for (OrderGoods orderGoods : orderGoodsList) {
            Goods goods = orderListMapper.selectGoodsByGoodsId(orderGoods.getGoodsId());
            goods.setNum(orderGoods.getGoodsNum());
            orderGoods.setGoods(goods);
        }
        order.setOrderGoodsList(orderGoodsList);
        return order;
    }

    @Override
    public Goods selectGoodsById(Integer id) {
        Goods goods = orderListMapper.selectGoodsById(id);
        if (StringUtils.isNotBlank(goods.getGallery()) && goods.getGallery().contains(",")) {
            List<String> imgList = new ArrayList<>();
            String[] split = goods.getGallery().split(",");
            for (String s : split) {
                imgList.add(s);
            }
            goods.setImgList(imgList);
        }
        return goods;
    }

    @Override
    public Integer insterGoodsShopcar(String openid, Integer goodsId) {
        GoodsShopcar goodsShopcar = new GoodsShopcar();
        goodsShopcar.setOpenid(openid);
        goodsShopcar.setGoodsId(goodsId);
        goodsShopcar.setNum(1);
        goodsShopcar.setStatus(1);
        goodsShopcar.setUpdateTime(new Date());
        goodsShopcar.setCreateTime(new Date());
        return orderListMapper.insterGoodsShopcar(goodsShopcar);
    }

    @Override
    public GoodsShopcar selectGoodsShopcarByGoodsIdAndOpenid(String openid, Integer goodsId) {
        GoodsShopcar goodsShopcar = new GoodsShopcar();
        goodsShopcar.setOpenid(openid);
        goodsShopcar.setGoodsId(goodsId);
        goodsShopcar.setStatus(1);
        return orderListMapper.selectGoodsShopcarByGoodsIdAndOpenid(goodsShopcar);
    }

    @Override
    public Integer updateOrderOfAdderss(String orderNumber, Integer addAddressId) {
        return orderListMapper.updateOrderOfAdderss(orderNumber,addAddressId);
    }

    @Override
    public ShopPay selectShopPayByPayPriceAndChannel(String payPrice, String channel) {
        return orderListMapper.selectShopPayByPayPriceAndChannel(payPrice,channel);
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

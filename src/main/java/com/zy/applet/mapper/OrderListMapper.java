package com.zy.applet.mapper;

import com.zy.applet.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单
 */
@Mapper
public interface OrderListMapper {

    //查询订单
    List<Order> selectOrderByIsPay(@Param("isPay") Integer isPay,@Param("openid") String openid, @Param("isShip") Integer isShip);

    //查询订单所含的产品
    List<OrderGoods> selectOrderGoodsByOrderId(@Param("orderId") Integer orderId);

    //查询商品信息
    Goods selectGoodsByGoodsId(@Param("id") Integer id);

    //查询某个订单的信息
    Order selectOrderByOrderNumber(@Param("orderNumber") String orderNumber);

    //查询这个人的购物车信息
    List<GoodsShopcar> selectGoodsShopcarList(@Param("openid")String openid,@Param("status") Integer status);

    //更新购物车商品数量
    Integer updateGoodsShopcarGoodsNum(@Param("goodsNum") Integer goodsNum,@Param("openid") String openid, @Param("goodsId") Integer goodsId, @Param("status") Integer status);

    //添加一笔订单
    Integer insterOrder(Order order);

    //添加order_goods记录
    Integer insterOrderGoods(OrderGoods orderGoods);

    //更改购物车状态
    Integer updateGoodsShopcarStatus(@Param("status")Integer status);

    //查询商品信息
    Goods selectGoodsById(@Param("id")Integer id);

    //网购物车添加商品
    Integer insterGoodsShopcar(GoodsShopcar goodsShopcar);

    //查询用户是否购物车中已有该产品
    GoodsShopcar selectGoodsShopcarByGoodsIdAndOpenid(GoodsShopcar goodsShopcar);

    //更新订单地址
    Integer updateOrderOfAdderss(@Param("orderNumber") String orderNumber,@Param("addAddressId") Integer addAddressId);

    //查询用户需支付的金额图片
    ShopPay selectShopPayByPayPriceAndChannel(@Param("payPrice") String payPrice,@Param("channel") String channel);

}

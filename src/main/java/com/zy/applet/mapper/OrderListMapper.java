package com.zy.applet.mapper;

import com.zy.applet.pojo.Goods;
import com.zy.applet.pojo.GoodsShopcar;
import com.zy.applet.pojo.Order;
import com.zy.applet.pojo.OrderGoods;
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
    Order selectOrderGoodsByOrderNumber(@Param("orderNumber") String orderNumber);

    //查询这个人的购物车信息
    List<GoodsShopcar> selectGoodsShopcarList(@Param("openid")String openid,@Param("status") Integer status);

    //更新购物车商品数量
    Integer updateGoodsShopcarGoodsNum(@Param("goodsNum") Integer goodsNum,@Param("openid") String openid, @Param("goodsId") String goodsId, @Param("status") Integer status);


}

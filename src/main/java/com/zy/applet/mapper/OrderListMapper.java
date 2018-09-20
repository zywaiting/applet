package com.zy.applet.mapper;

import com.zy.applet.pojo.Goods;
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

}

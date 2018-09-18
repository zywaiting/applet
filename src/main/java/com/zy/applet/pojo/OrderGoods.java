package com.zy.applet.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单对应商品
 */
public class OrderGoods {
    /**
     * id` int(4) NOT NULL AUTO_INCREMENT COMMENT '主键、自增长',
     *   `order_id` int(10) DEFAULT NULL COMMENT '订单id，关联order表id字段',
     *   `goods_id` int(10) DEFAULT NULL COMMENT '商品id，关联goods表id字段',
     *   `goods_num` int(10) DEFAULT NULL COMMENT '商品购买数量',
     *   `goods_price` double(20,2) DEFAULT NULL COMMENT '单个商品价格',
     *   `status` tinyint(4) DEFAULT NULL COMMENT '记录状态。1：正常，0：禁用，-1：删除',
     *   `create_time` datetime DEFAULT NULL COMMENT '记录创建时间，时间戳',
     *   `update_time` datetime DEFAULT NULL COMMENT '记录更新时间，时间戳',
     */
    private Integer id;
    private Integer orderId;
    private Integer goodsId;
    private Integer goodsNum;
    private BigDecimal goodsPrice;
    private Integer status;
    private Date createTime;
    private Date updateTime;

    //数据之外
    private Goods goods;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

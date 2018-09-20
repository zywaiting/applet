package com.zy.applet.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单表
 */
public class Order {
    /**
     * `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '主键、自增长',
     *   `order_number` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '订单号，如uuid',
     *   `openid` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户openid，关联user_config',
     *   `pay_price` double(20,2) DEFAULT NULL COMMENT '实际支付价格',
     *   `is_pay` tinyint(4) DEFAULT NULL COMMENT '是否已经支付。0：未支付，1：完成支付',
     *   `pay_time` int(10) DEFAULT NULL COMMENT '支付时间，时间戳',
     *   `is_ship` tinyint(4) DEFAULT NULL COMMENT '是否已经发货。0：未发货，1：已发货',
     *   `ship_time` int(10) DEFAULT NULL COMMENT '发货时间，时间戳',
     *   `is_receipt` tinyint(4) DEFAULT NULL COMMENT '是否已经收货。0：未收货，1：已收货',
     *   `receipt_time` int(10) DEFAULT NULL COMMENT '收货时间，时间戳',
     *   `ship_nmber` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '快递单号',
     *   `status` tinyint(4) DEFAULT NULL COMMENT '记录状态。1：正常，0：禁用，1：删除',
     *   `create_time` datetime DEFAULT NULL COMMENT '记录创建时间，时间戳',
     *   `update_time` datetime DEFAULT NULL COMMENT '记
     */

    private Integer id;
    private String orderNumber;
    private String openid;
    private BigDecimal payPrice;
    private Integer isPay;
    private Date payTime;
    private Integer isShip;
    private Date shipTime;
    private Integer isReceipt;
    private Date receipt_time;
    private String shipNmber;
    private Integer status;
    private Date createTime;
    private Date updateTime;
    private String shipName;

    //数据库之外
    private List<OrderGoods> orderGoodsList;

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public List<OrderGoods> getOrderGoodsList() {
        return orderGoodsList;
    }

    public void setOrderGoodsList(List<OrderGoods> orderGoodsList) {
        this.orderGoodsList = orderGoodsList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getIsShip() {
        return isShip;
    }

    public void setIsShip(Integer isShip) {
        this.isShip = isShip;
    }

    public Date getShipTime() {
        return shipTime;
    }

    public void setShipTime(Date shipTime) {
        this.shipTime = shipTime;
    }

    public Integer getIsReceipt() {
        return isReceipt;
    }

    public void setIsReceipt(Integer isReceipt) {
        this.isReceipt = isReceipt;
    }

    public Date getReceipt_time() {
        return receipt_time;
    }

    public void setReceipt_time(Date receipt_time) {
        this.receipt_time = receipt_time;
    }

    public String getShipNmber() {
        return shipNmber;
    }

    public void setShipNmber(String shipNmber) {
        this.shipNmber = shipNmber;
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

package com.zy.applet.pojo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 创建实体类
 */
public class CreateOrder {
    private BigDecimal sumPrice;
    private Integer goodsNumber;
    private List<Goods> goodsList;

    public BigDecimal getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(BigDecimal sumPrice) {
        this.sumPrice = sumPrice;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}

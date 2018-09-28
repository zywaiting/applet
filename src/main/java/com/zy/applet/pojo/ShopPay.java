package com.zy.applet.pojo;

import java.util.Date;

/**
 * 支付
 */
public class ShopPay {
    /**
     * CREATE TABLE `shop_pay` (
     `id` int(11) NOT NULL AUTO_INCREMENT,
     `channel` varchar(255) DEFAULT NULL,
     `pay_money` varchar(255) DEFAULT NULL COMMENT '支付金额',
     `img_url` varchar(255) DEFAULT NULL COMMENT '图片路径',
     `update_date` datetime DEFAULT NULL COMMENT '更新时间',
     `credit_date` datetime DEFAULT NULL COMMENT '创建时间',
     `remake` varchar(255) DEFAULT NULL,
     PRIMARY KEY (`id`)
     ) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
     */
    private Integer id;
    private String channel;
    private String payMoney;
    private String imgUrl;
    private Date updateDate;
    private Date creditDate;
    private String remake;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(String payMoney) {
        this.payMoney = payMoney;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreditDate() {
        return creditDate;
    }

    public void setCreditDate(Date creditDate) {
        this.creditDate = creditDate;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }
}

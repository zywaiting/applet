package com.zy.applet.pojo;

import java.util.Date;

/**
 * 购物车
 */
public class GoodsShopcar {
    /**
     * `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '主键、自增长',
     *   `openid` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户openid，关联user_config',
     *   `goods_id` int(10) DEFAULT NULL COMMENT '商品id，关联goods表id',
     *   `num` int(10) DEFAULT NULL COMMENT '商品数量',
     *   `status` tinyint(4) DEFAULT NULL COMMENT '记录状态。1：正常，0：禁用，-1：删除',
     *   `create_time` datetime DEFAULT NULL COMMENT '记录创建时间，时间戳',
     *   `update_time` datetime DEFAULT NULL COMMENT '记录更新时间，时间戳',
     */
    private Integer id;
    private String openid;
    private Integer goodsId;
    private Integer num;
    private Integer status;
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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

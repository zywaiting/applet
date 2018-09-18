package com.zy.applet.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 产品表
 */
public class Goods {
    /**
     * `id` int(11) NOT NULL,
     *   `product_no` varchar(20) DEFAULT NULL COMMENT '商品货号',
     *   `name` varchar(50) DEFAULT NULL COMMENT '商品名称',
     *   `img` varchar(150) DEFAULT NULL COMMENT '商品图片',
     *   `market_price` decimal(10,2) DEFAULT NULL COMMENT '市场价',
     *   `shop_price` decimal(10,2) DEFAULT NULL COMMENT '门店价',
     *   `stock` varchar(11) DEFAULT NULL COMMENT '商品总库存',
     *   `unit` varchar(10) DEFAULT NULL COMMENT '单位',
     *   `is_sale` tinyint(4) DEFAULT NULL COMMENT '是否上架  0:不上架 1:上架',
     *   `desc` text COMMENT '商品描述',
     *   `status` tinyint(4) DEFAULT NULL COMMENT '商品状态 	-1:违规 0:未审核 1:已审核',
     *   `sale_num` int(11) DEFAULT NULL COMMENT '总销售量',
     *   `sale_time` datetime DEFAULT NULL,
     *   `gallery` text COMMENT '商品相册',
     *   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
     */
    private Integer id;
    private String productNo;
    private String name;
    private String img;
    private BigDecimal marketPrice;
    private BigDecimal shopPrice;
    private String stock;
    private String unit;
    private Integer isSale;
    private String desc;
    private Integer status;
    private Integer saleNum;
    private Date saleTime;
    private String gallery;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public BigDecimal getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(BigDecimal shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getIsSale() {
        return isSale;
    }

    public void setIsSale(Integer isSale) {
        this.isSale = isSale;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

    public String getGallery() {
        return gallery;
    }

    public void setGallery(String gallery) {
        this.gallery = gallery;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

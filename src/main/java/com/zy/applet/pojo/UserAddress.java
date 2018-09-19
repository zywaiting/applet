package com.zy.applet.pojo;

import java.util.Date;

/**
 * 用户地址
 */
public class UserAddress {
    /**
     `id` int(11) NOT NULL AUTO_INCREMENT,
     `openid` varchar(30) DEFAULT NULL COMMENT '用户id',
     `name` varchar(50) DEFAULT NULL COMMENT '收货人名称',
     `phone` varchar(20) DEFAULT NULL COMMENT '收货人手机',
     `address` varchar(255) DEFAULT NULL COMMENT '详细地址',
     `is_default` tinyint(6) DEFAULT NULL COMMENT '是否默认地址  0:否 1:是',
     `address_flag` tinyint(6) DEFAULT NULL COMMENT '删除状态  -1:删除 1:有效',
     `create_date` datetime DEFAULT NULL COMMENT '创建时间',
     `update_date` datetime DEFAULT NULL COMMENT '修改时间',
     */

    private Integer id;
    private String openid;
    private String name;
    private String phone;
    private String address;
    private Integer isDefault;
    private Integer addressFlag;
    private Date createDate;
    private Date updateDate;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getAddressFlag() {
        return addressFlag;
    }

    public void setAddressFlag(Integer addressFlag) {
        this.addressFlag = addressFlag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}

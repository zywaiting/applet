package com.zy.applet.pojo;

/**
 * @author zy
 * 用户名片表
 * 2018-8-23
 */
public class UserCard {
    /**
     *   `id` int(11) NOT NULL AUTO_INCREMENT,
     *   `open_id` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT 'openId',
     *   `name` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '姓名',
     *   `mobile` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '电话',
     *   `email` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '邮箱',
     *   `qq` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT 'qq',
     *   `company` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '公司',
     *   `url` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '路径',
     *   `til` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '职业',
     *   `adr` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '住址',
     *   `image_url` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '名片路径',
     *   `remake` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
     */
    private Integer id;
    private String openId;
    private String name;
    private String mobile;
    private String email;
    private String qq;
    private String company;
    private String url;
    private String til;
    private String adr;
    private String imageUrl;
    private String remake;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTil() {
        return til;
    }

    public void setTil(String til) {
        this.til = til;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }
}

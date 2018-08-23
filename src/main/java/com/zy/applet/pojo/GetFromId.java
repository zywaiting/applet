package com.zy.applet.pojo;

import java.util.Date;

public class GetFromId {
    /**
     * `id` int(11) NOT NULL AUTO_INCREMENT,
     `open_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT 'openId',
     `from_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '表单id',
     `number` int(11) DEFAULT NULL,
     `credit_date` datetime DEFAULT NULL,
     */
    private Integer id;
    private String openId;
    private String fromId;
    private Integer number;
    private Date creditDate;

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

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getCreditDate() {
        return creditDate;
    }

    public void setCreditDate(Date creditDate) {
        this.creditDate = creditDate;
    }
}

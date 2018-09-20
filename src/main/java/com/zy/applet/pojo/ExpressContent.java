package com.zy.applet.pojo;

import java.util.Date;

/**
 * 快递查询
 */
public class ExpressContent {
    /**
     * `id` int(11) NOT NULL,
     *   `openid` varchar(50) DEFAULT NULL COMMENT '用户id',
     *   `express_no` varchar(50) DEFAULT NULL COMMENT '快递单号',
     *   `content` text COMMENT '查询返回的内容',
     *   `update_date` datetime DEFAULT NULL,
     *   `credit_date` datetime DEFAULT NULL,
     */
    private Integer id;
    private String openid;
    private String expressNo;
    private String content;
    private Date updateDate;
    private Date creditDate;
    private Integer status;
    private String remake;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

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

    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}

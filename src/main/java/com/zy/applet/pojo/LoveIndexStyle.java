package com.zy.applet.pojo;

import java.util.Date;

/**
 * 主页显示控制器
 */
public class LoveIndexStyle {
    /**
     *   `id` int(11) NOT NULL AUTO_INCREMENT,
     `page` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '页面',
     `style` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '是否显示',
     `credit_date` datetime DEFAULT NULL,
     `remake` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
     */
    private Integer id;
    private String express;
    private String page;
    private String style;
    private Date creditDate;
    private String remake;

    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
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

package com.zy.applet.pojo;

import java.util.Date;

/**
 * 表白内容
 */
public class LovePageContext {
    /**
     * `id` int(11) NOT NULL AUTO_INCREMENT,
     `page` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '哪个网页',
     `express` varchar(255) NOT NULL COMMENT '唯一标识',
     `con1` longtext CHARACTER SET utf8,
     `con2` longtext CHARACTER SET utf8,
     `con3` longtext CHARACTER SET utf8,
     `con4` longtext CHARACTER SET utf8,
     `con5` longtext CHARACTER SET utf8,
     `con6` longtext CHARACTER SET utf8,
     `con7` longtext CHARACTER SET utf8,
     `con8` longtext CHARACTER SET utf8,
     `con9` longtext CHARACTER SET utf8,
     `con10` longtext CHARACTER SET utf8,
     `con11` longtext CHARACTER SET utf8,
     `con12` longtext CHARACTER SET utf8,
     `con13` longtext CHARACTER SET utf8,
     `con14` longtext CHARACTER SET utf8,
     `con15` longtext CHARACTER SET utf8,
     `con16` longtext CHARACTER SET utf8,
     `con17` longtext CHARACTER SET utf8,
     `con18` longtext CHARACTER SET utf8,
     `con19` longtext CHARACTER SET utf8,
     `con20` longtext CHARACTER SET utf8,
     `remake` varchar(255) DEFAULT NULL,
     */
    private Integer id;
    private String openId;
    private String page;
    private String mark;
    private String express;
    private String con1;
    private String con2;
    private String con3;
    private String con4;
    private String con5;
    private String con6;
    private String con7;
    private String con8;
    private String con9;
    private String con10;
    private String con11;
    private String con12;
    private String con13;
    private String con14;
    private String con15;
    private String con16;
    private String con17;
    private String con18;
    private String con19;
    private String con20;
    private Date crediteDate;
    private String remake;

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
    }

    public String getCon1() {
        return con1;
    }

    public void setCon1(String con1) {
        this.con1 = con1;
    }

    public String getCon2() {
        return con2;
    }

    public void setCon2(String con2) {
        this.con2 = con2;
    }

    public String getCon3() {
        return con3;
    }

    public void setCon3(String con3) {
        this.con3 = con3;
    }

    public String getCon4() {
        return con4;
    }

    public void setCon4(String con4) {
        this.con4 = con4;
    }

    public String getCon5() {
        return con5;
    }

    public void setCon5(String con5) {
        this.con5 = con5;
    }

    public String getCon6() {
        return con6;
    }

    public void setCon6(String con6) {
        this.con6 = con6;
    }

    public String getCon7() {
        return con7;
    }

    public void setCon7(String con7) {
        this.con7 = con7;
    }

    public String getCon8() {
        return con8;
    }

    public void setCon8(String con8) {
        this.con8 = con8;
    }

    public String getCon9() {
        return con9;
    }

    public void setCon9(String con9) {
        this.con9 = con9;
    }

    public String getCon10() {
        return con10;
    }

    public void setCon10(String con10) {
        this.con10 = con10;
    }

    public String getCon11() {
        return con11;
    }

    public void setCon11(String con11) {
        this.con11 = con11;
    }

    public String getCon12() {
        return con12;
    }

    public void setCon12(String con12) {
        this.con12 = con12;
    }

    public String getCon13() {
        return con13;
    }

    public void setCon13(String con13) {
        this.con13 = con13;
    }

    public String getCon14() {
        return con14;
    }

    public void setCon14(String con14) {
        this.con14 = con14;
    }

    public String getCon15() {
        return con15;
    }

    public void setCon15(String con15) {
        this.con15 = con15;
    }

    public String getCon16() {
        return con16;
    }

    public void setCon16(String con16) {
        this.con16 = con16;
    }

    public String getCon17() {
        return con17;
    }

    public void setCon17(String con17) {
        this.con17 = con17;
    }

    public String getCon18() {
        return con18;
    }

    public void setCon18(String con18) {
        this.con18 = con18;
    }

    public String getCon19() {
        return con19;
    }

    public void setCon19(String con19) {
        this.con19 = con19;
    }

    public String getCon20() {
        return con20;
    }

    public void setCon20(String con20) {
        this.con20 = con20;
    }

    public Date getCrediteDate() {
        return crediteDate;
    }

    public void setCrediteDate(Date crediteDate) {
        this.crediteDate = crediteDate;
    }
}

package com.zy.applet.pojo;

import java.util.Date;

/**
 * love页面
 */
public class LovePage {
    /**
     *   `id` int(11) NOT NULL,
     `title` longtext CHARACTER SET utf8 COMMENT '标题',
     `body` longtext CHARACTER SET utf8 COMMENT '身体',
     `script` longtext CHARACTER SET utf8 COMMENT 'js',
     `credite_date` datetime DEFAULT NULL COMMENT '创建时间',
     `update_date` datetime DEFAULT NULL COMMENT '更新时间',
     `remake` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
     */
    private Integer id;
    private String express;
    private String title;
    private String body;
    private String script;
    private Date crediteDate;
    private Date updateDate;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public Date getCrediteDate() {
        return crediteDate;
    }

    public void setCrediteDate(Date crediteDate) {
        this.crediteDate = crediteDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}

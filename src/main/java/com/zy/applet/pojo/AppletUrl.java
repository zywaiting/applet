package com.zy.applet.pojo;

/**
 * zy
 * 2018-8-1
 */
public class AppletUrl {
    /**
     * `id` int(11) NOT NULL,
     *   `name` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '名称',
     *   `url` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '路径',
     *   `remake` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
     */

    private Integer id;
    private String name;
    private String url;
    private String remake;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }
}

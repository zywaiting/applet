package com.zy.applet.pojo;

/**
 * 旅游实体类
 */
public class Travel {
    /**
     *   `id` int(11) NOT NULL,
     *   `name` varchar(10) CHARACTER SET utf8 NOT NULL COMMENT '名称',
     *   `score` varchar(2) CHARACTER SET utf8 DEFAULT NULL COMMENT '评分',
     *   `detail` text CHARACTER SET utf8 COMMENT '描述',
     *   `imgurl` text CHARACTER SET utf8 COMMENT '图片地址',
     *   `remake` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
     */
    private Integer id;
    private String crity;
    private String name;
    private String score;
    private String detail;
    private String imgurl;
    private String remake;

    public String getCrity() {
        return crity;
    }

    public void setCrity(String crity) {
        this.crity = crity;
    }

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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }
}

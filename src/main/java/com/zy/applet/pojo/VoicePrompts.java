package com.zy.applet.pojo;

/**
 * @author ZY
 * 2018-08-17
 * 语音提示
 */
public class VoicePrompts {
    /**
     * `id` int(11) NOT NULL AUTO_INCREMENT,
     `key` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '标识',
     `url` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '声音路径',
     `remake` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
     */
    private Integer id;
    private String key;
    private String url;
    private String remake;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

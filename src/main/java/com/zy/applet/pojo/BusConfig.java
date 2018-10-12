package com.zy.applet.pojo;

/**
 * 车辆信息
 */
public class BusConfig {

    /**
     * `id` int(11) NOT NULL AUTO_INCREMENT,
     *   `crity` varchar(255) DEFAULT '' COMMENT '城市',
     *   `bus_name` varchar(255) DEFAULT NULL COMMENT '公交车名',
     *   `bus_id` int(11) DEFAULT NULL,
     *   `begin_end` varchar(255) DEFAULT NULL COMMENT '起始站',
     *   `url` varchar(255) DEFAULT NULL COMMENT '路径',
     *   `remake` varchar(255) DEFAULT NULL,
     */
    private Integer id;
    private String crity;
    private String busName;
    private String busId;
    private String beginEnd;
    private String url;
    private String remake;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCrity() {
        return crity;
    }

    public void setCrity(String crity) {
        this.crity = crity;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getBeginEnd() {
        return beginEnd;
    }

    public void setBeginEnd(String beginEnd) {
        this.beginEnd = beginEnd;
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

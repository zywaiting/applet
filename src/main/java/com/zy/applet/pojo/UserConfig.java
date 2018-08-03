package com.zy.applet.pojo;

/**
 * 用户信息表
 */
public class UserConfig {
    /**
     *   `id` int(11) NOT NULL,
     *   `user_name` varchar(100) DEFAULT '' COMMENT '用户名',
     *   `password` varchar(100) DEFAULT NULL COMMENT '密码',
     *   `nick_name` varchar(100) DEFAULT NULL COMMENT '用户昵称',
     *   `avatar_url` varchar(255) DEFAULT NULL COMMENT '用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表132*132正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。',
     *   `gender` varchar(5) DEFAULT NULL COMMENT '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
     *   `city` varchar(20) DEFAULT NULL COMMENT '用户所在城市',
     *   `province` varchar(20) DEFAULT NULL COMMENT '用户所在省份',
     *   `country` varchar(20) DEFAULT NULL COMMENT '用户所在国家',
     *   `language` varchar(20) DEFAULT NULL COMMENT '用户的语言，简体中文为zh_CN',
     *   `mobile` varchar(15) DEFAULT NULL COMMENT '手机号',
     *   `latitude` varchar(15) DEFAULT NULL COMMENT '纬度，浮点数，范围为-90~90，负数表示南纬',
     *   `longitude` varchar(15) DEFAULT NULL COMMENT '经度，浮点数，范围为-180~180，负数表示西经',
     *   `speed` varchar(20) DEFAULT NULL COMMENT '速度，浮点数，单位m/s',
     *   `accuracy` varchar(20) DEFAULT NULL COMMENT '位置的精确度',
     *   `altitude` varchar(20) DEFAULT NULL COMMENT '高度，单位 m',
     *   `verticalAccuracy` varchar(20) DEFAULT NULL COMMENT '垂直精度，单位 m（Android 无法获取，返回 0）',
     *   `horizontalAccuracy` varchar(20) DEFAULT NULL COMMENT '水平精度，单位 m',
     */

    private Integer id;
    private String openId;
    private String userName;
    private String password;
    private String nickName;
    private String avatarUrl;
    private String gender;
    private String city;
    private String province;
    private String country;
    private String language;
    private String mobile;
    private String latitude;
    private String longitude;
    private String speed;
    private String accuracy;
    private String altitude;
    private String verticalAccuracy;
    private String horizontalAccuracy;
    private String unionId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getVerticalAccuracy() {
        return verticalAccuracy;
    }

    public void setVerticalAccuracy(String verticalAccuracy) {
        this.verticalAccuracy = verticalAccuracy;
    }

    public String getHorizontalAccuracy() {
        return horizontalAccuracy;
    }

    public void setHorizontalAccuracy(String horizontalAccuracy) {
        this.horizontalAccuracy = horizontalAccuracy;
    }
}

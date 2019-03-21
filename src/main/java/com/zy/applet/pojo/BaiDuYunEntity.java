package com.zy.applet.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: zy
 * @Date: 2019/3/19 14:43
 * @Version 1.0
 * @Description
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "t_baiduyun_link")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Api(value = "百度云", description = "百度云")
public class BaiDuYunEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @ApiModelProperty(value = "ID", dataType = "Integer")
    Integer id;

    @ApiModelProperty(value = "文件名", dataType = "String")
    String fileName;

    @ApiModelProperty(value = "文件名类别", dataType = "enum")
    @Enumerated(EnumType.STRING)
    private FileType fileType;

    public enum FileType {
        //普通
        MYSQL,
        //vip
        JAVA
    }

    @ApiModelProperty(value = "网络地址链接", dataType = "String")
    String addressUrl;


    @ApiModelProperty(value = "提取码", dataType = "String")
    String extractPower;


    @ApiModelProperty(value = "微信小程序二维码地址", dataType = "String")
    String appletUrl;

    @ApiModelProperty(value = "创建时间", dataType = "Date")
    Date createDate;


    @ApiModelProperty(value = "修改时间", dataType = "Date")
    Date updateDate;
}

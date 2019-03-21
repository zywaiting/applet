package com.zy.applet.entitydto;

import com.zy.applet.pojo.BaiDuYunEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@FieldDefaults(level = AccessLevel.PRIVATE)
@Api(value = "百度云", description = "百度云")
public class BaiDuYunDto implements Serializable {


    @ApiModelProperty(value = "ID", dataType = "Integer")
    Integer id;

    @ApiModelProperty(value = "文件名", dataType = "String")
    String fileName;

    @ApiModelProperty(value = "文件名类别", dataType = "enum")
    @Enumerated(EnumType.STRING)
    private BaiDuYunEntity.FileType fileType;


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

    public BaiDuYunDto(BaiDuYunEntity baiDuYunEntity) {
        this.id = baiDuYunEntity.getId();
        this.addressUrl = baiDuYunEntity.getAddressUrl();
        this.appletUrl = baiDuYunEntity.getAppletUrl();
        this.createDate = baiDuYunEntity.getCreateDate();
        this.updateDate = baiDuYunEntity.getUpdateDate();
        this.extractPower = baiDuYunEntity.getExtractPower();
        this.fileName = baiDuYunEntity.getFileName();
        this.fileType = baiDuYunEntity.getFileType();
    }
}

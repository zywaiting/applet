package com.zy.applet.entitydto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * @Author: zy
 * @Date: 2019/3/7 12:54
 * @Version 1.0
 * @Description
 */
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TencentPictureDto implements Serializable {

    //返回码； 0表示成功，非0表示出错
    Integer ret;

    //返回信息；ret非0时表示出错时错误原因
    String msg;

    //返回数据；ret为0时有意义
    Data data;

    @Getter
    @Setter
    public class Data{
        //UTF-8编码，非空且长度上限32字节
        String image;
    }

}

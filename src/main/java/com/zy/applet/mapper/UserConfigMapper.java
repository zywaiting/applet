package com.zy.applet.mapper;

import com.zy.applet.pojo.AppletConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 实现用户信息
 */
@Mapper
public interface UserConfigMapper {

    //查询用户是否已经存在
    Integer selectCountUserConfigByOpenId(@Param("openId") String openId);
    //插入用户信息
    Integer insterUserConfigOfOpenId(@Param("openId") String openId,@Param("unionId") String unionId);

}

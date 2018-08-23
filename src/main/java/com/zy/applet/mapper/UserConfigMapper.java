package com.zy.applet.mapper;

import com.zy.applet.pojo.AppletConfig;
import com.zy.applet.pojo.UserConfig;
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
    Integer insterUserConfig(UserConfig userConfig);
    //补全用户信息
    Integer updateUserConfigByOpenId(UserConfig userConfig);
    //查询用户信息
    UserConfig selectByOpenId(@Param("openId") String openId);

}

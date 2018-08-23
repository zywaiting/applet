package com.zy.applet.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AppletConfigMapper {
    //定时修改acessToken
    Integer insterAccessToken(@Param("acessToken") String acessToken, @Param("appid") String appid);
}

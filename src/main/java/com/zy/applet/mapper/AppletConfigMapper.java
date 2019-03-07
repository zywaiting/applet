package com.zy.applet.mapper;

import com.zy.applet.pojo.AppletConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AppletConfigMapper {
    //定时修改acessToken
    Integer updateAccessToken(@Param("acessToken") String acessToken, @Param("appid") String appid);

    AppletConfig findByExpress(String tencent);
}

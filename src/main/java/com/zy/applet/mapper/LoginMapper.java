package com.zy.applet.mapper;

import com.zy.applet.pojo.AppletConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 实现用户登录
 */
@Mapper
public interface LoginMapper {

    //查询小程序的详细信息
    AppletConfig selectAppletConfig(@Param("express") String express);
}

package com.zy.applet.mapper;

import com.zy.applet.pojo.AppletUrl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * zy  2018-8-1
 * 查询appletUrl 路径
 */
@Mapper
public interface AppletUrlMapper {
    //查询用户记录
    AppletUrl selectAppletUrl(@Param("name") String name);
}

package com.zy.applet.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GetFromIdMapper {
    //保存fromid
    Integer insterFromId(@Param("fromId") String fromId, @Param("openId") String openId,@Param("number") Integer number);
    //查询当前最大number
    Integer selectNumberByOpenId(@Param("openId") String openId);
}

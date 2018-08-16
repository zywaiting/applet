package com.zy.applet.mapper;

import com.zy.applet.pojo.Travel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TravelMapper {
    //查询城市的旅游信息
    List<Travel> findListTravel(@Param("crity") String crity);
}

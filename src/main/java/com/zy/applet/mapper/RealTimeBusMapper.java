package com.zy.applet.mapper;

import com.zy.applet.pojo.BusConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RealTimeBusMapper {

    Integer inster(@Param("post")String post);

    String select();

    //查询车辆id
    List<BusConfig> selectBusConfigByCrityAndBusName(@Param("crity") String crity, @Param("busName") String busName);
}

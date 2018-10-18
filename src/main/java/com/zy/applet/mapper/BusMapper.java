package com.zy.applet.mapper;

import com.zy.applet.pojo.BusConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BusMapper {

    //查询车辆信息
    List<BusConfig> selectBusConfigByLikeBusName(@Param("busName") String busName,@Param("crity") String crity);

    //查询车辆信息
    BusConfig selectBusConfigByBusId(@Param("busId") String busId,@Param("crity") String crity);
}

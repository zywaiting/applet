package com.zy.applet.mapper;

import com.zy.applet.pojo.ExpressContent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderExpressMapper {

    //查询快递记录
    ExpressContent selectExpressContentByExpressNo(@Param("opneid") String opneid,@Param("expressNo") String expressNo);

    //更新快递记录
    Integer updateExpressContentByExpressNo(ExpressContent expressContent);

    //插入一条快递记录
    Integer insterExpressContent(ExpressContent expressContent);
}

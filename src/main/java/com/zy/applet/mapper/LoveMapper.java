package com.zy.applet.mapper;

import com.zy.applet.pojo.LovePage;
import com.zy.applet.pojo.LovePageContext;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 查找love
 */
@Mapper
public interface LoveMapper {
    //查找页面
    LovePage selectLovePageByExpress(@Param("express") String express);
    //查询信息
    LovePageContext selectLovePageContextByCon3(@Param("con3") String con3);
    //插入一条记录
    Integer insterLovePageContext(LovePageContext lovePageContext);
}

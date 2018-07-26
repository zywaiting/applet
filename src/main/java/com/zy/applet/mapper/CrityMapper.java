package com.zy.applet.mapper;

import com.zy.applet.pojo.Crity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 查询城市接口
 * Created by zy on 04/05/2018.
 */
@Mapper
public interface CrityMapper {
    /**
     * 查询城市接口
     * @return
     */
    List<Crity> findCrity();
    //查询城市简介
    List<String> findCityInfo(@Param("crity") String crity);
    //查询城市主图片
    List<String> findCityMainPicture(@Param("crity") String crity);
    //查询城市生活
    List<String> findCrityLife(@Param("crity") String crity);


}



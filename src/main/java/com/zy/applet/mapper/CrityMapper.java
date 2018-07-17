package com.zy.applet.mapper;

import com.zy.applet.pojo.Crity;
import org.apache.ibatis.annotations.Mapper;

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
}
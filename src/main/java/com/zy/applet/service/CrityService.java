package com.zy.applet.service;


import com.zy.applet.pojo.Crity;
import com.zy.applet.pojo.Joke;

import java.util.List;

/**
 * 城市接口
 * Created by zy on 04/05/2018.
 */
public interface CrityService {
    /**
     * 查询城市
     * @return
     */
    List<Crity> findCrity();
    //查询城市简介
    List<String> findCityInfo(String crity);
    //查询城市主图片
    List<String> findCityMainPicture(String crity);
}

package com.zy.applet.service.impl;

import com.zy.applet.mapper.CrityMapper;
import com.zy.applet.mapper.JokeMapper;
import com.zy.applet.pojo.Crity;
import com.zy.applet.pojo.Joke;
import com.zy.applet.service.CrityService;
import com.zy.applet.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 查询城市接口实现
 * Created by zy on 04/05/2018.
 */
@Service
public class CrityServiceImpl implements CrityService {

    @Autowired
    private CrityMapper crityMapper;

    @Override
    public List<Crity> findCrity() {
        return crityMapper.findCrity();
    }

    @Override
    public List<String> findCityInfo(String crity) {
        return crityMapper.findCityInfo(crity);
    }

    @Override
    public List<String> findCityMainPicture(String crity) {
        return crityMapper.findCityMainPicture(crity);
    }

    @Override
    public List<String> findCrityLife(String crity) {
        return crityMapper.findCrityLife(crity);
    }
}

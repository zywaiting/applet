package com.zy.applet.service.impl;

import com.zy.applet.mapper.TravelMapper;
import com.zy.applet.pojo.Travel;
import com.zy.applet.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelServiceImpl implements TravelService {

    @Autowired
    private TravelMapper travelMapper;

    @Override
    public List<Travel> findListTravel(String crity) {
        return travelMapper.findListTravel(crity);
    }
}

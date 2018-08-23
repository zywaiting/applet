package com.zy.applet.service.impl;

import com.zy.applet.mapper.GetFromIdMapper;
import com.zy.applet.service.GetFromIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetFromIdServiceImpl implements GetFromIdService {

    @Autowired
    private GetFromIdMapper getFromIdMapper;

    @Override
    public Integer insterFromId(String fromId, String openId,Integer number) {
        return getFromIdMapper.insterFromId(fromId,openId,number);
    }

    @Override
    public Integer selectNumberByOpenId(String openId) {
        return getFromIdMapper.selectNumberByOpenId(openId);
    }
}

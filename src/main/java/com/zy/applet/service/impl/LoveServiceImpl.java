package com.zy.applet.service.impl;

import com.zy.applet.mapper.LoveMapper;
import com.zy.applet.pojo.LovePage;
import com.zy.applet.pojo.LovePageContext;
import com.zy.applet.service.LoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoveServiceImpl implements LoveService {

    @Autowired
    private LoveMapper loveMapper;

    @Override
    public LovePage selectLovePageByExpress(String express) {
        return loveMapper.selectLovePageByExpress(express);
    }

    @Override
    public LovePageContext selectLovePageContextByCon3(String con3) {
        return loveMapper.selectLovePageContextByCon3(con3);
    }

    @Override
    public Integer insterLovePageContext(LovePageContext lovePageContext) {
        return loveMapper.insterLovePageContext(lovePageContext);
    }
}

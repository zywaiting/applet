package com.zy.applet.service.impl;

import com.zy.applet.mapper.LoveMapper;
import com.zy.applet.pojo.LoveIndexStyle;
import com.zy.applet.pojo.LovePage;
import com.zy.applet.pojo.LovePageContext;
import com.zy.applet.service.LoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoveServiceImpl implements LoveService {

    @Autowired
    private LoveMapper loveMapper;

    @Override
    public LovePage selectLovePageByExpress(String express) {
        return loveMapper.selectLovePageByExpress(express);
    }

    @Override
    public LovePageContext selectLovePageContextByMark(String mark) {
        return loveMapper.selectLovePageContextByMark(mark);
    }

    @Override
    public Integer insterLovePageContext(LovePageContext lovePageContext) {
        return loveMapper.insterLovePageContext(lovePageContext);
    }

    @Override
    public List<LoveIndexStyle> selectLoveIndexStyle(String express) {
        return loveMapper.selectLoveIndexStyle(express);
    }
}

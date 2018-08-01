package com.zy.applet.service.impl;

import com.zy.applet.mapper.AppletUrlMapper;
import com.zy.applet.pojo.AppletUrl;
import com.zy.applet.service.AppletUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * zy  2018-8-1
 * 实现查询appletUrl
 */
@Service
public class AppletUrlServiceImpl implements AppletUrlService {
    @Autowired
    private AppletUrlMapper appletUrlMapper;

    @Override
    public AppletUrl selectAppletUrl(String appUrl) {
        return appletUrlMapper.selectAppletUrl(appUrl);
    }
}

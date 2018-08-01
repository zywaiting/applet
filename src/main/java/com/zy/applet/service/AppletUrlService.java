package com.zy.applet.service;

import com.zy.applet.pojo.AppletUrl;

/**
 * 查询appletUrl
 */
public interface AppletUrlService {
    //查询appletUrl
    AppletUrl selectAppletUrl(String name);
}

package com.zy.applet.service;

import com.zy.applet.pojo.LovePage;
import com.zy.applet.pojo.LovePageContext;

public interface LoveService {
    //查找页面
    LovePage selectLovePageByExpress(String express);
    //查询信息
    LovePageContext selectLovePageContextByCon3(String con3);
    //插入一条记录
    Integer insterLovePageContext(LovePageContext lovePageContext);
}

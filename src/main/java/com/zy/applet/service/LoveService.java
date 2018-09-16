package com.zy.applet.service;

import com.zy.applet.pojo.LoveIndexStyle;
import com.zy.applet.pojo.LovePage;
import com.zy.applet.pojo.LovePageContext;

import java.util.List;

public interface LoveService {
    //查找页面
    LovePage selectLovePageByExpress(String express);
    //查询信息
    LovePageContext selectLovePageContextByMark(String mark);
    //插入一条记录
    Integer insterLovePageContext(LovePageContext lovePageContext);
    //查询index样式
    List<LoveIndexStyle> selectLoveIndexStyle(String express);
}

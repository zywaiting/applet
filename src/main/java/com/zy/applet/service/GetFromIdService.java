package com.zy.applet.service;

/**
 * 获取用户的fromid
 */
public interface GetFromIdService {
    //保存fromid
    Integer insterFromId(String fromId,String openId,Integer number);
    //查询当前最大number
    Integer selectNumberByOpenId(String openId);
}

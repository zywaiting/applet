package com.zy.applet.service;

import com.zy.applet.pojo.UserCard;

/**
 * @author zy
 * 用户名片
 * 2018-8-23
 */
public interface UserCardService {
    //查询用户名片
    UserCard selectUserCard(String openId);
    //生成用户名片
    Integer createUserCard(UserCard userCard);
}

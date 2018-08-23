package com.zy.applet.mapper;

import com.zy.applet.pojo.UserCard;
import com.zy.applet.service.UserCardService;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserCardMapper {
    //查询用户名片
    UserCard selectUserCard(String openId);
    //生成用户名片
    Integer createUserCard(UserCard userCard);
}

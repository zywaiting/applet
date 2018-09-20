package com.zy.applet.mapper;

import com.zy.applet.pojo.UserAddress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserAddressMapper {

    //查询用户
    List<UserAddress> selectUserAddressByOpenid(@Param("openid") String openid,@Param("isDefault") String isDefault);

    //插入用户地址
    Integer insterUserAddress(UserAddress userAddress);
}

package com.zy.applet.service;


import com.zy.applet.pojo.UserAddress;

import java.util.List;

public interface UserAddressService {

    //查询用户
    List<UserAddress> selectUserAddressByOpenid(String openid,String isDefault);

}

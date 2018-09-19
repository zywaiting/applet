package com.zy.applet.service.impl;

import com.zy.applet.mapper.UserAddressMapper;
import com.zy.applet.pojo.UserAddress;
import com.zy.applet.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressServiceImpl implements UserAddressService {
    @Autowired
    private UserAddressMapper userAddressMapper;


    @Override
    public List<UserAddress> selectUserAddressByOpenid(String openid,String isDefault) {
        return userAddressMapper.selectUserAddressByOpenid(openid,isDefault);
    }
}


package com.zy.applet.controller.garden;

import com.zy.applet.pojo.UserAddress;
import com.zy.applet.service.UserAddressService;
import com.zy.applet.utils.ResponseMessageUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserAddressController {

    @Autowired
    private UserAddressService userAddressService;

    @RequestMapping("address")
    @ApiOperation(value = "用户地址")
    public ResponseMessageUtils selectAddressList(String openid) {
        Map map = new HashMap();
        List<UserAddress> userAddressesIsDefault = userAddressService.selectUserAddressByOpenid(openid,"1");
        List<UserAddress> userAddressesNoDefault = userAddressService.selectUserAddressByOpenid(openid,"0");
        map.put("userAddressesIsDefault",userAddressesIsDefault);
        map.put("userAddressesNoDefault",userAddressesNoDefault);
        return ResponseMessageUtils.ok(map);
    }

    @RequestMapping("addAddress")
    @ApiOperation(value = "用户地址")
    public ResponseMessageUtils addAddress(String openid,String username,String address,String phone) {
        UserAddress userAddress = new UserAddress();
        userAddress.setOpenid(openid);
        userAddress.setName(username);
        userAddress.setAddress(address);
        userAddress.setPhone(phone);
        userAddress.setAddressFlag(1);
        userAddress.setIsDefault(0);
        userAddress.setUpdateDate(new Date());
        userAddress.setCreateDate(new Date());
        userAddressService.insterUserAddress(userAddress);
        return ResponseMessageUtils.ok();
    }
}

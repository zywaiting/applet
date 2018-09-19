package com.zy.applet.controller.garden;

import com.zy.applet.pojo.UserAddress;
import com.zy.applet.service.UserAddressService;
import com.zy.applet.utils.ResponseMessageUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserAddressController {

    @Autowired
    private UserAddressService userAddressService;

    @RequestMapping("address")
    @ApiOperation(value = "商品订单")
    public ResponseMessageUtils selectOrderList(String openid) {
        Map map = new HashMap();
        List<UserAddress> userAddressesIsDefault = userAddressService.selectUserAddressByOpenid(openid,"1");
        List<UserAddress> userAddressesNoDefault = userAddressService.selectUserAddressByOpenid(openid,"0");
        map.put("userAddressesIsDefault",userAddressesIsDefault);
        map.put("userAddressesNoDefault",userAddressesNoDefault);
        return ResponseMessageUtils.ok(map);
    }
}

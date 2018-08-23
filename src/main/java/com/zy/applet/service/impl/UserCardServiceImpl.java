package com.zy.applet.service.impl;

import com.zy.applet.controller.UserCardController;
import com.zy.applet.mapper.UserCardMapper;
import com.zy.applet.pojo.UserCard;
import com.zy.applet.service.UserCardService;
import com.zy.applet.service.UserConfigService;
import com.zy.applet.utils.ByteToInputStreamUtils;
import com.zy.applet.utils.CreateCodeUtils;
import com.zy.applet.utils.OssUploadFileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.util.UUID;

@Service
public class UserCardServiceImpl implements UserCardService {
    private final static Logger logger = LoggerFactory.getLogger(UserCardServiceImpl.class);

    @Autowired
    private UserCardMapper userCardMapper;
    @Autowired
    private UserConfigService userConfigService;

    @Override
    public UserCard selectUserCard(String openId) {
        return userCardMapper.selectUserCard(openId);
    }

    @Override
    public Integer createUserCard(UserCard userCard) {

        String avatarUrl = userConfigService.selectByOpenId(userCard.getOpenId()).getAvatarUrl();
        String qrUrl = "BEGIN:VCARD\n" +
                "N:" + userCard.getName() + "\n" +
                "TEL;TYPE=WORK:" + userCard.getMobile() + "\n" +
                "EMAIL:" + userCard.getEmail() + "\n" +
                "NOTE:" + userCard.getQq() + "\n" +
                "ORG:" + userCard.getCompany() + "\n" +
                "TIL:" + userCard.getTil() + "\n" +
                "ADR:" + userCard.getAdr() + "\n" +
                "END:VCARD";
        if (StringUtils.isNotBlank(avatarUrl)){
            ByteArrayInputStream byteArrayInputStream = CreateCodeUtils.drawLogoQRCode(avatarUrl, qrUrl);
            try {
                String imageUrl = OssUploadFileUtils.OssUploadFileInputStreamtest("wq-zy", "applet/recording/" + userCard.getOpenId() + "/" + UUID.randomUUID() + ".png", byteArrayInputStream);
                userCard.setImageUrl(imageUrl);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }else {
            ByteArrayInputStream byteArrayInputStream = CreateCodeUtils.drawLogoQRCode("https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKBcD51SvG3DSiaR0nxFibibkLkrShdXo6Vz1pdsADuMMLC49vn4xvZlczZmoNVQyS3ORp1EUSBO6gLQ/132", qrUrl);
            try {
                String imageUrl = OssUploadFileUtils.OssUploadFileInputStreamtest("wq-zy", "applet/recording/" + userCard.getOpenId() + "/" + UUID.randomUUID() + ".png", byteArrayInputStream);
                userCard.setImageUrl(imageUrl);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return userCardMapper.createUserCard(userCard);
    }

    public static void main(String[] args) {
        String qrUrl = "BEGIN:VCARD\n" +
                "N:朱瑶\n" +
                "TEL;TYPE=WORK:17605674666\n" +
                "TEL;TYPE=CELL:18110981995\n" +
                "EMAIL:1573240324@qq.com\n" +
                "NOTE:1573240324\n" +
                "ORG:慧赢联\n" +
                "URL:http://www.baidu.com\n" +
                "TIL:java开发\n" +
                "ADR:夏家桥\n" +
                "END:VCARD";

        ByteArrayInputStream byteArrayInputStream = CreateCodeUtils.drawLogoQRCode("https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKBcD51SvG3DSiaR0nxFibibkLkrShdXo6Vz1pdsADuMMLC49vn4xvZlczZmoNVQyS3ORp1EUSBO6gLQ/132", qrUrl);
        try {
            String fileName = OssUploadFileUtils.OssUploadFileInputStreamtest("wq-zy", "applet/recording/" + "test" + "/" + UUID.randomUUID() + ".png", byteArrayInputStream);
            System.out.println(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

package com.zy.applet.controller.word;

import com.zy.applet.pojo.UserCard;
import com.zy.applet.service.UserCardService;
import com.zy.applet.utils.ResponseMessageUtils;
import com.zy.applet.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zy
 * 用户名片接口
 * 2018-8-23
 */
@RestController
public class UserCardController {
    private final static Logger logger = LoggerFactory.getLogger(UserCardController.class);

    @Autowired
    private UserCardService userCardService;

    @RequestMapping(value = "api/selectusercard")
    public ResponseMessageUtils selectUserCard(String openId) {
        logger.info("调用了查询名片接口---------------api/selectusercard");
        UserCard userCard = userCardService.selectUserCard(openId);
        if (userCard!=null){
            return ResponseMessageUtils.ok(userCard);
        }else {
            return ResponseMessageUtils.error("");
        }
    }

    @RequestMapping(value = "api/createusercard")
    public ResponseMessageUtils createUserCard(HttpServletRequest request, HttpServletResponse response, @RequestParam("openId") String openId) {
        logger.info("生成名片接口---------------api/selectusercard");
        String userCardStr = request.getParameter("data");
        UserCard userCard = Utils.json(userCardStr, UserCard.class);
        userCard.setOpenId(openId);

        logger.info(userCard.getOpenId());
        logger.info(userCard.getAdr());
        Integer integer = userCardService.createUserCard(userCard);
        if (integer > 0) {
            UserCard selectUserCard = userCardService.selectUserCard(userCard.getOpenId());
            return ResponseMessageUtils.ok(selectUserCard);
        } else {
            return ResponseMessageUtils.error("插入失败");
        }
    }
}

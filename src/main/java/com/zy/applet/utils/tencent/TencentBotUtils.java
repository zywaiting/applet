package com.zy.applet.utils.tencent;

import com.zy.applet.pojo.TencentBotReturn;
import com.zy.applet.utils.HttpUtils;
import com.zy.applet.utils.SortUtils;
import com.zy.applet.utils.Utils;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/**
 * @Author: zy
 * @Date: 2019/3/7 12:52
 * @Version 1.0
 * @Description
 */
public class TencentBotUtils {

    private static final String URL = "http://localhost:8888/tencent/bot";

    public static TencentBotReturn tencentBot(String boot, String session, String question) {
        HashMap<String, String> hashMapParams = new HashMap<>();
        hashMapParams.put("boot", boot);
        hashMapParams.put("session", DigestUtils.md5Hex(session));
        hashMapParams.put("question", question);
        String postReturn = HttpUtils.post(URL, hashMapParams);
        return Utils.json(postReturn, TencentBotReturn.class);
    }


}

package com.zy.applet.utils.baiduUtils;

import com.zy.applet.pojo.AppletConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLEncoder;
import java.util.UUID;

/**
 * 语音合成
 * @author zy
 * 2018-8-26
 */
public class BaiDuAsrUtils {
    private final static Logger logger = LoggerFactory.getLogger(BaiDuAsrUtils.class);
    private static final String URL = "https://tsn.baidu.com/text2audio";

    //https://tsn.baidu.com/text2audio?tex=***&lan=zh&cuid=***&ctp=1&tok=***
    public static String baiDuRestUtils(AppletConfig appletConfig,String text,String per){
        String tex = URLEncoder.encode(URLEncoder.encode(text));
        return URL + "?tex=" + tex + "&lan=zh&cuid=" + UUID.randomUUID() + "&ctp=1&tok=" + appletConfig.getAccessToken() + "&per=" + per;
    }

    public static void main(String[] args) {
        AppletConfig appletConfig = new AppletConfig();
        appletConfig.setAccessToken("24.917d46f09194aad70aefa5e7108521fd.2592000.1537931791.282335-11635960");
        String baiDuRestUtils = BaiDuAsrUtils.baiDuRestUtils(appletConfig,"主人,请问有什么可以帮助您!比如对我说\"笑话\"","0");
        System.out.println(baiDuRestUtils);
    }
}

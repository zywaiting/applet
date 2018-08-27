package com.zy.applet.test;

import com.aliyun.oss.common.utils.HttpUtil;
import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;
import com.zy.applet.utils.HttpUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public class AipSpeechSample {

    public static void main(String[] args) {
        String encode = URLEncoder.encode(URLEncoder.encode("百度你好"));
        System.out.println(encode);
    }


    //设置APPID/AK/SK
    public static final String APP_ID = "11635960";
    public static final String API_KEY = "S4VRuPQQYq2GzoyNGXjmzRkQ";
    public static final String SECRET_KEY = "PqjKKsUzMRo0Lr7amWUsfhYxuCpgXrv4";

//    public static void main(String[] args) {
//        // 初始化一个AipSpeech
//        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
//
//        // 可选：设置网络连接参数
//        client.setConnectionTimeoutInMillis(2000);
//        client.setSocketTimeoutInMillis(60000);
//
//        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        //client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        //client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理
//
//        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
//        // 也可以直接通过jvm启动参数设置此环境变量
//        //System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");
//
//        // 调用接口
//        TtsResponse res = client.synthesis("你好百度", "zh", 1, null);
//        byte[] data = res.getData();
//        JSONObject res1 = res.getResult();
//        if (data != null) {
//            try {
//                Util.writeBytesToFileSystem(data, "output.mp3");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        if (res1 != null) {
//            System.out.println(res1.toString(2));
//        }
//
//    }
}

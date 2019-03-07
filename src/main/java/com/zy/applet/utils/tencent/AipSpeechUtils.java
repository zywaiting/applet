package com.zy.applet.utils.tencent;

import com.baidu.aip.speech.AipSpeech;
import org.json.JSONObject;

/**
 * 百度语音识别60秒
 */
public class AipSpeechUtils {

    //设置APPID/AK/SK
    public static final String APP_ID = "11635960";
    public static final String API_KEY = "S4VRuPQQYq2GzoyNGXjmzRkQ";
    public static final String SECRET_KEY = "PqjKKsUzMRo0Lr7amWUsfhYxuCpgXrv4";

    public static void main(String[] args) {
        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 调用接口
        JSONObject res = client.asr("D:\\test1.pcm", "pcm", 16000, null);
        System.out.println(res.toString(2));

    }
}

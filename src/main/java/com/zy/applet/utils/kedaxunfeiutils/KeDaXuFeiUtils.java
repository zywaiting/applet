package com.zy.applet.utils.kedaxunfeiutils;

import com.alibaba.fastjson.JSONObject;
import com.zy.applet.utils.Mp3ConcertPcmUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import xin.zhuyao.httputil.HttpUtils;
import xin.zhuyao.httputil.Utils;

import javax.sound.sampled.AudioInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class KeDaXuFeiUtils {



    private static final String APPID = "5c815708";
    private static final String APIKey = "5d26a4ba11728c9bf0b86ef58735c7d6";
    private static final String URL = "http://api.xfyun.cn/v1/service/v1/iat";

    /**
     * X-Appid	string	讯飞开放平台注册申请应用的应用ID(appid)	是
     * X-CurTime	string	当前UTC时间戳，从1970年1月1日0点0 分0 秒开始到现在的秒数	是
     * X-Param	string	相关参数JSON串经Base64编码后的字符串，见各接口详细说明	是
     * X-CheckSum	string	令牌，计算方法：MD5(apiKey + curTime + param)，三个值拼接的字符串，进行MD5哈希计算（32位小写），其中apiKey由讯飞提供，调用方管理。	是
     */
    public static Result speechRecognizer(String urlStr) {

        try {
            URL url = new URL(urlStr);
            InputStream is = url.openStream();
            AudioInputStream pcmAudioInputStream = Mp3ConcertPcmUtils.getPcmAudioInputStream(is);

            Map map = new LinkedHashMap();
            map.put("engine_type", "sms16k");
            map.put("aue", "raw");
            JSONObject json =new JSONObject(map);
            String param = new String(Base64.encodeBase64(json.toString().getBytes("UTF-8")));
            String curTime = System.currentTimeMillis() / 1000L + "";
            String checkSum = DigestUtils.md5Hex(APIKey + curTime + param);

            Map heads = new HashMap();
            heads.put("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            heads.put("X-Appid", APPID);
            heads.put("X-CurTime",curTime);
            heads.put("X-Param",param);
            heads.put("X-CheckSum",checkSum);

            Map paramMap = new HashMap();
            paramMap.put("audio",fileToBase64(pcmAudioInputStream));

            String resultStr = HttpUtils.postHeader(URL, "UTF-8", heads, paramMap);
            Result result = Utils.json(resultStr, Result.class);
            return result;
        }catch (Exception e){

            return null;
        }
    }




    /**
     * 功能说明：将流转base64字符串
     * @author zy
     * @date 2018年10月22日 下午3:51:20
     * @param pcmAudioInputStream 文件路径
     * @return
     */
    public static String fileToBase64(AudioInputStream pcmAudioInputStream) throws Exception {
        byte[] audioByteArray = IOUtils.toByteArray(pcmAudioInputStream);
        String audioBase64 = new String(Base64.encodeBase64(audioByteArray), "UTF-8");
        return audioBase64;
    }

    public static void main(String[] args) throws Exception {

        Result result = speechRecognizer("http://wq-zy.oss-cn-hangzhou.aliyuncs.com/tencentBot/mp3/5c94047a67654a2f82cd581126124126.mp3");

        System.out.println(result.getData());
    }

    /**
     * {"code":"0","data":"公开发出来红包咯。","desc":"success","sid":"zat00077c97@ch02100f28d248477500"}
     */



    public static class Result{
        private String code;
        private String data;
        private String desc;
        private String sid;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }
    }
}

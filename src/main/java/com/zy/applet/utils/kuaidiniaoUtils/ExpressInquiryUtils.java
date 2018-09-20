package com.zy.applet.utils.kuaidiniaoUtils;

import com.zy.applet.pojo.AppletConfig;
import com.zy.applet.pojo.KeyValue;
import com.zy.applet.utils.HttpUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.nutz.lang.Encoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Base64;

/**
 * 快递鸟查询
 */
public class ExpressInquiryUtils {
    private final static Logger logger = LoggerFactory.getLogger(ExpressInquiryUtils.class);
    private static final String URL = "http://api.kdniao.cc/Ebusiness/EbusinessOrderHandle.aspx";

    public static String expressInquiryUtils(AppletConfig appletConfig, String orderCode, String shipperCode, String logisticCode){


//string PostStr = "RequestType=1002&EBusinessID= userID &RequestData=jsonStr
//&DataSign= datasign&DataType=DataType";

        try {
            String requestData = "{\"OrderCode\": \"" + orderCode + "\",\"ShipperCode\": \"" + shipperCode + "\",\"LogisticCode\": \"" + logisticCode + "\"}";

            String md5Hex = DigestUtils.md5Hex(requestData + appletConfig.getApiKey());
            byte[] bytes = md5Hex.getBytes("UTF-8");

            String dataSign = Base64.getEncoder().encodeToString(bytes);
            KeyValue[] keyValues = new KeyValue[]{
                new KeyValue("RequestType","1002"),
                new KeyValue("EBusinessID",appletConfig.getAppId()),
                new KeyValue("RequestData",requestData),
                new KeyValue("DataSign",dataSign),
                new KeyValue("DataType","2")
            };

            String post = HttpUtils.post(URL, keyValues);
            System.out.println(post);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }


    public static void main(String[] args) {
        AppletConfig appletConfig = new AppletConfig();
        appletConfig.setAppId("1384226");
        appletConfig.setApiKey("9a3fbff7-e08f-4fa6-b7fb-0cabf4a9ec53");
        expressInquiryUtils(appletConfig,"123456789","STO","3376411097451");
    }

}

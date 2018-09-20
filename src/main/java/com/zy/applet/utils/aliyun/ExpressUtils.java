package com.zy.applet.utils.aliyun;

import com.zy.applet.pojo.AppletConfig;
import com.zy.applet.pojo.KeyValue;
import com.zy.applet.utils.HttpUtils;
import com.zy.applet.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 阿里云快递查询
 */
public class ExpressUtils {


    private final static Logger logger = LoggerFactory.getLogger(ExpressUtils.class);

    private static final String URL = "https://goexpress.market.alicloudapi.com/goexpress";

    public static String expressUtils(AppletConfig appletConfig,String no, String type){
        try {
            KeyValue[] headers = new KeyValue[]{
                    new KeyValue("Authorization","APPCODE "+ appletConfig.getAccessToken())
            };
            KeyValue[] keyValues = new KeyValue[]{
                    new KeyValue("no",no),
                    new KeyValue("type",type)
            };
            String resultStr = HttpUtils.getHeader(URL, headers, keyValues);
            return resultStr;
        }catch (Exception e){
            return "";
        }

    }


    public static void main(String[] args) {

      AppletConfig appletConfig = new AppletConfig();
      appletConfig.setAccessToken("9938a15fb02141daa68f9b6405376187");
      expressUtils(appletConfig,"801634501300121508","");
    }

    /**
     * {"code":"OK",
     * "no":"3376411097451",
     * "type":"STO",
     * "list":[
     *        {"content":"安徽砀山公司-已发往-安徽蚌埠转运中心","time":"2018-09-19 17:31:19"},
     *    {"content":"安徽砀山公司-已进行装车扫描","time":"2018-09-19 17:31:19"},
     *    {"content":"安徽砀山公司-良梨罐头-已收件","time":"2018-09-19 17:29:54"}
     * ],
     * "state":"2",
     * "msg":"查询成功",
     * "name":"申通快递",
     * "site":"www.sto.cn",
     * "phone":"95543",
     * "logo":"http://img3.fegine.com/express/sto.jpg"
     * }
     */

//    public static void main(String[] args) {
//        String json = "{\"code\":\"OK\",\n" +
//                "\"no\":\"3376411097451\",\n" +
//                "\"type\":\"STO\",\n" +
//                "\"list\":[\n" +
//                "\t{\"content\":\"安徽砀山公司-已发往-安徽蚌埠转运中心\",\"time\":\"2018-09-19 17:31:19\"},\n" +
//                "\t{\"content\":\"安徽砀山公司-已进行装车扫描\",\"time\":\"2018-09-19 17:31:19\"},\n" +
//                "\t{\"content\":\"安徽砀山公司-良梨罐头-已收件\",\"time\":\"2018-09-19 17:29:54\"}\n" +
//                "],\n" +
//                "\"state\":\"2\",\n" +
//                "\"msg\":\"查询成功\",\n" +
//                "\"name\":\"申通快递\",\n" +
//                "\"site\":\"www.sto.cn\",\n" +
//                "\"phone\":\"95543\",\n" +
//                "\"logo\":\"http://img3.fegine.com/express/sto.jpg\"\n" +
//                "}";
//
//        Result json1 = Utils.json(json, Result.class);
//        System.out.println(json1.getCode());
//    }


    public static class Result{
        private String code;
        private String no;
        private String type;
        private List<Conetent> list;
        private Integer state;
        private String msg;
        private String name;
        private String site;
        private String phone;
        private String logo;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<Conetent> getList() {
            return list;
        }

        public void setList(List<Conetent> list) {
            this.list = list;
        }

        public Integer getState() {
            return state;
        }

        public void setState(Integer state) {
            this.state = state;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }
    }

    public static class Conetent{
        private String content;
        private String time;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }


}


package com.zy.applet.utils;

import ai.olami.cloudService.*;
import ai.olami.nli.NLIResult;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zy.applet.wxchat.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.List;

//语音识别
public class OlamiUtils {

    private final static Logger logger = LoggerFactory.getLogger(OlamiUtils.class);

    // * Replace your APP KEY
    private static String appKey = "65ac1c2b770a4cc08c21a9ef1fca50b5";
    // * Replace your APP SECRET
    private static String appSecret = "eec4076b2f2a4d2dbeb0bec46eef8aa2";


    // pcm AUDIO_TYPE_PCM_RAW   wav AUDIO_TYPE_PCM_WAVE
    private static int audioType = SpeechRecognizer.AUDIO_TYPE_PCM_RAW;

    // * Replace FALSE with this variable if your test file is not final audio.
    private static boolean isTheLastAudio = true;

    // * Replace the localize option you want with this variable.
    // * - Use LOCALIZE_OPTION_SIMPLIFIED_CHINESE for China
    // * - Use LOCALIZE_OPTION_TRADITIONAL_CHINESE for Taiwan
    private static int localizeOption = APIConfiguration.LOCALIZE_OPTION_SIMPLIFIED_CHINESE;

    //网络路径
    public static String speechInput(String url) {
        try {
            InputStream inputStream = new URL(url).openStream();
            byte[] audioBuffer = new byte[0];
            audioBuffer = ByteToInputStreamUtils.input2byte(inputStream);
            // * Step 1: Configure your key and localize option.
            APIConfiguration config = new APIConfiguration(appKey, appSecret, localizeOption);

            // * Step 2: Create the text recognizer.
            SpeechRecognizer recoginzer = new SpeechRecognizer(config);

            // * Optional steps: Setup some other configurations.
            recoginzer.setEndUserIdentifier("Someone");
            recoginzer.setTimeout(10000);

            // * Prepare to send audio by a new task identifier.
            CookieSet cookie = new CookieSet();
            APIResponse response = recoginzer.uploadAudio(cookie, audioBuffer, audioType, isTheLastAudio);

            // Check request status.
            if (response.ok()) {
                while (true) {
                    Thread.sleep(500);
                    response = recoginzer.requestRecognitionWithAll(cookie);

                    // Check request status.
                    if (response.ok() && response.hasData()) {
                        // * Check to see if the recognition has been completed.
                        SpeechResult sttResult = response.getData().getSpeechResult();
                        if (sttResult.complete()) {
                            logger.info("* STT Result:{}", sttResult.getResult());
                            return response.toString();
//                    } else {
//                        // The recognition is still in progress.
//                        // But we can still get immediate recognition results.
//                        logger.info("* STT Result [Not yet completed] ");
//                        logger.info(" -->:{}" , sttResult.getResult());
                        }
                    }
                }
            } else {
                // Error
                logger.info("* Error! Code:{}", response.getErrorCode());
                logger.info(response.getErrorMessage());
                return response.toString();
            }
        } catch (Exception e) {
            logger.warn("speechInput解析异常:{}",e.getMessage());
            e.printStackTrace();
            return "speechInput解析异常";
        }
    }


    //流
    public static Result speechInput(InputStream inputStream) {
        try {
            byte[] audioBuffer = new byte[0];
            audioBuffer = ByteToInputStreamUtils.input2byte(inputStream);
            // * Step 1: Configure your key and localize option.
            APIConfiguration config = new APIConfiguration(appKey, appSecret, localizeOption);

            // * Step 2: Create the text recognizer.
            SpeechRecognizer recoginzer = new SpeechRecognizer(config);

            // * Optional steps: Setup some other configurations.
            recoginzer.setEndUserIdentifier("Someone");
            recoginzer.setTimeout(10000);

            // * Prepare to send audio by a new task identifier.
            CookieSet cookie = new CookieSet();
            APIResponse response = recoginzer.uploadAudio(cookie, audioBuffer, audioType, isTheLastAudio);

            // Check request status.
            if (response.ok()) {
                while (true) {
                    Thread.sleep(500);
                    response = recoginzer.requestRecognitionWithAll(cookie);

                    // Check request status.
                    if (response.ok() && response.hasData()) {
                        // * Check to see if the recognition has been completed.
                        SpeechResult sttResult = response.getData().getSpeechResult();
                        if (sttResult.complete()) {
                            logger.info("* STT Result:{}", sttResult.getResult());
                            Result result = Utils.json(response.toString(), Result.class);
                            return result;
//                    } else {
//                        // The recognition is still in progress.
//                        // But we can still get immediate recognition results.
//                        logger.info("* STT Result [Not yet completed] ");
//                        logger.info(" -->:{}" , sttResult.getResult());
                        }
                    }
                }
            } else {
                // Error
                logger.info("* Error! Code:{}", response.getErrorCode());
                logger.info(response.getErrorMessage());
                return null;
            }
        } catch (Exception e) {
            logger.warn("speechInput解析异常:{}",e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static Result textRecognizer(String text) {
        Result result = null;
        try {
            // 创建 APIConfiguration 对象
            APIConfiguration config = new APIConfiguration(appKey, appSecret, APIConfiguration.LOCALIZE_OPTION_SIMPLIFIED_CHINESE);
            // 创建文本识别器对象
            TextRecognizer recoginzer = new TextRecognizer(config);
            // 请求 "今天星期几" 的分词结果
            APIResponse response1 = recoginzer.requestWordSegmentation(text);
            // 检查请求结果
            if (response1.ok() && response1.hasData()) {
                // 取得分词结果
                String[] ws = response1.getData().getWordSegmentation();
            }
            // 请求 "今天星期几" 的 NLI 语义分析或 IDS 智能答复与数据
            APIResponse response2 = recoginzer.requestNLI(text);
            // 检查请求结果
            if (response2.ok() && response2.hasData()) {
                // 取得 NLI 语义分析或 IDS 智能答复与数据
                String toString = response2.toString();
                result = Utils.json(toString, Result.class);
            }
        }catch (Exception e){
            logger.warn("语义理解出现异常:{}",e.getMessage());
        }
        return result;
    }




    public static void main(String[] args) throws Exception {
        Result result = textRecognizer("CCTV1！");
//        String result ="{\"data\":{\"asr\":{\"result\":\"是测试测试测试\",\"requestId\":\"ffdc7a016e8111833c69e77cbdacf612\",\"speech_status\":0,\"final\":true,\"status\":0},\"seg\":\"是 测试 测试 测试 \",\"nli\":[{\"desc_obj\":{\"result\":\"对不起，你说的我还不懂，能换个说法吗？\",\"status\":1003},\"type\":\"ds\"}]},\"status\":\"ok\"}\n";
//        Result resultStr = Utils.json(result, Result.class);
//        System.out.println(resultStr.getData().getNliList().get(0).getDescObj().getResult());
//        System.out.println(resultStr.getData().getAsr().getResult());
        System.out.println(JsonUtils.toJson(result));
        System.out.println(result.getData().getNliList().get(0).getDescObj().getResult());
    }

    public static class Result{
        private Data data;
        private String status;
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public static class Data{
        private Asr asr;
        private String seg;
        @JsonProperty(value = "nli")
        private List<Nli> nliList;

        public Asr getAsr() {
            return asr;
        }

        public void setAsr(Asr asr) {
            this.asr = asr;
        }

        public String getSeg() {
            return seg;
        }

        public void setSeg(String seg) {
            this.seg = seg;
        }

        public List<Nli> getNliList() {
            return nliList;
        }

        public void setNliList(List<Nli> nliList) {
            this.nliList = nliList;
        }
    }

    public static class Asr{
        private String result;
        @JsonProperty(value = "speech_status")
        private Integer speechStatus;
        @JsonProperty(value = "final")
        private Boolean finalStr;
        private Integer status;
        private String requestId;

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public Integer getSpeechStatus() {
            return speechStatus;
        }

        public void setSpeechStatus(Integer speechStatus) {
            this.speechStatus = speechStatus;
        }

        public Boolean getFinalStr() {
            return finalStr;
        }

        public void setFinalStr(Boolean finalStr) {
            this.finalStr = finalStr;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }
    }

    public static class Nli{
        @JsonProperty(value = "desc_obj")
        private DescObj descObj;
        @JsonProperty(value = "semantic")
        private List<Semantic> semanticList;
        @JsonProperty(value = "data_obj")
        private List<DataObj> dataObjList;
        private String type;

        public DescObj getDescObj() {
            return descObj;
        }

        public void setDescObj(DescObj descObj) {
            this.descObj = descObj;
        }

        public List<Semantic> getSemanticList() {
            return semanticList;
        }

        public void setSemanticList(List<Semantic> semanticList) {
            this.semanticList = semanticList;
        }

        public List<DataObj> getDataObjList() {
            return dataObjList;
        }

        public void setDataObjList(List<DataObj> dataObjList) {
            this.dataObjList = dataObjList;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class DescObj{
        /**
         * result	String	若 status = 0：简短的智能答复文本。
         * 若 status != 0：系统异常的相应说明字符串。
         * status	Int	状态码，0：成功，其他值：表示错误代码。
         */
        private String result;
        private Integer status;
        /**
         * type	String	反提问的模块类型。
         * result	String	反提问的简短对话内容。
         * status	Int	状态码，0：成功，其他值：表示错误代码。
         */
        private String type;
        private String url;
        private String name;
        @JsonProperty(value = "source_currency")
        private String sourceCurrency;

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSourceCurrency() {
            return sourceCurrency;
        }

        public void setSourceCurrency(String sourceCurrency) {
            this.sourceCurrency = sourceCurrency;
        }
    }

    private static class Semantic{
        private String[] modifier;
        private String app;
        private String input;
        @JsonProperty(value = "slots")
        private List<Slots> slotsList;
        private String customer;

        public String[] getModifier() {
            return modifier;
        }

        public void setModifier(String[] modifier) {
            this.modifier = modifier;
        }

        public String getApp() {
            return app;
        }

        public void setApp(String app) {
            this.app = app;
        }

        public String getInput() {
            return input;
        }

        public void setInput(String input) {
            this.input = input;
        }

        public List<Slots> getSlotsList() {
            return slotsList;
        }

        public void setSlotsList(List<Slots> slotsList) {
            this.slotsList = slotsList;
        }

        public String getCustomer() {
            return customer;
        }

        public void setCustomer(String customer) {
            this.customer = customer;
        }
    }

    /**
     * name	String	slot 名称
     * value	String	slot 匹配的值
     * valid	String Array	当 slot 类型为 ext 且指定验证类别时才会出现该属性，并把验证通过的类别放在这里。详见OSL 说明文档 / slot简介 / slot 验证
     * modifier	String Array	slot modifier 数组
     * datetime	Object	当 slot 类型为 datetime 时，描述时间具体信息，详见：slots array 的 datetime object 说明
     * num_detail	Object	当 slot 类型为 number 和 float 时，描述数字的计算值和类型
     */
    public static class Slots{
        private String slot;
        private String value;
        private String[] valid;
        private String[] modifier;
        private Object datetime;
        @JsonProperty(value = "num_detail")
        private NumDetail numDetail;

        public String getSlot() {
            return slot;
        }

        public void setSlot(String slot) {
            this.slot = slot;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String[] getValid() {
            return valid;
        }

        public void setValid(String[] valid) {
            this.valid = valid;
        }

        public String[] getModifier() {
            return modifier;
        }

        public void setModifier(String[] modifier) {
            this.modifier = modifier;
        }

        public Object getDatetime() {
            return datetime;
        }

        public void setDatetime(Object datetime) {
            this.datetime = datetime;
        }

        public NumDetail getNumDetail() {
            return numDetail;
        }

        public void setNumDetail(NumDetail numDetail) {
            this.numDetail = numDetail;
        }
    }

    public static class NumDetail{
        @JsonProperty(value = "recommend_value")
        private String recommendValue;

        public String getRecommendValue() {
            return recommendValue;
        }

        public void setRecommendValue(String recommendValue) {
            this.recommendValue = recommendValue;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        private String type;
    }

    public static class DataObj{
        //今日新闻
        private String time;
        private String detail;
        private String title;
        /**
         * real_date	Long	从 1970 年开始的毫秒数
         * city	String	查询地点
         * date	Int	0-5，0：表示当天，1：表示明天，依此类推
         * weather_start	Int	早上天气，详请参阅天气数值说明
         * weather_end	Int	晚间天气，详请参阅天气数值说明
         * wind	String	风向
         * temperature_high	String	最高气温
         * temperature_low	String	最低气温
         * description	String	文字描述
         * exponent_type	String Array	天气相关的指数类型，详请参阅天气指数类型说明
         * exponent_value	String Array	天气相关的指数内容描述
         * is_querying	Int	表示此数据组是否为查询目标，例如询问今天的天气，则今天天气数组中本字段数值为 1，其余数组为 0
         * pm25	Int	PM2.5 数据
         */
        //天气模块
        @JsonProperty(value = "real_date")
        private Long realDate;
        private String city;
        private Integer date;
        @JsonProperty(value = "weather_start")
        private Integer weatherStart;
        @JsonProperty(value = "weather_end")
        private Integer weatherEnd;
        private String wind;
        @JsonProperty(value = "temperature_high")
        private String temperatureHigh;
        @JsonProperty(value = "temperature_low")
        private String temperatureLow;
        private String description;
        @JsonProperty(value = "exponent_type")
        private String[] exponentType;
        @JsonProperty(value = "exponent_value")
        private String[] exponentValue;
        @JsonProperty(value = "is_querying")
        private Integer isQuerying;
        private Integer pm25;

        //百科模块
        /**
         * field_name	String Array	字段名称，是一个数组
         * field_value	String Array	字段名称对应的值，是一个数组
         * photo_url	String	照片 URL
         * type	String	人或事物的类型
         * description	String	描述
         * highlight	Int Array	对应的字段是否 highlisht
         * categorylist	String Array	表示查到的结果中类别的列表
         */
        @JsonProperty(value = "field_name")
        private String[] fieldName;
        @JsonProperty(value = "field_value")
        private String[] fieldValue;
        @JsonProperty(value = "photo_url")
        private String photoUrl;
        private String type;
        private Integer highlight;
        private String[] categorylist;

        //新闻模块（多轮对话支持）
        /**
         * title	String	新闻标题
         * time	String	时间
         * image_url	String	图片 URL
         * detail	String	内容
         * ref_url	String	新闻 URL
         */
        @JsonProperty(value = "image_url")
        private String imageUrl;
        @JsonProperty(value = "ref_url")
        private String refUrl;

        //单一数据（选择）
        /**
         * title	String	新闻标题
         * time	String	时间
         * image_url	String	图片 URL
         * detail	String	内容
         * ref_url	String	新闻 URL
         * source	String	来源
         */
        private String source;
        //节目预告模块（多轮对话支持）
        /**
         * time	String	节目开始时间
         * name	String	节目名称
         * highlight	Int	是否满足搜索条件
         */
        private String name;
        //诗词模块（多轮对话支持）
        /**
         * title	String	诗词标题
         * author	String	作者
         * content	String	诗词内容
         */
        private String author;
        private String content;
        //多笔数据
        /**
         * poem_name	String	诗词标题
         * author	String	作者
         */
        @JsonProperty(value = "poem_name")
        private String poemName;
        //笑话 / 故事模块
        /**
         * content	String	内容
         */
        //聊天模块
        //股票模块（多轮对话支持）
        /**
         * is_history	Int	是否为历史数据，若是历史数据，price_end 表示收盘价
         * id	String	股票代码
         * name	String	股票名称
         * cur_price	String	现价
         * price_start	String	开盘
         * price_end	String	收盘
         * price_high	String	最高价
         * price_low	String	最低价
         * change_rate	String	涨跌幅
         * change_amount	String	涨跌额
         * volume	String	成交量
         * amount	String	成交额
         * intent	String	大盘或个股
         * time	String	时间，自1970年开始的毫秒数
         * favorite	String	0指的是不在收藏列表中，1指的是在收藏列表中
         */
        @JsonProperty(value = "is_history")
        private Integer isHistory;
        private String id;
        @JsonProperty(value = "cur_price")
        private String curPrice;
        @JsonProperty(value = "price_start")
        private String priceStart;
        @JsonProperty(value = "price_end")
        private String priceEnd;
        @JsonProperty(value = "price_high")
        private String priceHigh;
        @JsonProperty(value = "price_low")
        private String priceLow;
        @JsonProperty(value = "change_rate")
        private String changeRate;
        @JsonProperty(value = "change_amount")
        private String changeAmount;
        private String volume;
        private String amount;
        private String intent;
        private String favorite;
        //单位换算模块
        /**
         * content	String	答复内容
         * src_value	String	源值
         * src_unit	String	源单位
         * dst_value	String	目标值
         * dst_unit	String	目标单位
         */
        @JsonProperty(value = "src_value")
        private String srcValue;
        @JsonProperty(value = "src_unit")
        private String srcUnit;
        @JsonProperty(value = "dst_value")
        private String dstValue;
        @JsonProperty(value = "dst_unit")
        private String dstUnit;
        //汇率模块
        /**
         * target_currency	String	目标汇率值
         */
        @JsonProperty(value = "target_currency")
        private String targetCurrency;
        //酒店模块
        /**
         * hotel_image	String	酒店图片链接
         * floor_price	String	最低价
         * max_price	String	最高价
         * ctrip_rating	String	携程评分（0-10）
         * user_rating	String	用户评分（1-10）
         * description	String	酒店简介
         * description_url	String	酒店简介链接
         * hotel_address	String	酒店地址
         * hotel_name	String	酒店名
         */
        @JsonProperty(value = "hotelImage")
        private String hotelImage;
        @JsonProperty(value = "floor_price")
        private String floorPrice;
        @JsonProperty(value = "max_price")
        private String maxPrice;
        @JsonProperty(value = "ctrip_rating")
        private String ctripRating;
        @JsonProperty(value = "user_rating")
        private String userRating;
        @JsonProperty(value = "description_url")
        private String descriptionUrl;
        @JsonProperty(value = "hotel_address")
        private String hotelAddress;
        @JsonProperty(value = "hotel_name")
        private String hotelName;
        //openweb 模块
        private String url;



        private String result;
        private Integer status;


        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Long getRealDate() {
            return realDate;
        }

        public void setRealDate(Long realDate) {
            this.realDate = realDate;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Integer getDate() {
            return date;
        }

        public void setDate(Integer date) {
            this.date = date;
        }

        public Integer getWeatherStart() {
            return weatherStart;
        }

        public void setWeatherStart(Integer weatherStart) {
            this.weatherStart = weatherStart;
        }

        public Integer getWeatherEnd() {
            return weatherEnd;
        }

        public void setWeatherEnd(Integer weatherEnd) {
            this.weatherEnd = weatherEnd;
        }

        public String getWind() {
            return wind;
        }

        public void setWind(String wind) {
            this.wind = wind;
        }

        public String getTemperatureHigh() {
            return temperatureHigh;
        }

        public void setTemperatureHigh(String temperatureHigh) {
            this.temperatureHigh = temperatureHigh;
        }

        public String getTemperatureLow() {
            return temperatureLow;
        }

        public void setTemperatureLow(String temperatureLow) {
            this.temperatureLow = temperatureLow;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String[] getExponentType() {
            return exponentType;
        }

        public void setExponentType(String[] exponentType) {
            this.exponentType = exponentType;
        }

        public String[] getExponentValue() {
            return exponentValue;
        }

        public void setExponentValue(String[] exponentValue) {
            this.exponentValue = exponentValue;
        }

        public Integer getIsQuerying() {
            return isQuerying;
        }

        public void setIsQuerying(Integer isQuerying) {
            this.isQuerying = isQuerying;
        }

        public Integer getPm25() {
            return pm25;
        }

        public void setPm25(Integer pm25) {
            this.pm25 = pm25;
        }

        public String[] getFieldName() {
            return fieldName;
        }

        public void setFieldName(String[] fieldName) {
            this.fieldName = fieldName;
        }

        public String[] getFieldValue() {
            return fieldValue;
        }

        public void setFieldValue(String[] fieldValue) {
            this.fieldValue = fieldValue;
        }

        public String getPhotoUrl() {
            return photoUrl;
        }

        public void setPhotoUrl(String photoUrl) {
            this.photoUrl = photoUrl;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Integer getHighlight() {
            return highlight;
        }

        public void setHighlight(Integer highlight) {
            this.highlight = highlight;
        }

        public String[] getCategorylist() {
            return categorylist;
        }

        public void setCategorylist(String[] categorylist) {
            this.categorylist = categorylist;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getRefUrl() {
            return refUrl;
        }

        public void setRefUrl(String refUrl) {
            this.refUrl = refUrl;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPoemName() {
            return poemName;
        }

        public void setPoemName(String poemName) {
            this.poemName = poemName;
        }

        public Integer getIsHistory() {
            return isHistory;
        }

        public void setIsHistory(Integer isHistory) {
            this.isHistory = isHistory;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCurPrice() {
            return curPrice;
        }

        public void setCurPrice(String curPrice) {
            this.curPrice = curPrice;
        }

        public String getPriceStart() {
            return priceStart;
        }

        public void setPriceStart(String priceStart) {
            this.priceStart = priceStart;
        }

        public String getPriceEnd() {
            return priceEnd;
        }

        public void setPriceEnd(String priceEnd) {
            this.priceEnd = priceEnd;
        }

        public String getPriceHigh() {
            return priceHigh;
        }

        public void setPriceHigh(String priceHigh) {
            this.priceHigh = priceHigh;
        }

        public String getPriceLow() {
            return priceLow;
        }

        public void setPriceLow(String priceLow) {
            this.priceLow = priceLow;
        }

        public String getChangeRate() {
            return changeRate;
        }

        public void setChangeRate(String changeRate) {
            this.changeRate = changeRate;
        }

        public String getChangeAmount() {
            return changeAmount;
        }

        public void setChangeAmount(String changeAmount) {
            this.changeAmount = changeAmount;
        }

        public String getVolume() {
            return volume;
        }

        public void setVolume(String volume) {
            this.volume = volume;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getIntent() {
            return intent;
        }

        public void setIntent(String intent) {
            this.intent = intent;
        }

        public String getFavorite() {
            return favorite;
        }

        public void setFavorite(String favorite) {
            this.favorite = favorite;
        }

        public String getSrcValue() {
            return srcValue;
        }

        public void setSrcValue(String srcValue) {
            this.srcValue = srcValue;
        }

        public String getSrcUnit() {
            return srcUnit;
        }

        public void setSrcUnit(String srcUnit) {
            this.srcUnit = srcUnit;
        }

        public String getDstValue() {
            return dstValue;
        }

        public void setDstValue(String dstValue) {
            this.dstValue = dstValue;
        }

        public String getDstUnit() {
            return dstUnit;
        }

        public void setDstUnit(String dstUnit) {
            this.dstUnit = dstUnit;
        }

        public String getTargetCurrency() {
            return targetCurrency;
        }

        public void setTargetCurrency(String targetCurrency) {
            this.targetCurrency = targetCurrency;
        }

        public String getHotelImage() {
            return hotelImage;
        }

        public void setHotelImage(String hotelImage) {
            this.hotelImage = hotelImage;
        }

        public String getFloorPrice() {
            return floorPrice;
        }

        public void setFloorPrice(String floorPrice) {
            this.floorPrice = floorPrice;
        }

        public String getMaxPrice() {
            return maxPrice;
        }

        public void setMaxPrice(String maxPrice) {
            this.maxPrice = maxPrice;
        }

        public String getCtripRating() {
            return ctripRating;
        }

        public void setCtripRating(String ctripRating) {
            this.ctripRating = ctripRating;
        }

        public String getUserRating() {
            return userRating;
        }

        public void setUserRating(String userRating) {
            this.userRating = userRating;
        }

        public String getDescriptionUrl() {
            return descriptionUrl;
        }

        public void setDescriptionUrl(String descriptionUrl) {
            this.descriptionUrl = descriptionUrl;
        }

        public String getHotelAddress() {
            return hotelAddress;
        }

        public void setHotelAddress(String hotelAddress) {
            this.hotelAddress = hotelAddress;
        }

        public String getHotelName() {
            return hotelName;
        }

        public void setHotelName(String hotelName) {
            this.hotelName = hotelName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }
    }

}

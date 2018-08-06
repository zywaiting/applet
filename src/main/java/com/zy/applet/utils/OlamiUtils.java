package com.zy.applet.utils;

import ai.olami.cloudService.*;
import ai.olami.nli.NLIResult;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
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

//    public static void main(String[] args) {
//        long startTime=System.currentTimeMillis();   //获取开始时间
//        String speechInput = speechInput("http://wq-zy.oss-cn-hangzhou.aliyuncs.com/picture/test.pcm");
//        System.out.println(speechInput);
//        long endTime=System.currentTimeMillis(); //获取结束时间
//
//        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
//    }

    /**
     * speechInput:
     * {"data":
     *        {
     * 	"asr":{"result":"五加三加二","speech_status":0,"final":true,"status":0},
     * 	"seg":"五加 三 加 二 ",
     * 	"nli":[{
     * 		"desc_obj":{"result":"结果等于10。","status":0},
     * 		"data_obj":[{
     * 			"result":"10","content":"结果等于10。"
     *            }],
     * 		"type":"math"}]
     *    },
     * "status":"ok"}
     */

    public static void main(String[] args) {
        String result ="{\"data\":\n" +
                "\t{\n" +
                "\t\"asr\":{\"result\":\"五加三加二\",\"speech_status\":0,\"final\":true,\"status\":0},\n" +
                "\t\"seg\":\"五加 三 加 二 \",\n" +
                "\t\"nli\":[{\n" +
                "\t\t\"desc_obj\":{\"result\":\"结果等于10。\",\"status\":0},\n" +
                "\t\t\"data_obj\":[{\n" +
                "\t\t\t\"result\":\"10\",\"content\":\"结果等于10。\"\n" +
                "\t\t\t}],\n" +
                "\t\t\"type\":\"math\"}]\n" +
                "\t},\n" +
                "\"status\":\"ok\"}";
        Result resultStr = Utils.json(result, Result.class);
        System.out.println(resultStr.getData().getNliList().get(0).getDescObj().getResult());
        System.out.println(resultStr.getData().getAsr().getResult());
    }

    public static class Result{
        private Data data;
        private String status;

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
        @JsonProperty(value = "data_obj")
        private List<DataObj> dataObjList;
        private String type;

        public DescObj getDescObj() {
            return descObj;
        }

        public void setDescObj(DescObj descObj) {
            this.descObj = descObj;
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
        private String result;
        private Integer status;

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

    public static class DataObj{
        private String result;
        private String content;

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

}

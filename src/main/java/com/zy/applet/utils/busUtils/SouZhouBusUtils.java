package com.zy.applet.utils.busUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zy.applet.pojo.KeyValue;
import com.zy.applet.utils.HttpUtils;
import com.zy.applet.utils.Utils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SouZhouBusUtils {

    private final static Logger logger = LoggerFactory.getLogger(SouZhouBusUtils.class);

    public static Result souZhouBusUtils(String lineID){
        KeyValue[] keyValues = new KeyValue[]{
                new KeyValue("lineID",lineID)
        };
        String post = HttpUtils.post("http://bus.2500.tv/api_line_status.php", keyValues).replaceAll("\uFEFF", "");
        Result result = Utils.json(post, Result.class);
        return result;
    }
    public static Result souZhouBusUtils(String latitude,String longitude,String lineID){
        KeyValue[] keyValues = new KeyValue[]{
                new KeyValue("latitude",latitude),
                new KeyValue("longitude",longitude),
                new KeyValue("lineID",lineID),
        };
        String post = HttpUtils.post("http://bus.2500.tv/api_line_nearby.php", keyValues).replaceAll("\uFEFF", "");
        return null;
    }

    public static Result souZhouBusUtils(String latitude,String longitude){
        KeyValue[] keyValues = new KeyValue[]{
                new KeyValue("latitude",latitude),
                new KeyValue("longitude",longitude)
        };
        String post = HttpUtils.post("http://bus.2500.tv/api_nearby.php", keyValues).replaceAll("\uFEFF", "");
        System.out.println(post);
        Result result = Utils.json(post, Result.class);
        return result;
    }



    public static Result souZhouBusUtils(String stationID,Integer status){
        Result result = new Result();
        List<Data> dataList = new ArrayList<>();
        Data data  = new Data();
        KeyValue[] keyValues = new KeyValue[]{
                new KeyValue("stationID",stationID)
        };

        String html = HttpUtils.get("http://bus.2500.tv/stationList.php", keyValues);
        Document doc = Jsoup.parse(html);
        Elements elements = doc.getElementsByTag("dl");
        for (Element element : elements) {
            Elements b = element.getElementsByTag("b");
            Elements p = element.getElementsByTag("p");
            Elements a = element.getElementsByTag("a");
            String lineID = a.first().attr("lineID");
            String pText = p.last().text();
            String bText = b.text();
            data.setBusId(lineID);
            data.setBusName(bText);
            data.setStationCName(pText);
            dataList.add(data);
        }
        result.setData(dataList);
        return result;
    }







    public static void main(String[] args) {
        Result result = souZhouBusUtils("10002072",1);
        for (Data data : result.getData()) {
            System.out.println(data.getBusId());
            System.out.println(data.getBusName());
        }
    }

























    public static class Result{
        private Integer status;
        private List<Data> data;

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public List<Data> getData() {
            return data;
        }

        public void setData(List<Data> data) {
            this.data = data;
        }
    }

    public static class Data{
        private String busId;
        private String busName;
        private String beginEnd;
        private Integer number;
        @JsonProperty(value = "BusInfo")
        private String busInfo;
        @JsonProperty(value = "Code")
        private String code;
        @JsonProperty(value = "ID")
        private Integer id;
        @JsonProperty(value = "InTime")
        private String inTime;
        @JsonProperty(value = "OutTime")
        private String outTime;
        @JsonProperty(value = "StationCName")
        private String stationCName;
        @JsonProperty(value = "Position")
        private String position;
        @JsonProperty(value = "latitude")
        private String latitude;
        @JsonProperty(value = "longitude")
        private String longitude;
        @JsonProperty(value = "long")
        private Integer longStr;

        public String getBusId() {
            return busId;
        }

        public void setBusId(String busId) {
            this.busId = busId;
        }

        public String getBeginEnd() {
            return beginEnd;
        }

        public void setBeginEnd(String beginEnd) {
            this.beginEnd = beginEnd;
        }

        public String getBusName() {
            return busName;
        }

        public void setBusName(String busName) {
            this.busName = busName;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public Integer getLongStr() {
            return longStr;
        }

        public void setLongStr(Integer longStr) {
            this.longStr = longStr;
        }

        public String getBusInfo() {
            return busInfo;
        }

        public void setBusInfo(String busInfo) {
            this.busInfo = busInfo;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getInTime() {
            return inTime;
        }

        public void setInTime(String inTime) {
            this.inTime = inTime;
        }

        public String getOutTime() {
            return outTime;
        }

        public void setOutTime(String outTime) {
            this.outTime = outTime;
        }

        public String getStationCName() {
            return stationCName;
        }

        public void setStationCName(String stationCName) {
            this.stationCName = stationCName;
        }
    }
}

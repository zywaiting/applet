package com.zy.applet.utils.busUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zy.applet.pojo.KeyValue;
import com.zy.applet.utils.HttpUtils;
import com.zy.applet.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

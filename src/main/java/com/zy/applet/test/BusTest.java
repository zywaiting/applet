package com.zy.applet.test;

import com.zy.applet.pojo.KeyValue;
import com.zy.applet.utils.HttpUtils;

public class BusTest {
    public static void main(String[] args) {
        KeyValue[] keyValues = new KeyValue[]{
          new KeyValue("latitude","31.301657"),
          new KeyValue("longitude","120.649529"),
//          new KeyValue("lineID","10000522"),
//          new KeyValue("stationID","10003151")
        };
        String post = HttpUtils.post("http://app.2500.tv/bus/api_nearby.php",keyValues);
        System.out.println(post);
    }
}

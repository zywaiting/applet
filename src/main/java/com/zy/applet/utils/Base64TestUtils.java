package com.zy.applet.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.UUID;

/**
 * @Author: zy
 * @Date: 2019/3/8 16:04
 * @Version 1.0
 * @Description
 */
public class Base64TestUtils {


    //图片转化成base64字符串
    public static String GetImageStr() {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        String imgFile = "D:\\test.jpg";//待处理的图片
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);//返回Base64编码过的字节数组字符串
    }

    //base64字符串转化成图片
    public static String GenerateImage(String imgStr) { //对字节数组字符串进行Base64解码并生成图片
        String imageUrl = "";
        if (imgStr == null) //图像数据为空
            return imageUrl;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
                //Base64解码
                byte[] b = decoder.decodeBuffer(imgStr);
                for (int i = 0; i < b.length; ++i) {
                    if (b[i] < 0) {//调整异常数据
                        b[i] += 256;
                    }
                }
            //生成jpeg图片
            InputStream inputStream = new ByteArrayInputStream(b);
            imageUrl = OssUploadFileUtils.OssUploadFileInputStreamtest("wq-zy", "tencentBot/jpg/" + UUID.randomUUID().toString().replaceAll("-", "") + "." + "jpg", inputStream);
        } catch (Exception e) {
            return imageUrl;
        }
        return imageUrl;
    }


}

package com.zy.applet.utils;

import com.aliyun.oss.OSSClient;

import java.io.*;
import java.net.URL;

public class OssUploadFileUtils {

    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    private static final String accessKeyId = "LTAIyKheoLxIYBNE";
    private static final String accessKeySecret = "eNzbbHvNMlt4qaqo3fsX3J229CE0jD";
    // Endpoint以杭州为例，其它Region请按实际情况填写。
    private static final String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
    //http://wq-zy.oss-cn-hangzhou.aliyuncs.com/picture/


    //上传字符串
    public static String OssUploadString(String bucketName, String yourObjectName){
        // 上传字符串。
        String content = "Hello OSS";
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName, yourObjectName, new ByteArrayInputStream(content.getBytes()));
        // 关闭OSSClient。
        ossClient.shutdown();
        return "http://"+bucketName+".oss-cn-hangzhou.aliyuncs.com/"+ yourObjectName;
    }
    //上传Byte数组
    public static String OssUploadByte(String bucketName, String yourObjectName){
        // 上传Byte数组。
        byte[] content = "Hello OSS".getBytes();
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName, yourObjectName, new ByteArrayInputStream(content));
        // 关闭OSSClient。
        ossClient.shutdown();
        return "http://"+bucketName+".oss-cn-hangzhou.aliyuncs.com/"+ yourObjectName;
    }

    //上传网络流
    public static String OssUploadWWWInputStream (String bucketName, String yourObjectName, String url) throws IOException {
        // 上传网络流。
        InputStream inputStream = new URL(url).openStream();
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName, yourObjectName, inputStream);
        // 关闭OSSClient。
        ossClient.shutdown();
        return "http://"+bucketName+".oss-cn-hangzhou.aliyuncs.com/"+ yourObjectName;
    }


    //上传文件流
    public static String OssUploadFileInputStream (String bucketName, String yourObjectName, String yourlocalFile) throws FileNotFoundException {
        // 上传文件流。
        InputStream inputStream = new FileInputStream(yourlocalFile);
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName, yourObjectName, inputStream);
        // 关闭OSSClient。
        ossClient.shutdown();
        return "http://"+bucketName+".oss-cn-hangzhou.aliyuncs.com/"+ yourObjectName;
    }


    //上传文件流
    public static String OssUploadFileInputStreamtest (String bucketName, String yourObjectName,InputStream inputStream) throws FileNotFoundException {
        // 上传文件流。
        //InputStream inputStream = new FileInputStream(yourlocalFile);
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName, yourObjectName, inputStream);
        // 关闭OSSClient。
        ossClient.shutdown();
        return "http://"+bucketName+".oss-cn-hangzhou.aliyuncs.com/"+ yourObjectName;
    }

    //上传文件
    //http://wq-zy.oss-cn-hangzhou.aliyuncs.com/picture/
    public static String OssUploadFile(String bucketName, String yourObjectName, String yourlocalFile){
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
        ossClient.putObject(bucketName, yourObjectName, new File(yourlocalFile));
        // 关闭OSSClient。
        ossClient.shutdown();
        return "http://"+bucketName+".oss-cn-hangzhou.aliyuncs.com/"+ yourObjectName;
    }

    public static void main(String[] args) {
        String url =OssUploadFile("wq-zy","applet/recording/z/timg4.jpg","D:\\图片\\timg.jpg");
        System.out.println(url);
    }
}

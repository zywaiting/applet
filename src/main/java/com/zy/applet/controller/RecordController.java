package com.zy.applet.controller;

import com.zy.applet.utils.OssUploadFileUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class RecordController {

    private final static Logger LOGGER = LoggerFactory.getLogger(RecordController.class);

//    @Value("${web.upload.path}")
//    private String uploadPath;
    @ApiOperation(value="上传文件(小程序)")
    @PostMapping("/fileUpload")
    public String upload(HttpServletRequest request, @RequestParam("file")MultipartFile[] files){
        LOGGER.info("上传测试");
        //多文件上传
        if(files!=null && files.length>=1) {
            BufferedOutputStream bw = null;
            try {
                String fileName = files[0].getOriginalFilename();
                //判断是否有文件(实际生产中要判断是否是音频文件)
                if(StringUtils.isNoneBlank(fileName)) {
//                    //创建输出文件对象
//                    File outFile = new File(uploadPath + UUID.randomUUID().toString()+ getFileType(fileName));
//                    //拷贝文件到输出文件对象
//                    FileUtils.copyInputStreamToFile(files[0].getInputStream(), outFile);
                    OssUploadFileUtils.OssUploadFileInputStreamtest("wq-zy",fileName,files[0].getInputStream());
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if(bw!=null) {bw.close();}
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "success";
    }

    /**
     * 得到文件的类型。
     * 实际上就是得到文件名中最后一个“.”后面的部分。
     * @param fileName 文件名
     * @return 文件名中的类型部分
     * @since  1.0
     */
    public static String getFileType(String fileName) {
        int point = fileName.lastIndexOf('.');
        int length = fileName.length();
        if (point == -1 || point == length - 1) {
            return "";
        }
        else {
            return fileName.substring(point + 1, length);
        }
    }
}

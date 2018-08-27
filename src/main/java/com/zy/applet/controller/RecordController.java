package com.zy.applet.controller;

import com.zy.applet.mapper.LoginMapper;
import com.zy.applet.pojo.AppletConfig;
import com.zy.applet.utils.Mp3ConcertPcmUtils;
import com.zy.applet.utils.OlamiUtils;
import com.zy.applet.utils.OssUploadFileUtils;
import com.zy.applet.utils.ResponseMessageUtils;
import com.zy.applet.utils.baiduUtils.BaiDuAsrUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.sound.sampled.AudioInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

@RestController
public class RecordController {

    private final static Logger logger = LoggerFactory.getLogger(RecordController.class);

    @Autowired
    private LoginMapper loginMapper;

    @ApiOperation(value="上传文件(小程序)")
    @PostMapping("/fileUpload")
    public ResponseMessageUtils upload(HttpServletRequest request, @RequestParam("file")MultipartFile[] files,@RequestParam("openId") String openId){
        OlamiUtils.Result result = null;
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
                    OssUploadFileUtils.OssUploadFileInputStreamtest("wq-zy", "applet/recording/" + openId + "/" + fileName, files[0].getInputStream());
                    AudioInputStream pcmAudioInputStream = Mp3ConcertPcmUtils.getPcmAudioInputStream(files[0].getInputStream());
                    result = OlamiUtils.speechInput(pcmAudioInputStream);
                    logger.info("speechInput:{}",result.getStatus());
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
//        logger.info("1:{}",result != null);
//        logger.info("2:{}",result.getData() != null);
//        logger.info("3:{}",result.getData().getNliList()!=null);
//        logger.info("4:{}",result.getData().getNliList().get(0) != null);
//        logger.info("5:{}",result.getData().getNliList().get(0).getDataObjList() != null);
//        logger.info("6:{}",result.getData().getNliList().get(0).getDataObjList().size());
        if (result != null && result.getData() != null && result.getData().getNliList() != null && result.getData().getNliList().size() > 0  && result.getData().getNliList().get(0) != null
                && result.getData().getNliList().get(0).getDataObjList() != null && result.getData().getNliList().get(0).getDataObjList().size() > 0) {
            AppletConfig appletConfig = loginMapper.selectAppletConfig("baudu_token");
            String context = "";
            String ask = "";
            if (StringUtils.isNotBlank(result.getData().getNliList().get(0).getDataObjList().get(0).getContent()) || StringUtils.isNotBlank(result.getData().getNliList().get(0).getDescObj().getResult())) {
                if (StringUtils.isNotBlank(result.getData().getNliList().get(0).getDataObjList().get(0).getContent())){
                    context = result.getData().getNliList().get(0).getDataObjList().get(0).getContent();
                }
                if (StringUtils.isNotBlank(result.getData().getNliList().get(0).getDescObj().getResult())){
                    ask = result.getData().getNliList().get(0).getDescObj().getResult();
                }
                String baiDuRestUtils = BaiDuAsrUtils.baiDuRestUtils(appletConfig, ask + context, "0");
                result.setUrl(baiDuRestUtils);
            }
            return ResponseMessageUtils.ok(result);
        } else {
            AppletConfig appletConfig = loginMapper.selectAppletConfig("baudu_token");
            if (result != null && result.getData() != null && result.getData().getNliList() != null && result.getData().getNliList().size() > 0 && result.getData().getNliList().get(0) != null
                    && result.getData().getNliList().get(0).getDescObj() != null && StringUtils.isNotBlank(result.getData().getNliList().get(0).getDescObj().getResult())) {
                String baiDuRestUtils = BaiDuAsrUtils.baiDuRestUtils(appletConfig, result.getData().getNliList().get(0).getDescObj().getResult(), "0");
                result.setUrl(baiDuRestUtils);
            }
            return ResponseMessageUtils.ok(result);
        }

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

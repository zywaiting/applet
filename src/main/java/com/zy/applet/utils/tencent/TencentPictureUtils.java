package com.zy.applet.utils.tencent;

import com.zy.applet.pojo.TencentPictureReturn;
import com.zy.applet.utils.HttpUtils;
import com.zy.applet.utils.Utils;

import java.util.HashMap;


/**
 * @Author: zy
 * @Date: 2019/3/7 12:52
 * @Version 1.0
 * @Description
 */
public class TencentPictureUtils {

    private static final String URL = "http://47.96.120.133:8888/tencent/picture";

    public static TencentPictureReturn tencentPicture(String imageUrl, String decoration) {
        HashMap<String, String> hashMapParams = new HashMap<>();
        hashMapParams.put("imageUrl", imageUrl);
        hashMapParams.put("decoration", decoration);
        String postReturn = HttpUtils.post(URL, hashMapParams);
        return Utils.json(postReturn, TencentPictureReturn.class);
    }


}

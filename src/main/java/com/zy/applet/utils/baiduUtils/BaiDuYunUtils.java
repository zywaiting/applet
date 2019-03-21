package com.zy.applet.utils.baiduUtils;

import com.zy.applet.entitydto.BaiDuYunDto;
import com.zy.applet.pojo.BaiDuYunEntity;
import xin.zhuyao.httputil.HttpUtils;
import xin.zhuyao.httputil.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName BaiDuYunUtils
 * @Description: TODO
 * author zy
 * @date 2019/3/19 21:38
 **/
public class BaiDuYunUtils {
    private static final String URL = "http://47.96.120.133:8888/baiduyun/message";

    public static List<BaiDuYunDto> selectBaiDuYun(String question) {
        HashMap<String, String> hashMapParams = new HashMap<>();
        hashMapParams.put("question", question);
        String postReturn = HttpUtils.post(URL, hashMapParams);
        return Arrays.asList(Utils.json(postReturn, BaiDuYunEntity[].class)).stream().map(BaiDuYunDto::new).collect(Collectors.toList());
    }
}

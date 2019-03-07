package com.zy.applet.wechatbot.api.request;

import com.zy.applet.wechatbot.api.response.JsonResponse;

/**
 * JSON请求
 *
 * @author biezhi
 * @date 2018/1/18
 */
public class JsonRequest extends ApiRequest<JsonRequest, JsonResponse> {

    public JsonRequest(String url) {
        super(url, JsonResponse.class);
    }

}
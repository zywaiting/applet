package com.zy.applet.wechatbot.api.client;


import com.zy.applet.wechatbot.api.request.ApiRequest;
import com.zy.applet.wechatbot.api.response.ApiResponse;

import java.io.IOException;

public interface Callback<T extends ApiRequest, R extends ApiResponse> {

    void onResponse(T request, R response);

    void onFailure(T request, IOException e);

}
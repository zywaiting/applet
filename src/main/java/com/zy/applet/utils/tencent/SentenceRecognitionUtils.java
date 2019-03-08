package com.zy.applet.utils.tencent;

import com.tencentcloudapi.aai.v20180522.AaiClient;
import com.tencentcloudapi.aai.v20180522.models.SentenceRecognitionRequest;
import com.tencentcloudapi.aai.v20180522.models.SentenceRecognitionResponse;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
public class SentenceRecognitionUtils {



    public static void main(String [] args) {
        try{

            Credential cred = new Credential("AKIDQcY5OQAm7C1a2EHEsa4IH0VkywxPu6fz", "EEzSpkRVPYSJrGRTWKAoxY10WMfojdHy");

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("aai.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            AaiClient client = new AaiClient(cred, "ap-beijing", clientProfile);

            String params = "{\"ProjectId\":0,\"SubServiceType\":2,\"EngSerViceType\":\"16k\",\"SourceType\":0,\"Url\":\"" +
                    "http%3a%2f%2fwq-zy.oss-cn-hangzhou.aliyuncs.com%2ftencentBot%2fmp3%2f8165e45011244659be0ebb34a887c78a.mp3" +
                    "\",\"VoiceFormat\":\"mp3\",\"UsrAudioKey\":\"123\"}";
            SentenceRecognitionRequest req = SentenceRecognitionRequest.fromJsonString(params, SentenceRecognitionRequest.class);

            SentenceRecognitionResponse resp = client.SentenceRecognition(req);

            System.out.println(SentenceRecognitionRequest.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }

    }


}
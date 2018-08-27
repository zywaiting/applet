package com.zy.applet.service;


import com.zy.applet.pojo.VoicePrompts;

public interface VoicePromptsService {

    // 查询语音提示
    VoicePrompts selectVoicePromptsByKey(String key);
}

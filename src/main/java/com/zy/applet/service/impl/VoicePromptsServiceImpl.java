package com.zy.applet.service.impl;

import com.zy.applet.mapper.TravelMapper;
import com.zy.applet.mapper.VoicePromptsMapper;
import com.zy.applet.pojo.Travel;
import com.zy.applet.pojo.VoicePrompts;
import com.zy.applet.service.TravelService;
import com.zy.applet.service.VoicePromptsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoicePromptsServiceImpl implements VoicePromptsService {


    @Autowired
    private VoicePromptsMapper voicePromptsMapper;

    @Override
    public VoicePrompts selectVoicePromptsByKey(String key) {
        return voicePromptsMapper.selectVoicePromptsByKey(key);
    }
}

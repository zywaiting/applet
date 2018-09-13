package com.zy.applet.controller.word;
import com.zy.applet.pojo.VoicePrompts;
import com.zy.applet.service.VoicePromptsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zy
 * 2018-8-27
 * 语音提示
 */
@RestController
public class VoicePromptsController {
    private final static Logger logger = LoggerFactory.getLogger(VoicePromptsController.class);

    @Autowired
    private VoicePromptsService voicePromptsService;

    @RequestMapping(value = "api/voiceprompts")
    public VoicePrompts findCrityInfo(String key) {
        logger.info("调用了语音提示接口---------------api/voiceprompts:{}",key);
        return voicePromptsService.selectVoicePromptsByKey(key);
    }
}

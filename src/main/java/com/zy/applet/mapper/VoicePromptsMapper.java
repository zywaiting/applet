package com.zy.applet.mapper;

import com.zy.applet.pojo.Travel;
import com.zy.applet.pojo.VoicePrompts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface VoicePromptsMapper {
    // 查询语音提示
    VoicePrompts selectVoicePromptsByKey(@Param("key") String key);
}

package com.zy.applet.service;


import com.zy.applet.pojo.Joke;

import java.util.List;

/**
 * 笑话大全接口
 * Created by zy on 04/05/2018.
 */
public interface JokeService {
    /**
     * 随机查询20条笑话
     * @return
     */
    List<Joke> findByRandom();
}

package com.zy.applet.controller.word;

import com.zy.applet.pojo.Joke;
import com.zy.applet.service.JokeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by zy on 04/05/2018.
 */
@RestController
public class JokeController {

    private final static Logger logger = LoggerFactory.getLogger(JokeController.class);

    @Autowired
    private JokeService jokeService;
    //查询笑话接口
    @RequestMapping(value = "api/joke")
    public List<Joke> findOneCity() {
        logger.info("调用了查询笑话接口---------------api/joke");
        return jokeService.findByRandom();
    }
}

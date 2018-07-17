package com.zy.applet.controller;

import com.zy.applet.pojo.Joke;
import com.zy.applet.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by zy on 04/05/2018.
 */
@RestController
public class JokeController {
    @Autowired
    private JokeService jokeService;
    @RequestMapping(value = "api/joke")
    public List<Joke> findOneCity() {
        return jokeService.findByRandom();
    }
}

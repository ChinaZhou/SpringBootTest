package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/10/11.
 */
@RestController
public class HiController {

    @Value("${server.port}")
    private String port;
    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        return  "hi " + name + ",i am from port:" + port;
    }
}

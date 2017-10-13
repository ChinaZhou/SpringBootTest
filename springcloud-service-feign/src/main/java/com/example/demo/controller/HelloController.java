package com.example.demo.controller;

import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/10/13.
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/hi")
    public String hi(@RequestParam(value = "name") String name) {
        return  helloService.sayHi(name);
    }
}

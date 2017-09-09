package com.zhouc.controller;

import com.zhouc.dto.Girl;
import com.zhouc.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/9/7.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Value("${girl.name}")
    private String name;
    @Value("${girl.age}")
    private Integer age;
    @Value("${content}")
    private String content;
    @Autowired
    private Girl girl;

    @GetMapping("/say")
    public String say() {
        return  girl.getName();
    }

}

package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/10/13.
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String hi(String name) {
        return  restTemplate.getForObject("http://SERVICE-HI/hi?name="+name, String.class);
    }

}

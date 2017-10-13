package com.example.demo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017/10/13.
 */
@FeignClient(value = "service-hi")
public interface HelloService {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHi(@RequestParam(value = "name") String name);
}

package com.zhouc.controller;

import com.zhouc.dto.Boy;
import com.zhouc.dto.Girl;
import com.zhouc.service.BoyService;
import com.zhouc.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/9/9.
 */
@RestController()
@RequestMapping("/boy")
public class BoyController {

    @Autowired
    private BoyService boyService;
    @Autowired
    private GirlService girlService;

    @GetMapping("/{name}")
    public Boy findByName(@PathVariable(value = "name") String name) {
        Boy boy = boyService.findByName(name);
        Girl girl = girlService.findByName("yyq");
        boy.setGirl(girl);
        return boy;
    }
}

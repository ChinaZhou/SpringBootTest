package com.zhouc.controller;

import com.zhouc.dto.Girl;
import com.zhouc.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by Administrator on 2017/9/9.
 */
@RestController()
@RequestMapping("/girl")
public class GirlController {

    @Autowired
    private GirlService cityService;

    @GetMapping("/{name}")
    public Girl findByName(@PathVariable(value = "name") String name) {
        Girl girl = cityService.findByName(name);
        return  girl;
    }

    @GetMapping("/all")
    public List<Girl> findAll() {
        return  cityService.findAll();
    }

    @GetMapping("/all/{id}")
    public Girl findById(@PathVariable(value = "id") Integer id) {
        return cityService.findById(id);
    }
}



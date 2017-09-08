package com.zhouc.controller;

import com.zhouc.dto.Girl;
import com.zhouc.dto.Result;
import com.zhouc.enums.ResultEnum;
import com.zhouc.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import util.ResultUtil;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Administrator on 2017/9/8.
 */
@RestController
@RequestMapping("/girl")
public class GirlController {

    @Autowired
    private GirlService girlService;

    @GetMapping("/all")
    public Result<List<Girl>> girlFindAll() {
        return ResultUtil.success(girlService.findAll());
    }

    @PostMapping("/add")
    public Result<Girl> girlAddOne(@Valid Girl girl, BindingResult bindingResult) throws  Exception{
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return ResultUtil.error(ResultEnum.GIRL_VALIDATE_EXCEPTION);
        }
        return  ResultUtil.success(girlService.addOne(girl));
    }

    @PutMapping("/{id}")
    public Result<Girl> girlUpdate(@PathVariable(value = "id") Integer id, @RequestParam(value = "age") Integer age,
                           @RequestParam(value = "name") String name) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setName(name);
        girl.setAge(age);
        return  ResultUtil.success(girlService.updateOne(girl));
    }

    @GetMapping("/{id}")
    public Result<Girl> girlFindById(@PathVariable(value = "id") Integer id) {
        return  ResultUtil.success(girlService.findById(id));
    }

    @PostMapping("/addTwo")
    public void girlAddTwo() {
        girlService.addTwo();
    }
}

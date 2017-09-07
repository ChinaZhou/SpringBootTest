package com.zhouc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/9/7.
 */
@RestController
@RequestMapping("/girl")
public class HelloController {

    @Value("${girl.name}")
    private String name;
    @Value("${girl.age}")
    private Integer age;
    @Value("${content}")
    private String content;
    @Autowired
    private Girl girl;
    @Autowired
    private GirlService girlService;

    @GetMapping("/say")
    public String say() {
        return  girl.getName();
    }

    @GetMapping("/all")
    public List<Girl> girlFindAll() {
        return  girlService.findAll();
    }

    @PostMapping("/add")
    public Girl girlAddOne(@RequestParam(value = "name") String name, @RequestParam(value = "age") Integer age) {
        Girl girl = new Girl();
        girl.setName(name);
        girl.setAge(age);
        return  girlService.addOne(girl);
    }

    @PutMapping("/{id}")
    public Girl girlUpdate(@PathVariable(value = "id") Integer id, @RequestParam(value = "age") Integer age,
                           @RequestParam(value = "name") String name) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setName(name);
        girl.setAge(age);
        return  girlService.updateOne(girl);
    }

    @GetMapping("/{id}")
    public Girl girlFindById(@PathVariable(value = "id") Integer id) {
        return  girlService.findById(id);
    }

    @PostMapping("/addTwo")
    public void girlAddTwo() {
        girlService.addTwo();
    }

}

package com.zhouc.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by Administrator on 2017/9/7.
 */
@Component
@ConfigurationProperties(prefix = "girl")
@Entity
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @Min(value = 16, message = "年龄不得低于16岁")
    @Max(value = 59, message = "年龄不得高于59岁")
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

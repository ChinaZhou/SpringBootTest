package com.example.demo.util;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Locale;

/**
 * Created by Administrator on 2017/12/13.
 */
@Component
public class DefaultLocale {

    private static DefaultLocale defaultLocale;

    @PostConstruct
    public void init(){
        defaultLocale = this ;

    }

    public static Locale getDefaultLocale() {
        String language = "cn";// 30

        //获取登录语言环境

        return new Locale(language);// 41
    }

}

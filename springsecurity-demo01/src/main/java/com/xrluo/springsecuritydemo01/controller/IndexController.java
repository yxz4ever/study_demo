package com.xrluo.springsecuritydemo01.controller;

import com.xrluo.springsecuritydemo01.config.DemoConfig;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Resource
    private DemoConfig demoConfig;
    @GetMapping("/")
    public String index(){
        System.out.println(demoConfig.getUser());
        return "Hello";
    }
}

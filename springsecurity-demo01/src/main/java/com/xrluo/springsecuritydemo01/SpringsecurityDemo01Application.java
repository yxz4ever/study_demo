package com.xrluo.springsecuritydemo01;

import com.xrluo.springsecuritydemo01.config.DemoConfig;
import jakarta.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class SpringsecurityDemo01Application {

    @Resource
    private DemoConfig demoConfig;

    /**
     * 启动器
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityDemo01Application.class, args);
    }
}

package com.xrluo.springsecuritydemo01.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@ConfigurationProperties("config.demo")
public class DemoConfig {

    private final User user = new User();

    public User getUser() {
        return user;
    }

    @Data
    public class User{
        private String name = "demo";
        private String password = UUID.randomUUID().toString();
    }
}

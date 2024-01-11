package com.xrluo.springsecuritydemo01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * springsecurity 配置类
 */
@Configuration
// 标记为一个security类，启用springsecurity的自定义配置
@EnableWebSecurity
public class SecurityConfig {

    /**
     * 基于内存登录
     *
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {

//        {noop}明文
        UserDetails userDetails = User.withUsername("admin").password("{noop}111111").roles("admin").build();

        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        inMemoryUserDetailsManager.createUser(userDetails);
        return inMemoryUserDetailsManager;
    }

    /**
     * 密码编码器
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

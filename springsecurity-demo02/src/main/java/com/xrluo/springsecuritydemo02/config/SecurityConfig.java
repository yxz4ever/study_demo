package com.xrluo.springsecuritydemo02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    /**
     * 加密方式
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(16);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(author->author.requestMatchers("/to_login").permitAll().anyRequest().authenticated());
        http.formLogin(form->form.loginPage("/to_login").loginProcessingUrl("/doLogin").usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/index"));

        return http.build();
    }

    /**
     * 基于内存认证
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userDetails = User.withUsername("admin").password("$2a$10$csvUZnj/VG6wBkooT/mewO.WbJesVCiHqEoWTyQrOYTKJvk3xpQb6")
                .roles("admin")
                .authorities("test1:show", "user:name", "user:list")
                .build();

        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        inMemoryUserDetailsManager.createUser(userDetails);

        return inMemoryUserDetailsManager;
    }
}

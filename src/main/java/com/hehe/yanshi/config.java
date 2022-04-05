package com.hehe.yanshi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 刘伟锋
 * @date 2021/05/01
 **/
@ComponentScan("com.hehe")
public class config {
    @Bean
    public User user() {
        return new User();
    }

}

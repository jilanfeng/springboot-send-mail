package com.hehe.yanshi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author εδΌι
 * @date 2021/05/01
 **/
@ComponentScan("com.hehe")
public class config {
    @Bean
    public User user() {
        return new User();
    }

}

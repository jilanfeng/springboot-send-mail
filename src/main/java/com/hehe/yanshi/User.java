package com.hehe.yanshi;

import lombok.Data;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author 刘伟锋
 * @date 2021/05/01
 **/
@Component
public class User {

    private String name;

    private String age;
}

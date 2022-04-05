package com.hehe.bankannation;

import java.lang.annotation.*;

/**
 * 我们定义一个接口API的注解BankAPi,包含接口URL地址和接口说明
 *
 * @author 刘伟锋
 * @date 2021/10/06
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Inherited
public @interface BankAPI {
    String desc() default "";

    String url() default "";
}

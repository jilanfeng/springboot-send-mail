package com.hehe.bankannation;

import java.lang.annotation.*;

/**
 * @author εδΌι
 * @date 2021/10/06
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Inherited
public @interface BankAPIField {
    int order() default -1;
    int length() default -1;
    BankApiFiledType type();
}

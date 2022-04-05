package com.hehe.killIfElse;

import org.thymeleaf.util.StringUtils;


/**
 * @author 刘伟锋
 * @date 2021/11/25
 **/
public class Vutils {


    public static ThrowExceptionFunction isTrue(boolean b) {
        return (errorMessage) -> {
            if (b) {
                throw  new RuntimeException(errorMessage);
            }
        };
    }

    public static BranchHandle isTrueOrFalse(boolean b) {
        return (trueHandle,falseHandle) ->{
            if (b) {
                trueHandle.run();
            } else {
                falseHandle.run();
            }
        };

    }


    public static PresentOrElseHandler<?> isBlankOrNotBlank(String str) {
        return (consumer,runnable) -> {
            if (StringUtils.isEmpty(str)) {
                runnable.run();
            } else {
                consumer.accept(str);
            }
        };

    }
}

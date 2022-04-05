package com.hehe.killIfElse;

import org.springframework.http.converter.json.GsonBuilderUtils;

/**
 * @author 刘伟锋
 * @date 2021/12/03
 **/
public class Test {


    public static void main(String[] args) {
        //step：1
//        Vutils.isTrue(false).throwMessage("开始抛出异常");
//        Vutils.isTrue(true).throwMessage("要开始抛出异常");

//step：2
        Vutils.isTrueOrFalse(true).trueOrFalseHandle(()->{
            System.out.println("true，确实为ttrue");
        },()->{
            System.out.println("false");
        });
        Vutils.isTrueOrFalse(false).trueOrFalseHandle(()-> {
            System.out.println("第二次为true");
        },()->{
            System.out.println("第二次为false");
        });

//        Vutils.isBlankOrNotBlank("").presentOrElseHandle(System.out::println,()->{
//            System.out.println("空字符串");
//        });
//
//        Vutils.isBlankOrNotBlank("liuweif").presentOrElseHandle(System.out::println,()-> {
//            System.out.println("空字符串");
//        });

    }
}

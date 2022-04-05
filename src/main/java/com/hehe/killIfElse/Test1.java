package com.hehe.killIfElse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 刘伟锋
 * @date 2021/12/04
 **/
public class Test1 {
    public void myThrowException(ThrowExceptionFunction throwExceptionFunction) {
        System.out.println("开始测试");
        throwExceptionFunction.throwMessage("青春环游记");
    }
    public static void main(String[] args) {
//        Test1 test1 = new Test1();
//        test1.myThrowException(Vutils.isTrue(false));
//        System.out.println("-------------------------------");
//        ThrowExceptionFunction throwExceptionFunction = Vutils.isTrue(false);
//        System.out.println(throwExceptionFunction);
//        System.out.println(throwExceptionFunction.getClass().getSuperclass());
//        System.out.println(throwExceptionFunction.getClass().getInterfaces().length);
//        System.out.println(throwExceptionFunction.getClass().getInterfaces()[0]);


        List<Integer> integers = Arrays.asList(5,6,8,7,9,10);
        for (int i=0;i< integers.size();i++) {
            System.out.println(integers.get(i));
        }

        System.out.println("------------------");
        for (Integer integer : integers) {
            System.out.println(integer);
        }
        System.out.println("--------------------------");

        integers.forEach(System.out::println);
    }
}

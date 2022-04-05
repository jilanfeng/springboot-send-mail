package com.hehe.Singleton;

/**
 * @author 刘伟锋
 * @date 2021/09/28
 **/
public class SignletonTest {
    public static void main(String[] args) {
        testSingleton01();
        testSingleton02();
    }

    private static void testSingleton02() {
        System.out.println("饿汉测试");
        Singleton01 one = Singleton01.getInstance();
        Singleton01 two = Singleton01.getInstance();
        System.out.println(one);
        System.out.println(two);
        System.out.println("饿汉 one = two" + "\t" + (one == two));
    }

    private static void testSingleton01() {
        System.out.println("懒汉测试");
        Singleton02 one = Singleton02.getInstance();
        Singleton02 two = Singleton02.getInstance();
        System.out.println(one);
        System.out.println(two);
        System.out.println("懒汉 one = two" + "\t" + (one == two));
    }
}

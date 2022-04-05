package com.hehe;

/**
 * @author 刘伟锋
 * @date 2021/10/30
 **/
public class JvmStringTest {
    public static void main(String[] args) {
        String s1 = new StringBuilder("ja").append("va").toString();
        System.out.println(s1.intern() == s1);

        String s2 = new StringBuilder("go").append("ad").toString();
        System.out.println(s2.intern() == s2);

    }


}

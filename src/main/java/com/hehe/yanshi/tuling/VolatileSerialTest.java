package com.hehe.yanshi.tuling;

import java.util.HashSet;
import java.util.Set;

/**
 * 指令重排序
 *
 * @author 刘伟锋
 * @date 2021/05/02
 **/
public class VolatileSerialTest {
    static int x = 0, y = 0;
    static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        Set<String> resultSet = new HashSet();

        for (int i = 0; i < 10000000; i++) {
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            Thread one = new Thread(() -> {
                a = y;
                x = 1;
            });

            Thread two = new Thread(() -> {
                b = x;
                y = 1;
            });

            one.start();
            two.start();
            one.join();
            two.join();
            resultSet.add("a=" + a + "," + "b=" + b);
            System.out.println(resultSet);
        }

    }
}

package com.hehe.yanshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 堆内存溢出  java.lang.OutOfMemoryError: Java heap space
 *
 * @author 刘伟锋
 * @date 2021/05/02
 **/
public class Demo_105 {
    public static void main(String[] args) {
        int i = 0;
        try {
            List<String> helloList = new ArrayList();
            String a = "hello";
            while (true) {
                helloList.add(a);
                a = a + a;
                i++;
            }
        } catch (Throwable e) {
          e.printStackTrace();
            System.out.println(i);
        }
    }
}

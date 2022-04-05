package com.hehe.yanshi;

/**
 * 演示堆内存
 *
 * @author 刘伟锋
 * @date 2021/05/03
 **/
public class Demo1_4 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("1....");
        Thread.sleep(30000);
        //10M
        byte[] array = new byte[1024 * 1024 * 10];
        System.out.println("2....");
        Thread.sleep(30000);
        array = null;
        System.gc();
        System.out.println("3.....");
        Thread.sleep(30000);
    }
}

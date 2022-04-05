package com.hehe.Singleton;

/**
 * @author 刘伟锋
 * @date 2021/09/29
 **/
public class SinglemodelTest {
    public static void main(String[] args) {
        ThreadTestSingleton1();
        ThreadTestSingleton2();
    }

    public static void ThreadTestSingleton1() {
        Thread one = new Thread(new ThreadSingleton1());
        Thread two = new Thread(new ThreadSingleton1());
        one.start();
        two.start();

    }


    public static void ThreadTestSingleton2() {
        Thread one = new Thread(new ThreadSingleton2());
        Thread two = new Thread(new ThreadSingleton2());
        one.start();
        two.start();
    }
}

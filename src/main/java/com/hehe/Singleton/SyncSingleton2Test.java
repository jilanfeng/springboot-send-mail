package com.hehe.Singleton;


/**
 * @author 刘伟锋
 * @date 2021/10/01
 **/
public class SyncSingleton2Test {
    public static void main(String[] args) {
        synThreadTestSingleton2();
    }

    public static void synThreadTestSingleton2() {
        /**
         * 为懒汉式开启两线程
         */
        Thread one= new Thread(new ThreadSingleton2());
        Thread two = new Thread(new ThreadSingleton2());
        one.start();
        two.start();
    }
}

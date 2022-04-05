package com.hehe.Singleton;

/**
 * 测试懒汉式的线程
 *
 * @author 刘伟锋
 * @date 2021/09/29
 **/
public class ThreadSingleton2 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(20);
        } catch(Exception e) {
            e.printStackTrace();
        }
//        System.out.println(Thread.currentThread().getName() + "懒汉式" + Singleton02.getInstance());
        System.out.println(Thread.currentThread().getName() + "懒汉式" + SyncSingleton2.getInstance());
    }
}

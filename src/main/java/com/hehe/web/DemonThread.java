package com.hehe.web;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 刘伟锋
 * @date 2020/12/23
 **/
public class DemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + "begin");
                    Thread.sleep(100000);
                    System.out.println(Thread.currentThread().getName() + "end");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        t.start();
        //设置守护线程
        t.setDaemon(true);
        Thread.sleep(5_000);
        System.out.println(Thread.currentThread().getName());
    }
//    ThreadPoolExecutor t = ();
}

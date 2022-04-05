package com.hehe.Singleton;

/**
 * 测试饿汉式的线程
 *
 * @author 刘伟锋
 * @date 2021/09/29
 **/
public class ThreadSingleton1 implements Runnable{
    @Override
    public void run() {
        try {
         //因为CPU切换得很快，有可能我们运行很多次都看不到效果，所以这里做一下处理让线程睡一会在运行
            Thread.sleep(20);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "饿汉式" + Singleton01.getInstance());
    }
}

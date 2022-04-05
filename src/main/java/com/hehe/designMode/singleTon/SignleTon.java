package com.hehe.designMode.singleTon;

/**
 * @author 刘伟锋
 * @date 2021/01/01
 **/


/**
 * 每个类只能创建一个实例对象
 * Java singleton模式主要作用是在保证在java应用程序中，一个类只有一个实例存在。使用Signleton可以节省内存，因为他限制了实力的个数
 * 有利于Java垃圾回收（garbage collection)
 * <p>
 * 好处：控制资源的使用，通过线程同步来控制资源的并发访问
 * 控制实例产生的数量，达到节约资源的目的
 * 作为通信媒介使用，也就是数据共享，它可以在不建立直接关联的条件下，让多个不相干的两个线程或进程之间实现通信
 *
 *
 * 优点：全局只有一个实例，便于统一控制，同时减少了系统资源开销
 * 应用场景：适合需要做全局统一的场景，例如：全局唯一的编码生成器
 * 注意事项：只对外提供公共的getInstance方法，不提佛那个任何公共构造函数
 */
public class SignleTon {
    //    保证instance在所有线程中同步
    private static volatile SignleTon instance = null;

    // private 避免类在外部实例化
    private SignleTon() {

    }

    public static synchronized SignleTon getInstance() {
        //getInstance 方法前加同步
        if (instance == null) {
            instance = new SignleTon();
        }
        return  instance;
    }
}

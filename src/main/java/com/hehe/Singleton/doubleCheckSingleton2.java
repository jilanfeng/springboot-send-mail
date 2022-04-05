package com.hehe.Singleton;

/**
 *
 *  Java 单例设计模式 懒汉式（修改） ，这里只做演示而已该类并没有提供其他属性
 * @author 刘伟锋
 * @date 2021/10/10
 **/
public class doubleCheckSingleton2 {

    // 保存该类对象的一个实例，懒汉式的做法即在声明的同时并不初始化该对象
    private static  doubleCheckSingleton2 modle = null;

    /**
     * 将构造函数私有化，不对外提供构造函数
     */
    public doubleCheckSingleton2() {
    }

    /**
     * 向外提供访问该类对象的方法
     * 在多线程下为了资源共享将代码设置信号量，保证线程的安全
     *
     * @return
     */
    public static doubleCheckSingleton2 getInstance() {
        if (modle == null) {
            // 若对象不存在上锁，分配新对象
            synchronized (doubleCheckSingleton2.class) { //使用该类对应的字节码文件对象上锁
                //synchronized 用于代码块的时候需要一个锁对象，用于实例方法上使用的this对象
                //当要用于类方法的时候（static） 我们可以使用该类所对应的字节码文件对象，this这个时候不存在
                if (modle == null) {
                    modle = new doubleCheckSingleton2();
                }

            }
        }
        return modle;
    }



}

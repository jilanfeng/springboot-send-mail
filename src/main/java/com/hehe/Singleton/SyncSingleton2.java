package com.hehe.Singleton;

/**
 * @author 刘伟锋
 * @date 2021/10/01
 **/
public class SyncSingleton2 {

    private static SyncSingleton2 model = null;

    private SyncSingleton2() {}

    //向外提供访问该类对象的方法
    //在多线程下为了资源共享将代码块设置信号量，保证线程的安全
    public static synchronized SyncSingleton2 getInstance() {
        if (model == null)
        model = new SyncSingleton2();
        return model;
    }
}

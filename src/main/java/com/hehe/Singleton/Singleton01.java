package com.hehe.Singleton;

/**
 * @author 刘伟锋
 * @date 2021/09/28
 **/
public class Singleton01 {

    /**
     *   声明对象同时私有化
     */
    private static Singleton01 modle = new Singleton01();

    /**
     * 构造函数私有化
     */
    private Singleton01() {

    }

    /**
     * 向外访问该类对象的方法
     *
     * @return
     */
    public static Singleton01 getInstance() {
        return modle;
    }
}

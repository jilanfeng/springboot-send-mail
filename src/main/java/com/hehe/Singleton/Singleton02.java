package com.hehe.Singleton;

/**
 * @author 刘伟锋
 * @date 2021/09/28
 **/
public class Singleton02 {

    /**
     * 声明对象，不实例化
     */
    private static Singleton02 modle = null;

    /**
     * 构造函数私有化
     */
    private Singleton02() {

    }

    /**
     * 向外提供访问该类对象的方法
     *
     * @return
     */
    public static Singleton02 getInstance() {
        if(modle == null) {
            modle = new Singleton02();
            return modle;
        }
        return null;
    }
}

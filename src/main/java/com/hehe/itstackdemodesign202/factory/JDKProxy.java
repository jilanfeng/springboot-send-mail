package com.hehe.itstackdemodesign202.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author 刘伟锋
 * @date 2021/12/11
 **/
public class JDKProxy {

    public static <T> T getProxy(Class<T> interfaceClass,ICacheAdapter cacheAdapter) throws Exception {
        InvocationHandler handler = new JDKInvocationHandler(cacheAdapter);
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
//        Class<?>[] classes = interfaceClass.getInterfaces();
        Class<?>[] classes = new Class[]{interfaceClass};
        return (T)Proxy.newProxyInstance(contextClassLoader,classes,handler);
    }
}

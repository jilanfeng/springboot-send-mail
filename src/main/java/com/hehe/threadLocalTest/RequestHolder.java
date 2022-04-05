package com.hehe.threadLocalTest;

/**
 * @author 刘伟锋
 * @date 2020/09/17
 **/
public class RequestHolder {
    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();
    public static void add(Long id) {
        requestHolder.set(id);
    }
    public static Long getId(){
        return requestHolder.get();
    }
    public static void remove(){
        requestHolder.remove();
    }
}

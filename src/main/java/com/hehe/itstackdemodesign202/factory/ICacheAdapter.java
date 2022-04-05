package com.hehe.itstackdemodesign202.factory;

import java.util.concurrent.TimeUnit;

/**
 * 定义适配接口
 *
 * @author 刘伟锋
 * @date 2021/12/11
 **/
public interface ICacheAdapter {

    String get(String key);

    void set(String key,String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);
}

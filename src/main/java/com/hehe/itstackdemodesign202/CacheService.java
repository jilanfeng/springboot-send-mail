package com.hehe.itstackdemodesign202;

import java.util.concurrent.TimeUnit;

/**
 * @author 刘伟锋
 * @date 2021/12/11
 **/
public interface CacheService {

    String get(final String key);
    void set(String key,String value);
    void set(String key, String value, long timeout, TimeUnit timeUnit);
    void del(String key);
}

package com.hehe.itstackdemodesign202.impl;

import com.hehe.itstackdemodesign202.CacheService;
import com.hehe.itstackdemodesign202.factory.ICacheAdapter;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author 刘伟锋
 * @date 2021/12/11
 **/
public class CacheServiceImpl implements CacheService {
    @Resource
    private ICacheAdapter cacheAdapter;

    @Override
    public String get(String key) {
        return cacheAdapter.get(key);
    }

    @Override
    public void set(String key, String value) {
        cacheAdapter.set(key,value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        cacheAdapter.set(key,value,timeout,timeUnit);

    }

    @Override
    public void del(String key) {

    }
}

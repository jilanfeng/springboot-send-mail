package com.hehe.itstackdemodesign202.factory.impl;

import com.hehe.itstackdemodesign202.factory.ICacheAdapter;
import com.hehe.itstackdemodesign202.master.EGM;

import java.util.concurrent.TimeUnit;

/**
 * @author 刘伟锋
 * @date 2021/12/11
 **/
public class EGMCacheAdapter implements ICacheAdapter {

    private EGM egm = new EGM();

    @Override
    public String get(String key) {
        return egm.gain(key);
    }

    @Override
    public void set(String key, String value) {

        egm.set(key,value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {

        egm.setEx(key,value,timeout,timeUnit);
    }

    @Override
    public void del(String key) {
        egm.delete(key);
    }
}

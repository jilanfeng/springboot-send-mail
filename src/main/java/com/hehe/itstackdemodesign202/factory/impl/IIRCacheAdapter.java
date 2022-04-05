package com.hehe.itstackdemodesign202.factory.impl;

import com.hehe.itstackdemodesign202.factory.ICacheAdapter;
import com.hehe.itstackdemodesign202.master.IIR;

import java.util.concurrent.TimeUnit;

/**
 * @author 刘伟锋
 * @date 2021/12/11
 **/
public class IIRCacheAdapter implements ICacheAdapter {
    private IIR irr = new IIR();

    @Override
    public String get(String key) {
        return irr.get(key);
    }

    @Override
    public void set(String key, String value) {
        irr.set(key,value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        irr.setExpire(key,value,timeout,timeUnit);
    }

    @Override
    public void del(String key) {
        irr.delete(key);
    }
}

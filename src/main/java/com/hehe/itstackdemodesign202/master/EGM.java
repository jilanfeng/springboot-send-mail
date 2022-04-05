package com.hehe.itstackdemodesign202.master;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author 刘伟锋
 * @date 2021/12/11
 **/
public class EGM {

    private Logger logger = LoggerFactory.getLogger(EGM.class);

    private Map<String,String> dataMap = new ConcurrentHashMap<String,String>();

    public String gain(String key) {
        logger.info("EGM读取数据,key:{}",key);
        return dataMap.get(key);
    }

    public void set(String key,String value) {
        logger.info("EGM写入数据 key:{} val:{}",key,value);
        dataMap.put(key,value);
    }

    public void setEx(String key, String value, long timeout, TimeUnit timeUnit) {
        logger.info("EGM写入数据，key:{},value:{},timeout:{},timeUnit:{}",key,value,timeout,timeUnit);
        dataMap.put(key,value);
    }

    public void delete(String key) {
        logger.info("EGM删除数据 key:{}",key);
        dataMap.remove(key);
    }
}

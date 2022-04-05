package com.hehe.web;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.UUID;

/**
 * @author 刘伟锋
 * @date 2020/12/29
 **/
@Slf4j
public class redisLock {
//    private static String LOCK_SUCCESS = "OK";
//    private static Long RELEASE_SUCCESS = 1L;
//    private static String SET_IN_NO_EXIST = "NX";
//    private static String SET_WITH_EXPIRE_TIME = "PX";
//
//    public String acquire() {
//        try {
//            long end = System.currentTimeMillis() + acquireTimeout;
//            String requireToken = UUID.randomUUID().toString();
//            while (System.currentTimeMillis() < end) {
//                String result = jedis.set(lockKey, requireToken, SET_IN_NO_EXIST, SET_WITH_EXPIRE_TIME, expireTIme);
//                if (LOCK_SUCCESS.equals(result)) {
//                    return requireToken;
//                }
//
//                try {
//                    Thread.sleep(1_000);
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                }
//            }
//        } catch (Exception e) {
//            log.error("acquire lock due to error", e);
//        }
//        return null;
//    }
//
//    public boolean release(String identify) {
//        if (identify == null) {
//            return false;
//        }java.util.concurrent.locks
//        //通过lua脚本进行比对删除操作，保证原子性
//        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
//        Object result = new Object();
//        try {
//            result = jedis.eval(script, Collections.singletonList(lockey), Collections.singletonList(identity));
//            if (RELEASE_SUCCESS.equals(result)) {
//                log.info("relese lock success,requestToken:{}", identify);
//                return true;
//            }
//        } catch (Exception e) {
//            log.error("release lock due to error",e);
//        }finally {
//            if (jedis != null) {
//                jedis.close();
//            }
//        }
//        log.info("release lock failed,requestToken:{},resuult:{}",identify,result);
//
//        return false;
//
//    }


}

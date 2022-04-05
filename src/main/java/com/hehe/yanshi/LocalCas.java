package com.hehe.yanshi;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 刘伟锋
 * @date 2021/07/24
 **/
@Slf4j(topic = "c.Test42")
public class LocalCas {

    /**
     * //0 没加锁
     * // 1加锁
     */
    private AtomicInteger state = new AtomicInteger(0);

    public void lock() {
        while (true) {
            if (state.compareAndSet(0, 1)) {
                break;
            }
        }
    }

    public void unlock() {
        log.debug("unlock...");
        state.set(0);
    }

    public static void main(String[] args) {
        LocalCas localCas = new LocalCas();
        new Thread(() -> {
            log.debug("begin...");
            localCas.lock();
            try {
                log.debug("lock..");
            }finally {
                localCas.unlock();
            }
        }).start();
        new Thread(() -> {
            log.debug("begin...");
            localCas.lock();
            try {
                log.debug("lock..");
            }finally {
                localCas.unlock();
            }
        }).start();
    }
}

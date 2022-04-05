package com.hehe.web;

import java.util.Optional;

/**
 * @author 刘伟锋
 * @date 2020/12/23
 **/
public class ThreadsimpleApi {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            Optional.of("Hello").ifPresent(System.out::println);
            try {
                Thread.sleep(100_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        thread.start();
        thread.setPriority(Thread.NORM_PRIORITY);
        Optional.of(thread.getName()).ifPresent(System.out::println);
        Optional.of(thread.getId()).ifPresent(System.out::println);
        Optional.of(thread.getState()).ifPresent(System.out::println);
        Optional.of(thread.getPriority()).ifPresent(System.out::println);
    }
}

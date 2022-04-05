package com.hehe.designMode.singleTon;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author 刘伟锋
 * @date 2021/01/01
 **/
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            IntStream.range(1, 1000)
                    .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
        });

        Thread t2 = new Thread(() -> {
            IntStream.range(1, 1000)
                    .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
        });
        t1.start();
        t2.start();
        t1.join();

        t2.join();
        Optional.of("All of tasks finish done.").ifPresent(System.out::println);
        IntStream.range(1, 1000)
                .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
    }
}

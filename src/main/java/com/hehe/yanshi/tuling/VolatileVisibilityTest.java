package com.hehe.yanshi.tuling;

/**
 * Volatile可见性测试
 *
 * @author 刘伟锋
 * @date 2021/05/02
 **/
public class VolatileVisibilityTest {
    private static volatile  boolean initFlag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("Wait data ....");
            while (!initFlag) {

            }
            System.out.println("success");
        }).start();

        Thread.sleep(2000L);
        new Thread(() ->
                prepareData()).start();
    }

    private static void prepareData() {
        System.out.println("prepare Data begin");
        initFlag = true;
        System.out.println("prepare data end");
    }

}

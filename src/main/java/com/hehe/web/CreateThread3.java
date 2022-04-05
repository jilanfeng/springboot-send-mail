package com.hehe.web;



/**
 * @author 刘伟锋
 * @date 2020/12/22
 **/

/**
 *
 * 构造Thread的时候传入stackSize代表着该线程占用的stack大小
 *
 *
 *
 */
public class CreateThread3 {
    private static int counter = 1;

    public static void main(String[] args) {
        try {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                counter++;


                new Thread(() -> {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                ).start();
            }

        } catch (Error e) {
            System.out.println(counter);
        }
    }
}

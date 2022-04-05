package com.hehe.yanshi;

/**
 * @author 刘伟锋
 * @date 2021/05/01
 **/
public class Demo_02 {
    static User user1 = new User();
    static User user2 = new User();


    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            synchronized (user1) {
                try {
                    Thread.sleep(2000L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (user2) {
                    System.out.println("我获得了1和2");
                }
            }
        }).start();
        Thread.sleep(1000L);
        new Thread(() -> {
            synchronized (user2) {
                synchronized (user1) {
                    System.out.println("我获得了1和2");
                }
        }
        }).start();

    }

}

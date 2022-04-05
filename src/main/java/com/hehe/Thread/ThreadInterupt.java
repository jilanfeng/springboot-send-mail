package com.hehe.Thread;

/**
 * @author 刘伟锋
 * @date 2021/01/03
 **/
public class ThreadInterupt {

    private static final Object MONITOR = new Object();

    public static void main(String[] args) throws InterruptedException {
//        Thread t = new Thread() {
//            @Override
//            public void run() {
//                while (true) {
////                    System.out.println(">>>" + this.isInterrupted());
//
////                    try {
////                        Thread.sleep(10);
////                    } catch (InterruptedException e) {
////                        System.out.println("收到打断信号");
////                        e.printStackTrace();
////                    }
//                    synchronized (MONITOR) {
//                        try {
//                            MONITOR.wait(10);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//        };
//        t.start();
//        Thread.sleep(100);
//        System.out.println(t.isInterrupted());
//        t.interrupt();
//        System.out.println(t.isInterrupted());
//        t.stop();
//        new Thread(()-> {
//            while(true) {
//                synchronized (MONITOR) {
//                    try {
//                        MONITOR.wait(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                        System.out.println(Thread.interrupted());
//                    }
//                }
//            }
//        });

        Thread thread = new Thread() {

            @Override
            public void run() {
                while (true) {

                }

            }
        };
        thread.start();
        Thread main = Thread.currentThread();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                thread.interrupt();
                main.interrupt();
                System.out.println("interrupt");
            }
        };

        thread1.start();
        try {
            thread.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

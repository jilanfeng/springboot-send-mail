package com.hehe.Thread;

/**
 * @author εδΌι
 * @date 2021/01/03
 **/
public class ThreadCloseForce {

    private static class Worker extends Thread {
        @Override
        public void run() {
            while (true) {
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                   break;
//                }
                if (Thread.interrupted()) {
                    break;
                }
            }
            // --------
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.interrupt();
    }
}

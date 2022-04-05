package com.hehe.Thread;

import javafx.concurrent.Worker;

/**
 * @author 刘伟锋
 * @date 2021/01/03
 **/
public class ThreadCloseGraceful {

    private static class Worker extends Thread {
        private volatile boolean start = true;
        @Override
        public void run() {
            while(start) {
                //
            }
        }

        public void shutdown() {
            this.start = false;
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        worker.shutdown();
    }













}

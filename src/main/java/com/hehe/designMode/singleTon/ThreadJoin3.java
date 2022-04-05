package com.hehe.designMode.singleTon;

/**
 * @author 刘伟锋
 * @date 2021/01/01
 **/
public class ThreadJoin3 {
    public static void main(String[] args) throws InterruptedException {
       long startTimeStamp = System.currentTimeMillis();
        Thread t1 = new Thread(new CaptureRunnable("M1", 100000L));
        Thread t2 = new Thread(new CaptureRunnable("M2", 300000L));
        Thread t3 = new Thread(new CaptureRunnable("M3", 200000L));
        Thread t4 = new Thread(new CaptureRunnable("M4", 150000L));
        t1.start();
        t1.join();
//        t2.start();
//        t3.start();
        long endTImeStamp = System.currentTimeMillis();
        System.out.printf("startTimeStamp is %s,endTImeStamp is %s",startTimeStamp,endTImeStamp);

    }
}

class CaptureRunnable implements Runnable {
    private String machineName;
    private long spendTime;
    public CaptureRunnable(String machineName,long spendTime) {
        this.machineName=machineName;
        this.spendTime=spendTime;
    }

    @Override
    public void run() {
       // do the really data.
        try {
            Thread.sleep(spendTime);
            System.out.println(machineName+ "Compeleted");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getReuslt() {
        return machineName + " finish ";
    }
}



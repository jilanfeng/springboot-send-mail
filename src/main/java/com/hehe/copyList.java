package com.hehe;

import java.io.StreamCorruptedException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author 刘伟锋
 * @date 2021/05/01
 **/
public class copyList {

    private static volatile CopyOnWriteArrayList<String> stringCopyOnWriteArrayList = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        stringCopyOnWriteArrayList.add("你是等我");
        stringCopyOnWriteArrayList.add("梦的天行者");
        stringCopyOnWriteArrayList.add("无乐不作");
        stringCopyOnWriteArrayList.add("世界末日");
        Thread thread = new Thread(
                new Runnable() {

                    @Override
                    public void run() {
                        stringCopyOnWriteArrayList.set(1,"让你渴");
                        stringCopyOnWriteArrayList.remove(2);
                        stringCopyOnWriteArrayList.remove(3);
                    }
                }
        );
        stringCopyOnWriteArrayList.stream().map(s->s.equals("2533")).collect(Collectors.toList());;
        Iterator<String> itr = stringCopyOnWriteArrayList.iterator();

        thread.start();
        thread.join();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}

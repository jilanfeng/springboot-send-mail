package com.hehe.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author 刘伟锋
 * @date 2021/10/01
 **/
public class SyncList {
    public static void main(String[] args) throws InterruptedException {

//        /**
//         * part 1
//         */
//        List<String> strings = new ArrayList<>();
//         strings.add("A");
//         strings.add("B");
//         strings.add("C");
//         strings.add("D");
//         strings.add("E");
//         strings.add("F");
//         List<String> syncList = Collections.synchronizedList(strings);
//         System.out.println("Synchronized list is :"  + syncList );
//
//        /**
//         * part 2
//         */
//        List<Integer> lists = Arrays.asList(44,55,99,77,88,66);
//        List<Integer> coll = Collections.synchronizedList(lists);
//        System.out.println("Syncronized list is :" + coll);

        // part 3

        List<Integer> integers = new ArrayList<>();
        List<Integer> list = Collections.synchronizedList(integers);
        Collections.addAll(list,new Integer[10000]);
        System.out.println("Initial size: " + list.size());
        final ExecutorService e = Executors.newFixedThreadPool(10);

        for (int i =0;i<list.size();i++) {
            e.execute(()->list.remove(0));
        }
        e.shutdown();
        e.awaitTermination(1000, TimeUnit.SECONDS);
        System.out.println(list.size());



    }
}

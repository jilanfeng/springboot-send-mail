package com.hehe.collection;


import java.util.*;

/**
 * @author 刘伟锋
 * @date 2021/07/17
 **/
public class collectionShuffle {
    public static void main(String[] args) {
        shuffle();
    }

    public static void shuffle() {
        int[] sort = {1, 2, 3, 4, 5, 6, 7, 8};
        List sortList = new ArrayList();
        for (int i =0; i< sort.length; i++) {
            System.out.println(sort[i] + ",");
            sortList.add(sort[i]);
        }
        Collections.shuffle(sortList);

        Iterator ite = sortList.iterator();
        System.out.println("乱序后的顺序：");
        while (ite.hasNext()) {
            System.out.println(ite.next().toString());
        }

        Collections.sort(sortList, (Integer o1, Integer o2) -> o2 - o1);

        Iterator it = sortList.iterator();
        System.out.println(
                "排序后的顺序：");
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }

    }

}

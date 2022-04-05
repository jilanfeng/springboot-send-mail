package com.hehe.web;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class MailController {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> stringCopyOnWriteArrayList = new CopyOnWriteArrayList<>();
        stringCopyOnWriteArrayList.add("hello");
        stringCopyOnWriteArrayList.add("无乐不作");
        Iterator<String> iterator = stringCopyOnWriteArrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

//弱一致性，指的是其他线程对list的修改是不可见的



    }

}

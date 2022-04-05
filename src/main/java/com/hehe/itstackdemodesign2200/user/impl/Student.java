package com.hehe.itstackdemodesign2200.user.impl;

import com.hehe.itstackdemodesign2200.user.User;
import com.hehe.itstackdemodesign2200.visitor.Visitor;

/**
 * @author 刘伟锋
 * @date 2021/12/18
 **/
public class Student extends User {
    public Student(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     *
     * @return
     */
   public int ranking() {
       return (int)(Math.random() * 100);
   }

    public static void main(String[] args) {
        double v1 = Math.random();
        int v = (int)(Math.random() * 100);
        System.out.println(v);
        System.out.println(v1);
    }
}

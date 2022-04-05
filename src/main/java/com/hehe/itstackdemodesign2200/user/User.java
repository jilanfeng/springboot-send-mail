package com.hehe.itstackdemodesign2200.user;

import com.hehe.itstackdemodesign2200.visitor.Visitor;
import lombok.AllArgsConstructor;

/**
 * @author 刘伟锋
 * @date 2021/12/18
 **/
public abstract class User {
    public String name;
    public String identity;
    public String clazz;


    public User(String name, String identity, String clazz) {
            this.name = name;
            this.identity = identity;
            this.clazz = clazz;
    }

    public abstract void accept(Visitor visitor);



}

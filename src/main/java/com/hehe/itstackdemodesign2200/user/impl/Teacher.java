package com.hehe.itstackdemodesign2200.user.impl;

import com.hehe.itstackdemodesign2200.user.User;
import com.hehe.itstackdemodesign2200.visitor.Visitor;

import java.math.BigDecimal;

/**
 * @author 刘伟锋
 * @date 2021/12/18
 **/
public class Teacher extends User {

    public Teacher(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * 升本率
     *
     * @return
     */
    public double entranceRatio() {
        return BigDecimal.valueOf(Math.random() * 100).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}

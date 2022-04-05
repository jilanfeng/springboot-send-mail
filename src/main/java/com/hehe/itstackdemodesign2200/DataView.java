package com.hehe.itstackdemodesign2200;

import com.hehe.itstackdemodesign2200.user.User;
import com.hehe.itstackdemodesign2200.user.impl.Student;
import com.hehe.itstackdemodesign2200.user.impl.Teacher;
import com.hehe.itstackdemodesign2200.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘伟锋
 * @date 2021/12/18
 **/
public class DataView {

    List<User> userList = new ArrayList<>();

    public DataView() {

        userList.add(new Student("贾玲","重点班","二年三班"));
        userList.add(new Student("范丞丞","重点班","一年一班"));
        userList.add(new Student("杨迪","普通班","二年四班"));
        userList.add(new Student("杨洋","普通班","一年三班"));
        userList.add(new Teacher("宋小宝","特级教师","二年三班"));
        userList.add(new Teacher("汪苏泷","特级教师","一年一班"));
        userList.add(new Teacher("周深","普通教师","二年四班"));
        userList.add(new Teacher("朗朗","实习教师","一年三班"));
    }

    // 展示
    public void show(Visitor visitor) {
        for (User user : userList) {
            user.accept(visitor);
        }
    }

}

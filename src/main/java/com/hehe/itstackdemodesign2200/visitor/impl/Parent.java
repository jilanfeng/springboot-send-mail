package com.hehe.itstackdemodesign2200.visitor.impl;

import com.hehe.itstackdemodesign2200.user.impl.Student;
import com.hehe.itstackdemodesign2200.user.impl.Teacher;
import com.hehe.itstackdemodesign2200.visitor.Visitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 刘伟锋
 * @date 2021/12/18
 **/
public class Parent implements Visitor {

    private Logger logger = LoggerFactory.getLogger(Parent.class);

    @Override
    public void visit(Teacher teacher) {
        logger.info("教师姓名 姓名:{},班级:{}", teacher.name , teacher.clazz);
    }

    @Override
    public void visit(Student student) {
        logger.info("学生姓名 姓名:{},班级:{},排名:{}", student.name , student.clazz , student.ranking() );
    }
}

package com.hehe.itstackdemodesign2200.visitor;

import com.hehe.itstackdemodesign2200.user.impl.Student;
import com.hehe.itstackdemodesign2200.user.impl.Teacher;

/**
 * @author 刘伟锋
 * @date 2021/12/18
 **/
public interface Visitor {

    /**
     * 访问教师信息
     *
     * @param teacher 教师信息
     */
    void visit(Teacher teacher);


    /**
     * 访问学生信息
     *
     * @param student 学生信息
     */
    void visit(Student student);

}

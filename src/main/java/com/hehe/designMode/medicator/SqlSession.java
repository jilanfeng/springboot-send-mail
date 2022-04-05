package com.hehe.designMode.medicator;

import java.util.List;

/**
 * 定义了数据库操作的查询接口，分为查询一个结果和多个结果，同时包括优参数和 没有参数的方法
 *
 *
 * @author 刘伟锋
 * @date 2022/02/21
 **/
public interface SqlSession {
    <T> T selectOne(String statement);

    <T> T selectOne(String statement, Object parameter);

    <T> List<T> selectList(String statement);

    <T> List<T> selectList(String statement, Object parameter);

    void close();
}

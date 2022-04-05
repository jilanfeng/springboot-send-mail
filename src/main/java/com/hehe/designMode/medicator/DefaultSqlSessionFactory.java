package com.hehe.designMode.medicator;

/**
 * @author 刘伟锋
 * @date 2022/02/21
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration.connection,configuration.mapperElement);
    }
}

package com.hehe.designMode.medicator;

import java.sql.Connection;
import java.util.Map;

/**
 * @author 刘伟锋
 * @date 2022/02/21
 **/
public class Configuration {

    protected Connection connection;

    protected Map<String,String> dataSource;

    protected Map<String,XNode> mapperElement;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setDataSource(Map<String, String> dataSource) {
        this.dataSource = dataSource;
    }

    public void setMapperElement(Map<String, XNode> mapperElement) {
        this.mapperElement = mapperElement;
    }
}

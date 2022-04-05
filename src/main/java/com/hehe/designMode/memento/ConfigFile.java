package com.hehe.designMode.memento;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 刘伟锋
 * @date 2022/02/22
 **/
public class ConfigFile implements Serializable {
    /**
     * 版本号
     */
    private String version;

    /**
     * 内容
     */
    private String content;

    /**
     * 时间
     */
    private Date dateTime;

    /**
     * 操作人
     */
    private String operator;

    public ConfigFile(String version, String content, Date dateTime, String operator) {
        this.version = version;
        this.content = content;
        this.dateTime = dateTime;
        this.operator = operator;
    }


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}

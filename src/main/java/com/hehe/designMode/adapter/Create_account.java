package com.hehe.designMode.adapter;

import java.util.Date;

/**
 * @author 刘伟锋
 * @date 2022/02/24
 **/
public class Create_account {
    /**
     * 开户编号
     */
    private String number;

    /**
     * 开户地
     */
    private String address;

    /**
     * 开户描述
     */
    private String desc;

    /**
     * 开户时间
     */
    private Date accountDate;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
    }
}

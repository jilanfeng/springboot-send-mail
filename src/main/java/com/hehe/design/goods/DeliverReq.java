package com.hehe.design.goods;

/**
 * @author 刘伟锋
 * @date 2021/10/04
 **/
public class DeliverReq {

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户手机
     */
    private String userPhone;

    /**
     * 商品SKU
     */
    private String sku;
    /**
     * 订单Id
     */
    private String orderId;
    /**
     * 收货人姓名
     */
    private String consigneeUserName;
    /**
     * 收货人手机
     */
    private String consigneeUserPhone;
    /**
     * 收货人地址
     */
    private String consigneeUserAddress;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getConsigneeUserName() {
        return consigneeUserName;
    }

    public void setConsigneeUserName(String consigneeUserName) {
        this.consigneeUserName = consigneeUserName;
    }

    public String getConsigneeUserPhone() {
        return consigneeUserPhone;
    }

    public void setConsigneeUserPhone(String consigneeUserPhone) {
        this.consigneeUserPhone = consigneeUserPhone;
    }

    public String getConsigneeUserAddress() {
        return consigneeUserAddress;
    }

    public void setConsigneeUserAddress(String consigneeUserAddress) {
        this.consigneeUserAddress = consigneeUserAddress;
    }
}

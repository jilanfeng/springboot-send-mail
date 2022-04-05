package com.hehe.design.coupon;

import lombok.Data;

/**
 * @author 刘伟锋
 * @date 2021/10/04
 **/
@Data
public class CouponResult {

    /**
     * 编码
     */
    private String code;

    /**
     * 描述
     */
    private String info;

    public CouponResult(String code, String info) {
        this.code = code;
        this.info = info;
    }
}

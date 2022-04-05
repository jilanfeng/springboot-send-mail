package com.hehe.bankannation;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 刘伟锋
 * @date 2021/10/06
 **/
@Data
@BankAPI(url = "/bank/pay",desc="支付接口")
public class PayAPI extends AbstractAPI {
    @BankAPIField(order= 1,type = BankApiFiledType.N,length = 20)
    private long userId;

    @BankAPIField(order =2 ,type = BankApiFiledType.M,length = 10)
    private BigDecimal amount;
}

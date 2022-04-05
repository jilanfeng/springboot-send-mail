package com.hehe.bankannation;

import lombok.Data;

/**
 * @author 刘伟锋
 * @date 2021/10/06
 **/
@Data
@BankAPI(url = "/bank/createUser",desc="创建用户接口")
public class CreateUserAPI extends AbstractAPI {

    @BankAPIField(order=1,type=BankApiFiledType.S,length=10)
    private String name;

    @BankAPIField(order = 2,type= BankApiFiledType.S,length =10)
    private String identity;

    @BankAPIField(order =4,type=BankApiFiledType.S,length = 11)
    private String mobile;

    @BankAPIField(order = 3,type=BankApiFiledType.N,length = 5)
    private int age;
}

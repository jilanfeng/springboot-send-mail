package com.hehe.istackdemodesign1802;

/**
 * 小汽车指标调控服务
 *
 * @author 刘伟锋
 * @date 2022/01/03
 **/
public class MinibusTargetService {

    /**
     * 模拟摇号，但不是摇号算法
     *
     * @param uId 用户编码
     * @return 结果
     */

    public String lottery(String uId) {

        return Math.abs(uId.hashCode()) % 2 == 0 ? "恭喜你，编码".concat("在本次摇号中中签") :
                "很遗憾,编码".concat("在本次摇号未中签或摇号资格已过期");
    }

}

package com.hehe.gos;

/**
 * @author εδΌι
 * @date 2021/10/06
 **/
public class StrategyEnumTest {
    public static void main(String[] args) {
        System.out.println(StrategyEnum.ADD.exec(5, 6));
        System.out.println(StrategyEnum.SUB.exec(5, 6));
        System.out.println(StrategyEnum.MUTI
                .exec(5, 6));
    }
}

package com.hehe.bankannation;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author 刘伟锋
 * @date 2021/10/06
 **/
public enum BankApiFiledType {
   S {
       @Override
       public String format(Object value, BankAPIField bankAPIField) {
           return String.format("%_" + bankAPIField.length() + "s",value.toString()).replace(' ','_');
       }
   },
   N{
       @Override
       public String format(Object value, BankAPIField bankAPIField) {
           return String.format("%" + bankAPIField.length() + "s",value.toString()).replace(' ','0');
       }
   },
    M {
        @Override
        public String format(Object value, BankAPIField bankAPIField) {
            if(!(value instanceof BigDecimal)) {
                throw new RuntimeException(String.format("{} 的{} 必须是BigDecimal"));
            }
            return String.format(String.format("%O" + bankAPIField.length() + "d",((BigDecimal)value).setScale(2, RoundingMode.DOWN)
                    .multiply(new BigDecimal("100")).longValue()));
        }
    };


    public abstract String format(Object value, BankAPIField bankAPIField);


}
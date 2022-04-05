package com.hehe.gos;

import lombok.Getter;

/**
 * @author 刘伟锋
 * @date 2021/10/06
 **/
@Getter
public enum StrategyEnum {
  ADD("+") {
      @Override
      public int exec(int a, int b) {
          return a + b;
      }
  },
    SUB("_") {
        @Override
        public int exec(int a, int b) {
        return a-b;
        }
    },

    MUTI("*") {
        @Override
        public int exec(int a, int b) {
            return a*b;
        }
    },
    ;


    StrategyEnum(String value) {
        this.value = value;
    }

    private String value;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public abstract int exec(int a,int b);

}

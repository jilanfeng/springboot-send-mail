package com.hehe.yanshi.tuling;

/**
 * 双重检测锁
 *
 * @author 刘伟锋
 * @date 2021/05/03
 **/
public class DoubleCheckLockSingLeton {
    private static DoubleCheckLockSingLeton instance = null;
    private DoubleCheckLockSingLeton() {

    }

//    10 monitorenter
//11 getstatic #2 <com/hehe/yanshi/tuling/DoubleCheckLockSingLeton.instance>
//            14 ifnonnull 27 (+13)
//            17 new #3 <com/hehe/yanshi/tuling/DoubleCheckLockSingLeton>
//            20 dup
//21 invokespecial #4 <com/hehe/yanshi/tuling/DoubleCheckLockSingLeton.<init>>
//            24 putstatic #2 <com/hehe/yanshi/tuling/DoubleCheckLockSingLeton.instance>
//            27 aload_0
//28 monitorexit



//    24跟21重排序
    public static DoubleCheckLockSingLeton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLockSingLeton.class) {
                if (instance == null) {
                    instance = new DoubleCheckLockSingLeton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        DoubleCheckLockSingLeton instacne = DoubleCheckLockSingLeton.getInstance();
    }
}

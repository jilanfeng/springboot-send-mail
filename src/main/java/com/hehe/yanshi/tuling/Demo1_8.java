package com.hehe.yanshi.tuling;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * 演示元空間内存溢出
 * <p>
 * -XX:MaxMetaSpaceSize=8m
 *
 * @author 刘伟锋
 * @date 2021/05/13
 **/
public class Demo1_8 extends ClassLoader {  //可以用來加載類的二進制字節碼
    public static void main(String[] args) {
        int j = 0;
        try {
            Demo1_8 test = new Demo1_8();
            for (int i = 0; i < 100000; i++, j++) {
                //classWriter 作用是生成類的二進制字節碼
                ClassWriter classWriter = new ClassWriter(0);
                //版本號，public，類名，包名，父類，接口
                classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
                //返回byte[]
                byte[] code = classWriter.toByteArray();
                //執行類的加載
                test.defineClass("Class" + i,code,0,code.length);//class對象

            }
        } finally {
            System.out.println(j);
        }


    }
}











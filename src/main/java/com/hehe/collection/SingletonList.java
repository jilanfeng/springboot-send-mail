package com.hehe.collection;


import java.util.*;

/**
 * @author 刘伟锋
 * @date 2021/10/01
 **/
public class SingletonList {
    public static void main(String[] args) {

//        /**
//         * part 1
//         */
//        List<Integer>  numList = Collections.singletonList(10);
//        System.out.println("Number List element:" + numList);
////        numList.add(20);
//        List<String> strList = Collections.singletonList("Hello India");
//        System.out.println("String List elements：" + strList);

//

        /**
         * part 3
         */

        System.out.println("Enter the value ; ");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println("Output :" + Collections.singletonList(i));
        sc.close();


    }

}

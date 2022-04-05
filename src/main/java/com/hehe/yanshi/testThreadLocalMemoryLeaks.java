package com.hehe.yanshi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘伟锋
 * @date 2021/05/08
 **/
public class testThreadLocalMemoryLeaks {
    public static void main(String[] args) {

        ThreadLocal<List<Integer>> localCache = new ThreadLocal<>();
        List<Integer> cacheInstance = new ArrayList<>(10000);
        localCache.set(cacheInstance);
        localCache = new ThreadLocal<>();
//        localCache.remove();
    }
}

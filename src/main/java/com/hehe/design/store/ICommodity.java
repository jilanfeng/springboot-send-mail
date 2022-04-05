package com.hehe.design.store;

import java.util.Map;

/**
 * @author 刘伟锋
 * @date 2021/10/04
 **/
public interface ICommodity {
    /**
     * 定义发奖接口
     *
     * @param uid
     * @param commodityId
     * @param bizId
     * @param extMap
     * @throws Exception
     */
     void sendCommodity(String uid, String commodityId, String bizId, Map<String,String> extMap) throws Exception;
}

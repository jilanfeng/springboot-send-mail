package com.hehe.design.goods;

import com.alibaba.fastjson.JSON;

/**
 * 模拟实物商品服务
 *
 * @author 刘伟锋
 * @date 2021/10/04
 **/
public class GoodsService {
public Boolean deliverGoods(DeliverReq req) {

    System.out.println("模拟发放实物商品一个:" + JSON.toJSONString(req));
    return true;
  }
}


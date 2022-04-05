package com.hehe.designMode.adapter;

/**
 * 内部商品接口
 *
 * @author 刘伟锋
 * @date 2022/02/24
 **/
public class InsideOrderService implements OrderAdapterService {
    private OrderService orderService = new OrderService();

    @Override
    public boolean isFirst(String uId) {
        return orderService.queryUserOrderCount(uId) <= 1;
    }
}

package com.hehe.designMode.adapter;

/**
 * 第三商品接口
 *
 * @author 刘伟锋
 * @date 2022/02/24
 **/
public class POPOrderAdapterServiceImpl implements OrderAdapterService {
    private POPOrderService popOrderService = new POPOrderService();

    @Override
    public boolean isFirst(String uId) {
        return popOrderService.isFirstOrder(uId);
    }
}

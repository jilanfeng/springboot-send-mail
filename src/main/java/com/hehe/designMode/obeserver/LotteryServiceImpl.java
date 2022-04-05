package com.hehe.designMode.obeserver;

import com.hehe.istackdemodesign1802.LotteryResult;

import java.util.Date;

/**
 * @author 刘伟锋
 * @date 2022/02/23
 **/
public class LotteryServiceImpl extends LotteryService {
    private MinibusTargetService minibusTargetService = new MinibusTargetService();

    @Override
    protected LotteryResult doDraw(String uId) {
        //摇号
        String lottery = minibusTargetService.lottery(uId);

        //结果
        return new LotteryResult(uId, lottery, new Date());
    }
}

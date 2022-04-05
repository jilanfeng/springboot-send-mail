package com.hehe.designMode.commcand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 命令模式的使用场景要分为比较大的快：命令，实现，调用者，而这三块内容的拆分也是选择适合场景的关键因素，经过这样的拆分可以让逻辑具备单一职责的性质，便于拓展
 *
 *
 * @author 刘伟锋
 * @date 2022/02/20
 **/
public class XiaoEr {
    private Logger logger = LoggerFactory.getLogger(XiaoEr.class);

    private List<ICusisine> cusisineList = new ArrayList<ICusisine>();

    public void order(ICusisine cusisine) {
        cusisineList.add(cusisine);
    }


    public synchronized  void placeOrder() {
        for (ICusisine iCusisine : cusisineList) {
            iCusisine.cook();
        }
        cusisineList.clear();
    }
}

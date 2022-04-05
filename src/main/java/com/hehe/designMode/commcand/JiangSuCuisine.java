package com.hehe.designMode.commcand;

/**
 * @author 刘伟锋
 * @date 2022/02/20
 **/
public class JiangSuCuisine implements ICusisine {
    private ICook cook;

    public JiangSuCuisine(ICook cook) {
        this.cook = cook;
    }

    @Override
    public void cook() {
        cook.doCooking();
    }
}

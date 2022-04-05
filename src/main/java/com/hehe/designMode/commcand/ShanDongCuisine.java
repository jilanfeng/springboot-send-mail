package com.hehe.designMode.commcand;

/**
 * @author 刘伟锋
 * @date 2022/02/20
 **/
public class ShanDongCuisine implements ICusisine {

    private ICook cook;

    public ShanDongCuisine(ICook cook) {
        this.cook = cook;
    }

    @Override
    public void cook() {
        cook.doCooking();
    }
}

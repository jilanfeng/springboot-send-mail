package com.hehe.designMode.commcand;

/**
 * @author εδΌι
 * @date 2022/02/20
 **/
public class SichuanCuisine implements ICusisine {

    private ICook cook;

    public SichuanCuisine(ICook cook) {
        this.cook = cook;
    }

    @Override
    public void cook() {
     cook.doCooking();
    }
}

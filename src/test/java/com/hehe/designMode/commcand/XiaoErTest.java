package com.hehe.designMode.commcand;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 刘伟锋
 * @date 2022/02/20
 **/
@SpringBootTest
class XiaoErTest {

    @Test
    void test() {
        // 菜系 + 厨师 ;广东（粤菜）,江苏（苏菜），山东（鲁菜），四川（川菜）
        ICusisine guangDongCuisine = new GuangDongCuisine(new GuaangDongCook());
        JiangSuCuisine jiangSuCuisine = new JiangSuCuisine(new JiangsuCook());
        ShanDongCuisine shanDongCuisine = new ShanDongCuisine(new ShanDongCook());
        SichuanCuisine sichuanCuisine = new SichuanCuisine(new SiChuanCook());


        //点单
        XiaoEr xiaoEr = new XiaoEr();
        xiaoEr.order(guangDongCuisine);
        xiaoEr.order(jiangSuCuisine);
        xiaoEr.order(shanDongCuisine);
        xiaoEr.order(sichuanCuisine);

        //下单
        xiaoEr.placeOrder();

    }

}
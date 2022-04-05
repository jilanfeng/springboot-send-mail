package com.hehe.maptosolveifelse;

import org.springframework.stereotype.Service;

/**
 * @author 刘伟锋
 * @date 2022/02/10
 **/
@Service
public class GrantTypeSerive {

    public String redPaper(String resourceId) {
        //红包的发放方式
        return "每周末九点发放";
    }


    public String shopping(String resourceId) {
        //购物券的发放方式
        return "每周三九点发放";
    }

    public String QQVIPr(String resourceId) {
        //qq会员的发放方式
        return "每周一零点发放";
    }

}

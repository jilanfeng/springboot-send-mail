package com.hehe.maptosolveifelse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘伟锋
 * @date 2022/02/11
 **/
@RestController
public class GrantTypeController {

    @Autowired
    private QueryGrantService queryGrantService;

    @PostMapping("/grantType")
    public String test(String resourceName) {
        return queryGrantService.getResult(resourceName);
    }
}

package com.hehe.maptosolveifelse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author εδΌι
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

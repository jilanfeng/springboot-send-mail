package com.hehe.gos;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘伟锋
 * @date 2021/10/06
 **/
@Slf4j
@RestController
@RequestMapping("/api/driverReturn")
public class DriveReturnAppController {

    @PostMapping("/getDriverReturnInfo")
    public String getDriveReturnInfo(@RequestBody @Validated(DriverReturnAppDTO.ReturnQuery.class) DriverReturnAppDTO driverReturnAppDTO) {
        log.info("入参：{}", JSON.toJSONString(driverReturnAppDTO));
        //todo 实现逻辑
        return null;
    }


    @PostMapping("/pullDown")
    public String pullDown(@RequestBody @Validated(DriverReturnAppDTO.PullDown.class) DriverReturnAppDTO driverReturnAppDTO) {
        log.info("DriverReturnApp pullDown传入参数: {}", JSON.toJSONString(driverReturnAppDTO));
        //todo 实现逻辑
        return null;
    }

    @PostMapping("/returnScan")
    public String returnScan(@RequestBody @Validated(DriverReturnAppDTO.ReturnScan.class) DriverReturnAppDTO driverReturnAppDTO) {
        log.info("returnScan 入参:{}",JSON.toJSONString(driverReturnAppDTO));
        return null;
    }
}

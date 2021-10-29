package com.cmj.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.cmj.example.aspect.ValidateToken;
import com.cmj.example.vo.UserParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/28
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @GetMapping("/aspect")
    @ValidateToken(token = "#token", appId = "#appId", channelId = "#channelId")
    public String aspect(@RequestHeader(name = "access_token", required = true) String token,
                         @RequestHeader(name = "app_id", required = true) String appId,
                         @RequestHeader(name = "channel_id", required = true) String channelId) {
        log.info("into /test/aspect");

        return "success";
    }

    @PostMapping("/aspect2")
    @ValidateToken(token = "#token", appId = "#appId", channelId = "#channelId", userId = "#userParam.userId")
    public String aspect2(@RequestHeader(name = "access_token", required = true) String token,
                          @RequestHeader(name = "app_id", required = true) String appId,
                          @RequestHeader(name = "channel_id", required = true) String channelId,
                          @RequestBody UserParam userParam) {
        log.info("into /test/aspect");
        if (userParam.getNum() == 0) {
            throw new RuntimeException("123");
        }
        return "success";
    }

    @PostMapping("/jsr303")
    public String aspect3(@RequestBody @Valid UserParam userParam) {
        String res = JSONObject.toJSONString(userParam);
        log.info(res);
        return res;
    }
}

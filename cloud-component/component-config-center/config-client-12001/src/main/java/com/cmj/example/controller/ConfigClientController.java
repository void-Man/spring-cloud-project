package com.cmj.example.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/28
 */
@RestController
@RequestMapping("/configClient")
@RefreshScope
public class ConfigClientController {

    @Value("${server.env}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return JSONObject.toJSONString(configInfo);
    }
}

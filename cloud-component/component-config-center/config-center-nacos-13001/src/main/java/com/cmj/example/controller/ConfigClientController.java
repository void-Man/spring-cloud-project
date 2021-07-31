package com.cmj.example.controller;

import cn.hutool.core.map.MapBuilder;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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

    @Value("${server.port}")
    private String port;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        Map<String, Object> map = MapBuilder.<String, Object>create().put("port", port).put("configInfo", configInfo).build();
        return JSONObject.toJSONString(map);
    }
}

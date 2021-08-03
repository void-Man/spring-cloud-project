package com.cmj.example.controller;

import cn.hutool.core.map.MapBuilder;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
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
public class ConfigClientController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        Map<String, Object> map = MapBuilder.<String, Object>create().put("port", port).build();
        return JSONObject.toJSONString(map);
    }
}

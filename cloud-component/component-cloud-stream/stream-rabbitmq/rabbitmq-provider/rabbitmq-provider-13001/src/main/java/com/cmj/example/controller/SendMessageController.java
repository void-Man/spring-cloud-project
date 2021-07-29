package com.cmj.example.controller;

import cn.hutool.core.map.MapBuilder;
import com.alibaba.fastjson.JSONObject;
import com.cmj.example.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/29
 */
@RestController
@RequestMapping("/message")
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/send")
    public String sendMessage() {
        String msg = messageProvider.send();
        return JSONObject.toJSONString(MapBuilder.<String, Object>create().put("msg", msg).build());
    }


}

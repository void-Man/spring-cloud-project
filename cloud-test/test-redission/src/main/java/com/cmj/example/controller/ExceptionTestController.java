package com.cmj.example.controller;

import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/28
 */
@RestController
@RequestMapping("redission")
public class ExceptionTestController {

    @Resource
    private RedissonClient redissonClient;

    @GetMapping("/test1")
    public String test1() {
        redissonClient.getLock("123").lock();
        return "";
    }
}

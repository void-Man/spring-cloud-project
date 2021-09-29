package com.cmj.example.controller;

import cn.hutool.core.util.RandomUtil;
import com.cmj.example.service.ThreadLocalService;
import com.cmj.example.utils.RuntimeContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author mengjie_chen
 * @description
 * @date 2021/9/29
 */
@RestController
@RequestMapping("threadLocal")
@Slf4j
public class ThreadLocalController {

    @Resource
    private ThreadLocalService threadLocalService;

    @GetMapping("/testSet")
    public String testSet() {
        int i = RandomUtil.getRandom().nextInt(100);
        log.info("{} -----> set value {}", Thread.currentThread().getName(), i);
        RuntimeContextUtil.setParam(String.valueOf(i));
        threadLocalService.testSet();
        return "success";
    }

}

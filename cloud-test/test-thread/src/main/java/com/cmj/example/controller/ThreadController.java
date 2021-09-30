package com.cmj.example.controller;

import com.cmj.example.service.ThreadLocalService;
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
@RequestMapping("/thread")
@Slf4j
public class ThreadController {

    @Resource
    private ThreadLocalService threadLocalService;

    @GetMapping("/addTask")
    public String addTask() {
        threadLocalService.addTask();
        return "success";
    }

    @GetMapping("/addCallbackTask")
    public String addCallbackTask() {
        threadLocalService.addCallbackTask();
        return "success";
    }

}

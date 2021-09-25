package com.cmj.example.controller;

import com.cmj.example.exception.BusinessException;
import com.cmj.example.vo.ExceptionUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/28
 */
@RestController
@RequestMapping("exception")
public class ExceptionTestController {

    @GetMapping("/test1")
    public String test1() {
        throw new RuntimeException("test1 throw");
    }

    @GetMapping("/test2")
    public String test2() {
        throw new BusinessException(10000, "test2 throw");
    }

    @GetMapping("/test3")
    public String test3(String id) {
        return Optional.ofNullable(id).orElseThrow(() -> ExceptionUtil.throwBusinessException(10001, "haha"));
    }
}

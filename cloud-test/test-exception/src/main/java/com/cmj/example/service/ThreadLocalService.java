package com.cmj.example.service;

import com.cmj.example.utils.RuntimeContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/9/29
 */
@Component
@Slf4j
public class ThreadLocalService {

    public void testSet() {
        String param = RuntimeContextUtil.getParam();
        log.info("{} -----> get value {}", Thread.currentThread().getName(), param);
    }
}

package com.cmj.example.interceptor;

import com.cmj.example.manager.CallbackExecuteTaskManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/10/31
 */
@Component
@Slf4j
public class ApplicationShutdownListener implements ApplicationListener<ContextClosedEvent> {
    @Resource
    private CallbackExecuteTaskManager taskManager;

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        log.info("关闭容器");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

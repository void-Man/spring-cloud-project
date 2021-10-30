package com.cmj.example;

import com.cmj.example.manager.CallbackExecuteTaskManager;
import com.cmj.example.manager.ExecutorServiceManager;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/17
 */
@SpringBootApplication
@Slf4j
@MapperScan("com.cmj.example.*")
public class ThreadTester {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ThreadTester.class, args);

    }
}

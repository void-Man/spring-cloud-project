package com.cmj.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/11
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.cmj.example.*")
public class PamentApplication8009 {
    public static void main(String[] args) {
        SpringApplication.run(PamentApplication8009.class, args);
    }
}

package com.cmj.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/11
 */
@SpringBootApplication
@MapperScan("com.cmj.example.*")
@EnableEurekaClient
@EnableCircuitBreaker
public class PamentApplication8007 {
    public static void main(String[] args) {
        SpringApplication.run(PamentApplication8007.class, args);
    }
}

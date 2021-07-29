package com.cmj.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/17
 */
@SpringBootApplication
@EnableEurekaClient
public class RabbitmqConsumer14003 {
    public static void main(String[] args) {
        SpringApplication.run(RabbitmqConsumer14003.class, args);
    }
}

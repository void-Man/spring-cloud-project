package com.cmj.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/14
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class PaymentConsumer9006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsumer9006.class, args);
    }
}

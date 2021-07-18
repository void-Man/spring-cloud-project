package com.cmj.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/14
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentConsumer9002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsumer9002.class, args);
    }
}

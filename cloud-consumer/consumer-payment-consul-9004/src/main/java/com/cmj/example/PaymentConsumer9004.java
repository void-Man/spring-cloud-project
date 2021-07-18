package com.cmj.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/14
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsumer9004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsumer9004.class, args);
    }
}

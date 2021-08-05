package com.cmj.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/14
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class PaymentConsumer9010 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsumer9010.class, args);
    }
}

package com.cmj.example;

import com.cmj.rule.SelfLoadBalance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/14
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "provider-payment-eureka", configuration = SelfLoadBalance.class)
public class PaymentConsumer9005 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsumer9005.class, args);
    }
}

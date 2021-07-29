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
public class ConfigClient12001 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient12001.class, args);
    }
}

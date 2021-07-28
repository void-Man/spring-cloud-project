package com.cmj.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/17
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigCenter11001 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenter11001.class, args);
    }
}

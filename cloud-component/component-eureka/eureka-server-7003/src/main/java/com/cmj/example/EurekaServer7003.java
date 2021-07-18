package com.cmj.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/17
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7003 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7003.class, args);
    }

}

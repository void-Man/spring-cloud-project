package com.cmj.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/17
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClient13001 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClient13001.class, args);
    }
}

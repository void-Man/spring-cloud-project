package com.cmj.example;


import com.dtflys.forest.springboot.annotation.ForestScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/14
 */
@SpringBootApplication
@ForestScan(basePackages = "com.cmj.example.http")
public class ForestConsumer9011 {
    public static void main(String[] args) {
        SpringApplication.run(ForestConsumer9011.class, args);
    }
}

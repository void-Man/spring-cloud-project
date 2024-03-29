package com.cmj.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/11
 */
@SpringBootApplication
@MapperScan("com.cmj.example.*")
public class PamentApplication8001 {
    public static void main(String[] args) {
        SpringApplication.run(PamentApplication8001.class, args);
    }
}

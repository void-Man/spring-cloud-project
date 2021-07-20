package com.cmj.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/20
 */
@Configuration
public class SelfLoadBalance {
    @Bean
    public IRule loadBalance() {
        return new RandomRule();//定义为随机
    }
}

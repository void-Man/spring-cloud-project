package com.cmj.example.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.setTransportMode(TransportMode.EPOLL);
        config.useClusterServers().addNodeAddress("redis://192.168.198.153:6379");
        return Redisson.create(config);
    }

}

package com.cmj.example.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/23
 */
@Configuration
public class GatewayConfig {

    /**
     * 配置了一个id为payment_routh_01的路由规则，当访问地址 http://localhost:10001/eureka/payment/getByTradeNo 时会自动转发到地址：http://localhost:8007/eureka/payment/getByTradeNo
     *
     * @param builder
     * @return org.springframework.cloud.gateway.route.RouteLocator
     * @author mengjie_chen
     * @date 2021/7/23
     */
    @Bean
    public RouteLocator customRouteLocator_01(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        ZonedDateTime dateTime = ZonedDateTime.of(LocalDateTime.of(2021, 7, 24, 23, 50, 0), ZoneId.systemDefault());
        routes.route("payment_routh_01", r -> r.path("/eureka/payment/getByTradeNo").and().after(dateTime).uri("http://localhost:8007")).build();
        return routes.build();
    }

    /**
     * 配置了一个id为payment_routh_02的路由规则，当访问地址 http://localhost:10001/eureka/payment/getCircuitBreaker 时会自动转发到地址：http://localhost:8007/eureka/payment/getCircuitBreaker
     *
     * @param builder
     * @return org.springframework.cloud.gateway.route.RouteLocator
     * @author mengjie_chen
     * @date 2021/7/23
     */
    @Bean
    public RouteLocator customRouteLocator_02(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("payment_routh_02", r -> r.path("/eureka/payment/getCircuitBreaker").uri("http://localhost:8007")).build();
        return routes.build();
    }

    public static void main(String[] args) {
        ZonedDateTime dateTime = ZonedDateTime.of(LocalDateTime.of(2022, 7, 24, 23, 50, 0), ZoneId.systemDefault());
        System.out.println(dateTime);
    }
}

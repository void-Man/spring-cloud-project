package com.cmj.example.service;

import com.cmj.example.vo.CommonResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/21
 */
@Component
@FeignClient(name = "provider-payment-nacos", fallback = PaymentFeignFallbackService.class)
public interface IPaymentFeignService {

    @GetMapping("/nacos/getByTradeNoTimeout")
    CommonResultVo<?> getByTradeNo(@RequestParam("tradeNo") String tradeNo);
}

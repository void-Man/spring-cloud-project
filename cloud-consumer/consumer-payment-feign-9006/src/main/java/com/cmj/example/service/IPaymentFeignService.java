package com.cmj.example.service;

import com.cmj.example.vo.CommonResultVo;
import com.cmj.example.vo.PaymentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/21
 */
@Component
@FeignClient(name = "provider-payment-eureka")
public interface IPaymentFeignService {

    @PostMapping("/eureka/payment/create")
    CommonResultVo<?> create(@RequestBody PaymentDto paymentDto);

    @GetMapping("/eureka/payment/getByTradeNo")
    CommonResultVo<?> getByTradeNo(@RequestParam("tradeNo") String tradeNo);
}

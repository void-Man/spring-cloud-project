package com.cmj.example.controller;

import com.cmj.example.service.IPaymentFeignService;
import com.cmj.example.vo.CommonResultVo;
import com.cmj.example.vo.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/14
 */
@RestController
public class OrderController {

    @Autowired
    private IPaymentFeignService paymentFeignService;

    @PostMapping("/consumer/feign/payment/create")
    public CommonResultVo<?> create(@RequestBody PaymentDto paymentDto) {
        return paymentFeignService.create(paymentDto);
    }

    @GetMapping("/consumer/feign/payment/getByTradeNo")
    public CommonResultVo<?> getByTradeNo(String tradeNo) {
        return paymentFeignService.getByTradeNo(tradeNo);
    }

}

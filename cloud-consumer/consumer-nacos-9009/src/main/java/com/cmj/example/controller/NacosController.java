package com.cmj.example.controller;

import com.cmj.example.service.IPaymentFeignService;
import com.cmj.example.vo.CommonResultVo;
import com.cmj.example.vo.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/14
 */
@RestController
@RequestMapping("/consumer/nacos")
public class NacosController {

    @Autowired
    private IPaymentFeignService paymentFeignService;

    @GetMapping("/getByTradeNo")
    public CommonResultVo<?> getByTradeNo(String tradeNo) {
        return paymentFeignService.getByTradeNo(tradeNo);
    }

}

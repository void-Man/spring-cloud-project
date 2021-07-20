package com.cmj.example.controller;

import com.cmj.example.vo.CommonResultVo;
import com.cmj.example.vo.PaymentDto;
import com.google.common.collect.ImmutableBiMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/14
 */
@RestController
public class OrderController {

    public static final String PaymentSrv_URL = "http://provider-payment-eureka";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consumer/ribbon/payment/create")
    public CommonResultVo<?> create(@RequestBody PaymentDto paymentDto) {
        return restTemplate.postForObject(PaymentSrv_URL + "/eureka/payment/create", paymentDto, CommonResultVo.class);
    }

    @GetMapping("/consumer/ribbon/payment/getByTradeNo")
    public CommonResultVo<?> create(String tradeNo) {
        return restTemplate.getForObject(PaymentSrv_URL + "/eureka/payment/getByTradeNo?tradeNo={tradeNo}", CommonResultVo.class, ImmutableBiMap.<String, Object>builder().put("tradeNo", tradeNo).build());
    }

}

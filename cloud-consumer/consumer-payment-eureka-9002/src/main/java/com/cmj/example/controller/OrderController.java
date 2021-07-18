package com.cmj.example.controller;

import com.cmj.example.vo.CommonResultVo;
import com.cmj.example.vo.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/14
 */
@RestController
public class OrderController {

    public static final String PaymentSrv_URL = "http://localhost:8002";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consumer/eureka/payment/create")
    public CommonResultVo<?> create(@RequestBody PaymentDto paymentDto) {
        return restTemplate.postForObject(PaymentSrv_URL + "/eureka/payment/create", paymentDto, CommonResultVo.class);
    }

}

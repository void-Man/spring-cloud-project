package com.cmj.example.controller;

import com.cmj.example.service.OrderService;
import com.cmj.example.vo.CommonResultVo;
import com.cmj.example.vo.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
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

    public static final String PaymentSrv_URL = "http://localhost:8001";

    @Autowired
    private OrderService orderService;

    @PostMapping("/forest/payment/create")
    public CommonResultVo<?> create(@RequestBody PaymentDto paymentDto) {
        return orderService.create(PaymentSrv_URL , "/payment/create", paymentDto);
    }

}

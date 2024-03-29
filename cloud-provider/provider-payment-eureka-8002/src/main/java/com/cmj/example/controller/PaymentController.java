package com.cmj.example.controller;

import com.cmj.example.IPaymentService;
import com.cmj.example.vo.CommonResultVo;
import com.cmj.example.vo.PaymentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/12
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private IPaymentService paymentService;

    @PostMapping("/eureka/payment/create")
    @ResponseBody
    public CommonResultVo<?> create(@RequestBody PaymentDto paymentDto) {
        int result = paymentService.create(paymentDto.getTradeNo(), paymentDto.getAmount());
        if (result > 0) {
            return CommonResultVo.builder()
                    .code(200)
                    .msg("成功")
                    .data("")
                    .build();
        } else {
            return CommonResultVo.builder()
                    .code(-1)
                    .data("")
                    .msg("创建账单失败")
                    .build();
        }
    }

}

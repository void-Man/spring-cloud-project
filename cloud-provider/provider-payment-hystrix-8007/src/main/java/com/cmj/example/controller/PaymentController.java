package com.cmj.example.controller;

import com.cmj.example.IPaymentService;
import com.cmj.example.vo.CommonResultVo;
import com.cmj.example.vo.PaymentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

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
                    .msg("into PaymentController 8007")
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

    @GetMapping("/eureka/payment/getByTradeNo")
    @ResponseBody
    public CommonResultVo<?> getByTradeNo(String tradeNo) {
        PaymentDto paymentDto = paymentService.getByTradeNo(tradeNo);
        if (Objects.nonNull(paymentDto)) {
            return CommonResultVo.builder()
                    .code(200)
                    .msg("into PaymentController 8007")
                    .data(paymentDto)
                    .build();
        } else {
            return CommonResultVo.builder()
                    .code(-1)
                    .data("")
                    .msg("获取账单失败")
                    .build();
        }
    }

    @GetMapping("/eureka/payment/getCircuitBreaker")
    @ResponseBody
    public CommonResultVo<?> getCircuitBreaker(String tradeNo) throws InterruptedException {
        PaymentDto paymentDto = paymentService.getCircuitBreaker(tradeNo);
        if (Objects.nonNull(paymentDto)) {
            return CommonResultVo.builder()
                    .code(200)
                    .msg("into PaymentController 8007")
                    .data(paymentDto)
                    .build();
        } else {
            return CommonResultVo.builder()
                    .code(-1)
                    .data("")
                    .msg("获取账单失败")
                    .build();
        }
    }

}

package com.cmj.example.controller;

import com.cmj.example.IPaymentService;
import com.cmj.example.vo.CommonResultVo;
import com.cmj.example.vo.PaymentDto;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
@DefaultProperties(defaultFallback = "defaultFallback")
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
                    .msg("into PaymentController 8006")
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
                    .msg("into PaymentController 8006")
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

    @GetMapping("/eureka/payment/getByTradeNoTimeout")
    @ResponseBody
    @HystrixCommand(defaultFallback = "methodtFallback")
    public CommonResultVo<?> getByTradeNoTimeout(String tradeNo) throws InterruptedException {
        PaymentDto paymentDto = paymentService.getByTradeNoTimeout(tradeNo);
        if (Objects.nonNull(paymentDto)) {
            return CommonResultVo.builder()
                    .code(200)
                    .msg("into PaymentController 8006")
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

    public CommonResultVo<?> defaultFallback() {
        return CommonResultVo.builder()
                .code(-1)
                .data("")
                .msg("8006.defaultFallback-----请求失败，请稍后再试")
                .build();
    }

    public CommonResultVo<?> methodtFallback() {
        return CommonResultVo.builder()
                .code(-1)
                .data("")
                .msg("8006.methodtFallback-----请求失败，请稍后再试")
                .build();
    }

}

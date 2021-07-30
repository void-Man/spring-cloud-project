package com.cmj.example.controller;

import com.cmj.example.IPaymentService;
import com.cmj.example.vo.CommonResultVo;
import com.cmj.example.vo.PaymentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("/nacos")
public class PaymentController {

    @Resource
    private IPaymentService paymentService;

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/getByTradeNo")
    @ResponseBody
    public CommonResultVo<?> getByTradeNo(String tradeNo) {
        PaymentDto paymentDto = paymentService.getByTradeNo(tradeNo);
        if (Objects.nonNull(paymentDto)) {
            return CommonResultVo.builder()
                    .code(200)
                    .msg("into PaymentController " + port)
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

package com.cmj.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cmj.example.IPaymentService;
import com.cmj.example.sentinel.handler.CustomerHandler;
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
@RequestMapping("/sentinel")
public class PaymentController {

    @Resource
    private IPaymentService paymentService;

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/getByTradeNo")
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

    @GetMapping("/getByPayId")
    public CommonResultVo<?> getByPayId(Integer payId) {
        PaymentDto paymentDto = paymentService.getByPayId(payId);
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

    @GetMapping("/getByPayIdTimeout")
    public CommonResultVo<?> getByPayIdTimeout(Integer payId) throws InterruptedException {
        PaymentDto paymentDto = paymentService.getByPayIdTimeout(payId);
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

    @GetMapping("/getByPayIdException")
    public CommonResultVo<?> getByPayIdException(Integer payId) {
        PaymentDto paymentDto = paymentService.getByPayIdException(payId);
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

    @GetMapping("/getByTradeNoWithResource")
    @SentinelResource(value = "getByTradeNoWithResource", blockHandlerClass = CustomerHandler.class, blockHandler = "dealHandler_getByTradeNoWithResource")
    public CommonResultVo<?> getPayment(String tradeNo) {
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

    /*@GetMapping("/getPayment")
    @SentinelResource(value = "getPayment", blockHandler = "dealHandler_getByIdHotKey")
    public CommonResultVo<?> getPayment(Integer payId, String tradeNo) {
        PaymentDto paymentDto = paymentService.getPayment(payId, tradeNo);
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

    public CommonResultVo<?> dealHandler_getByIdHotKey(Integer payId, String tradeNo, BlockException exception) {
        Map<String, Object> map = MapBuilder.<String, Object>create()
                .put("port", port)
                .put("payId", payId)
                .put("tradeNo", tradeNo)
                .put("msg", "HotKey Exception")
                .build();
        return CommonResultVo.builder()
                .code(-1)
                .data(map)
                .msg("获取账单失败")
                .build();
    }*/
}

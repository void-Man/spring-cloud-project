package com.cmj.example;

import com.cmj.example.vo.PaymentDto;

import java.math.BigDecimal;

public interface IPaymentService {
    /**
     * 创建账单
     * @author mengjie_chen
     * @date 2021/7/12
     * @param tradeNo
     * @param amount
     * @return int
     */
    int create(String tradeNo, BigDecimal amount);

    PaymentDto getByTradeNo(String tradeNo);

    PaymentDto getByTradeNoTimeout(String tradeNo) throws InterruptedException;

    default PaymentDto getCircuitBreaker(String tradeNo) {
        return null;
    }
}

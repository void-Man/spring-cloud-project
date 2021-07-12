package com.cmj.example;

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
}
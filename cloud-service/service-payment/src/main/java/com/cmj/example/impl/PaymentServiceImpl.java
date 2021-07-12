package com.cmj.example.impl;

import com.cmj.example.IPaymentService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/12
 */
@Service
public class PaymentServiceImpl implements IPaymentService {
    @Override
    public int create(String tradeNo, BigDecimal amount) {
        return 0;
    }
}

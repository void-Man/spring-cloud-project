package com.cmj.example.impl;

import com.cmj.example.IPaymentService;
import com.cmj.example.base.EbuyPaymentBase;
import com.cmj.example.mapper.EbuyPaymentBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/12
 */
@Service
public class PaymentServiceImpl implements IPaymentService {

    @Autowired
    private EbuyPaymentBaseMapper ebuyPaymentBaseMapper;

    @Override
    public int create(String tradeNo, BigDecimal amount) {
        return ebuyPaymentBaseMapper.insertSelective(EbuyPaymentBase.builder().tradeNo(tradeNo).amount(amount).build());
    }
}

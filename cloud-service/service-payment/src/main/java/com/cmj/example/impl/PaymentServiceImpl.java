package com.cmj.example.impl;

import com.cmj.example.IPaymentService;
import com.cmj.example.base.EbuyPaymentBase;
import com.cmj.example.base.EbuyPaymentBaseExample;
import com.cmj.example.mapper.EbuyPaymentBaseMapper;
import com.cmj.example.vo.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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

    @Override
    public PaymentDto getByTradeNo(String tradeNo) {
        EbuyPaymentBase ebuyPaymentBase = ebuyPaymentBaseMapper.selectOneByExample(new EbuyPaymentBaseExample().createCriteria()
                .andTradeNoEqualTo(tradeNo)
                .andIsDeleteEqualTo(0)
                .example());
        return PaymentDto.builder()
                .tradeNo(ebuyPaymentBase.getTradeNo())
                .amount(ebuyPaymentBase.getAmount())
                .build();
    }
}

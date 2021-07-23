package com.cmj.example.service;

import com.cmj.example.IPaymentService;
import com.cmj.example.base.EbuyPaymentBase;
import com.cmj.example.base.EbuyPaymentBaseExample;
import com.cmj.example.mapper.EbuyPaymentBaseMapper;
import com.cmj.example.vo.PaymentDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/23
 */
@Service
public class PaymentHystrixService implements IPaymentService {

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

    @Override
    public PaymentDto getByTradeNoTimeout(String tradeNo) throws InterruptedException {
        Thread.sleep(5000);
        EbuyPaymentBase ebuyPaymentBase = ebuyPaymentBaseMapper.selectOneByExample(new EbuyPaymentBaseExample().createCriteria()
                .andTradeNoEqualTo(tradeNo)
                .andIsDeleteEqualTo(0)
                .example());
        return PaymentDto.builder()
                .tradeNo(ebuyPaymentBase.getTradeNo())
                .amount(ebuyPaymentBase.getAmount())
                .build();
    }

    @Override
    @HystrixCommand(fallbackMethod = "getCircuitBreakerFallback", commandProperties = {
            // 开启器断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            // 请求总数阈值，总数超过这个次数才进行熔断判断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 时间窗口大小
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            // 错误率超过多少就开启熔断器
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    })
    public PaymentDto getCircuitBreaker(String tradeNo) {
        if (Long.parseLong(tradeNo) < 0L) {
            throw new RuntimeException("交易流水号不能为负数！！！");
        }
        EbuyPaymentBase ebuyPaymentBase = ebuyPaymentBaseMapper.selectOneByExample(new EbuyPaymentBaseExample().createCriteria()
                .andTradeNoEqualTo(tradeNo)
                .andIsDeleteEqualTo(0)
                .example());
        return PaymentDto.builder()
                .tradeNo(ebuyPaymentBase.getTradeNo())
                .amount(ebuyPaymentBase.getAmount())
                .build();
    }

    public PaymentDto getCircuitBreakerFallback(String tradeNo) {
        return PaymentDto.builder()
                .tradeNo(tradeNo + "----->8007.getCircuitBreakerFallback.获取账单失败")
                .amount(BigDecimal.ZERO)
                .build();
    }
}

package com.cmj.example.service.impl;

import com.cmj.example.service.IPaymentFeignService;
import com.cmj.example.vo.CommonResultVo;
import com.cmj.example.vo.PaymentDto;
import org.springframework.stereotype.Component;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/22
 */
@Component
public class PaymentHystrixService implements IPaymentFeignService {
    @Override
    public CommonResultVo<?> create(PaymentDto paymentDto) {
        return CommonResultVo.builder().code(-1).msg("create----->服务调用失败，请稍后再试").build();
    }

    @Override
    public CommonResultVo<?> getByTradeNo(String tradeNo) {
        return CommonResultVo.builder().code(-1).msg("getByTradeNo----->服务调用失败，请稍后再试").build();

    }

    @Override
    public CommonResultVo<?> getByTradeNoTimeout(String tradeNo) {
        return CommonResultVo.builder().code(-1).msg("getByTradeNoTimeout----->服务调用失败，请稍后再试").build();

    }
}

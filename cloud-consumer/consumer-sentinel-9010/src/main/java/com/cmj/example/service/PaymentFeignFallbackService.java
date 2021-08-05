package com.cmj.example.service;

import com.cmj.example.vo.CommonResultVo;
import org.springframework.stereotype.Component;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/8/4
 */
@Component
public class PaymentFeignFallbackService implements IPaymentFeignService {
    @Override
    public CommonResultVo<?> getByTradeNo(String tradeNo) {
        return CommonResultVo.builder()
                .code(-1)
                .data(tradeNo)
                .msg("调用远程接口失败")
                .build();
    }
}

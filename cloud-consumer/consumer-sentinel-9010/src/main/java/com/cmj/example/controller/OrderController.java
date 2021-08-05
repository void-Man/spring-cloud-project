package com.cmj.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cmj.example.sentinel.handler.CustomerBlockHandler;
import com.cmj.example.sentinel.handler.CustomerFallbackHandler;
import com.cmj.example.service.IPaymentFeignService;
import com.cmj.example.vo.CommonResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/14
 */
@RestController
@RequestMapping("/consumer/sentinel")
public class OrderController {

    @Autowired
    private IPaymentFeignService paymentFeignService;

    /**
     * 测试只配置了BlockHandler
     *
     * @param tradeNo
     * @return com.cmj.example.vo.CommonResultVo<?>
     * @author mengjie_chen
     * @date 2021/8/4
     */
    @GetMapping("/getByTradeNoBlock")
    @SentinelResource(value = "getByTradeNoBlock", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "getByTradeNoBlock", exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResultVo<?> getByTradeNoBlock(String tradeNo) {
        throw new IllegalArgumentException("getByTradeNoBlock 抛出运行时异常");
//        return paymentFeignService.getByTradeNo(tradeNo);
    }

    /**
     * 测试只配置了Fallback
     *
     * @param tradeNo
     * @return com.cmj.example.vo.CommonResultVo<?>
     * @author mengjie_chen
     * @date 2021/8/4
     */
    @GetMapping("/getByTradeNoFallback")
    @SentinelResource(value = "getByTradeNoFallback", fallbackClass = CustomerFallbackHandler.class, fallback = "getByTradeNoFallback")
    public CommonResultVo<?> getByTradeNoFallback(String tradeNo) {
        throw new RuntimeException("getByTradeNoFallback 抛出运行时异常");
//        return paymentFeignService.getByTradeNo(tradeNo);
    }

    /**
     * 测试同时配置了BlockHandler和Fallback
     *
     * @param tradeNo
     * @return com.cmj.example.vo.CommonResultVo<?>
     * @author mengjie_chen
     * @date 2021/8/4
     */
    @GetMapping("/getByTradeNoFallbackAndBlock")
    @SentinelResource(value = "getByTradeNoFallbackAndBlock", fallbackClass = CustomerFallbackHandler.class, fallback = "getByTradeNoFallback",
            blockHandlerClass = CustomerBlockHandler.class, blockHandler = "getByTradeNoBlock")
    public CommonResultVo<?> getByTradeNoFallbackAndBlock(String tradeNo) {
        return paymentFeignService.getByTradeNo(tradeNo);
    }

}

package com.cmj.example.sentinel.handler;

import cn.hutool.core.map.MapBuilder;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cmj.example.vo.CommonResultVo;

import java.util.Map;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/8/4
 */
public class CustomerBlockHandler {

    public static CommonResultVo<?> getByTradeNoBlock(String tradeNo, BlockException exception) {
        Map<String, Object> map = MapBuilder.<String, Object>create()
                .put("tradeNo", tradeNo)
                .put("msg", "获取账单降级异常，请稍后再试")
                .build();
        return CommonResultVo.builder()
                .code(-1)
                .data(map)
                .msg("获取账单失败")
                .build();
    }

}

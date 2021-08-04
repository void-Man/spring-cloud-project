package com.cmj.example.sentinel.handler;

import cn.hutool.core.map.MapBuilder;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cmj.example.vo.CommonResultVo;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/8/4
 */
@Component
public class CustomerHandler {

    public static CommonResultVo<?> dealHandler_getByTradeNoWithResource(String tradeNo, BlockException exception) {
        Map<String, Object> map = MapBuilder.<String, Object>create()
                .put("tradeNo", tradeNo)
                .put("msg", exception.getMessage())
                .build();
        return CommonResultVo.builder()
                .code(-1)
                .data(map)
                .msg("获取账单失败")
                .build();
    }

}

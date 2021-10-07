package com.cmj.example.service;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.map.MapBuilder;
import com.cmj.example.http.ForestHttp;
import com.cmj.example.vo.CommonResultVo;
import com.cmj.example.vo.PaymentDto;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/10/7
 */
@Component
public class OrderService {

    @Resource
    private ForestHttp forestHttp;

    public CommonResultVo<?> create(String url, String uri, PaymentDto paymentDto) {
        paymentDto.setTradeNo(new Snowflake().nextIdStr());
        return forestHttp.create(url + uri, MapBuilder.<String, Object>create().build(), paymentDto);
    }
}

package com.cmj.example.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cmj.example.vo.CommonResultVo;
import com.cmj.example.vo.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/14
 */
@RestController
public class OrderController {

    public static final String PaymentSrv_URL = "http://localhost:8003";

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/consumer/eureka/payment/create")
    public CommonResultVo<?> create(@RequestBody PaymentDto paymentDto) {
        return restTemplate.postForObject(PaymentSrv_URL + "/eureka/payment/create", paymentDto, CommonResultVo.class);
    }

    /**
     * 拿到指定服务ID的服务信息（可用于自己实现本地负载均衡）
     *
     * @param
     * @return java.lang.Object
     * @author mengjie_chen
     * @date 2021/7/18
     */
    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<ServiceInstance> instances = discoveryClient.getInstances("PROVIDER-PAYMENT-EUREKA");
        JSONArray array = new JSONArray();
        for (ServiceInstance element : instances) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("serviceId", element.getServiceId());
            jsonObject.put("host", element.getHost());
            jsonObject.put("port", element.getPort());
            jsonObject.put("uri", element.getUri());
            array.add(jsonObject);
        }
        return array.toJSONString();
    }


}

package com.cmj.example.interceptor;

import cn.hutool.core.lang.UUID;
import com.alibaba.fastjson.JSONObject;
import com.dtflys.forest.exceptions.ForestRuntimeException;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;
import com.dtflys.forest.reflection.ForestMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/10/7
 */
@Component
@Slf4j
public class ForestRequestInterceptor<Object> implements Interceptor<Object> {

    @Override
    public void onInvokeMethod(ForestRequest request, ForestMethod method, java.lang.Object[] args) {
        String groupId = UUID.randomUUID().toString(true);
        // 添加Attribute
        addAttribute(request, "groupId", groupId);
        log.info("rpc groupId :{} -----> url :url={}", groupId, request.getUrl());
        log.info("rpc groupId :{} -----> headers :headers={}", groupId, JSONObject.toJSONString(request.getHeaders()));
        log.info("rpc groupId :{} -----> param :param={}", groupId, JSONObject.toJSONString(request.getBody()));
    }

    @Override
    public void onSuccess(Object data, ForestRequest request, ForestResponse response) {
        String groupId = getAttribute(request, "groupId", String.class);
        log.info("onSuccess rpc groupId :{} -----> resp :{}", groupId, response.getContent());
    }

    @Override
    public void onError(ForestRuntimeException ex, ForestRequest request, ForestResponse response) {
        String groupId = getAttribute(request, "groupId", String.class);
        log.info("onError rpc groupId :{} -----> resp :{}", groupId, response.getContent());
        log.info("onError rpc groupId :{} -----> exception :{}", groupId, ex.toString());
    }

    @Override
    public void onRetry(ForestRequest request, ForestResponse response) {
        String groupId = getAttribute(request, "groupId", String.class);
        log.info("onRetry rpc groupId :{} -----> url :url={}", groupId, request.getUrl());
    }
}

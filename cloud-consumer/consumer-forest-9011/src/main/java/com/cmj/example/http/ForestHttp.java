package com.cmj.example.http;

import com.cmj.example.interceptor.ForestRequestInterceptor;
import com.cmj.example.vo.CommonResultVo;
import com.cmj.example.vo.PaymentDto;
import com.dtflys.forest.annotation.JSONBody;
import com.dtflys.forest.annotation.PostRequest;
import com.dtflys.forest.annotation.Query;
import com.dtflys.forest.annotation.Var;

import java.util.Map;

/**
 * @description
 * @date 2021/9/27 5:42 下午
 */
public interface ForestHttp {

    @PostRequest(url = "${url}", interceptor = ForestRequestInterceptor.class)
    CommonResultVo<?> create(@Var("url") String url, @Query Map<String, Object> urlParam, @JSONBody PaymentDto req);

}

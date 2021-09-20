package com.cmj.example.handler;

import com.alibaba.fastjson.JSONObject;
import com.cmj.example.exception.BusinessException;
import com.cmj.example.vo.CommonResultVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/9/21
 */
@ControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String handleHttpException(Exception e) {
        return JSONObject.toJSONString(CommonResultVo.<String>builder().msg(e.getMessage()).code(500).build());
    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public String handleBusinessException(Exception e) {
        return JSONObject.toJSONString(CommonResultVo.<String>builder().msg(e.getMessage()).code(10000).build());
    }
}

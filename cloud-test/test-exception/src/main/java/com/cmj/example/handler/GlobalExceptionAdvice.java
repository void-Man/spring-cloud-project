package com.cmj.example.handler;

import com.alibaba.fastjson.JSONObject;
import com.cmj.example.exception.BusinessException;
import com.cmj.example.vo.CommonResultVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/9/21
 */
@ControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = Exception.class)
    public void handleHttpException(HttpServletResponse response, Exception e) throws IOException {
        response.getWriter().write(JSONObject.toJSONString(CommonResultVo.<String>builder().msg(e.getMessage()).code(500).build()));
    }

    @ExceptionHandler(value = BusinessException.class)
    public void handleBusinessException(HttpServletResponse response, Exception e) throws IOException {
        response.getWriter().write(JSONObject.toJSONString(CommonResultVo.<String>builder().msg(e.getMessage()).code(10000).build()));
    }
}

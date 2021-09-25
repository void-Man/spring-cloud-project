package com.cmj.example.vo;

import com.cmj.example.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/9/25
 */
@Slf4j
public class ExceptionUtil {

    public static BusinessException throwBusinessException(Integer code, String msg) {
        log.error("业务异常：{} -----> {}", code, msg);
        return new BusinessException(code, msg);
    }

}

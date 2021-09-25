package com.cmj.example.exception;

import lombok.Getter;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/9/21
 */
@Getter
public class BusinessException extends RuntimeException {

    private Integer code;
    private String msg;

    public BusinessException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}

package com.cmj.example.exception;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/9/21
 */
public class BusinessException extends RuntimeException {

    private String msg;

    public BusinessException(String msg) {
        super(msg);
        this.msg = msg;
    }
}

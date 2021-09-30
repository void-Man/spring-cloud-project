package com.cmj.example.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/10/1
 */
@Data
@Builder
public class TaskResultVo {

    private int code;

    private String msg;

}

package com.cmj.example.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonResultVo<T> implements Serializable {

    private Integer code = 200;
    private String msg = "";
    private T data;

}

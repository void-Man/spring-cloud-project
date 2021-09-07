package com.cmj.example.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @description
 * @date 2021/9/2 9:26 下午
 */
@Data
@Builder
public class UserParam {
    private String userId;
    private String userName;
    private int age;
}

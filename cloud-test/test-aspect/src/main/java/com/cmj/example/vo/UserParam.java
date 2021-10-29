package com.cmj.example.vo;

import com.cmj.example.jsr303.ListContains;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * @description
 * @date 2021/9/2 9:26 下午
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserParam {
    @NotEmpty(message = "用户ID不能为空")
    private String userId;
    @NotEmpty(message = "用户姓名不能为空")
    private String userName;
    @ListContains(listVals = {"e", "t", "s"})
    private String userJob;
    private Integer num;
}

package com.cmj.example.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/7/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDto implements Serializable {

    private String tradeNo;
    private BigDecimal amount;

}

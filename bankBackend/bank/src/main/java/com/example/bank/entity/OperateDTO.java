package com.example.bank.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OperateDTO {
    private Long id;

    /**
     * 0 add
     * 1 sub
     */
    private Integer operate;

    private Double amount;
}

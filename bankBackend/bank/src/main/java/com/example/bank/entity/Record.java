package com.example.bank.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.example.bank.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Administrator
 * @since 2022-05-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Record extends BaseEntity {

    private static final long serialVersionUID=1L;

    private Integer operation;

    private Double amount;

    private Double balance;

    private Long accountId;

    @TableField(exist = false)
    private String dateStr;
}

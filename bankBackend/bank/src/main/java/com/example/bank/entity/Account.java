package com.example.bank.entity;

import com.example.bank.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class Account extends BaseEntity {

    private static final long serialVersionUID=1L;

    private String number;

    private String passWord;

    private Double balance;

    private String nickName;


}

package com.example.bank.service;

import com.example.bank.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bank.entity.OperateDTO;

/**
 * <p>
 *  Service Class
 * </p>
 *
 * @author Administrator
 * @since 2022-05-22
 */
public interface AccountService extends IService<Account> {

    /**
     * Login
     * @param account
     * @return
     */
    Account login(Account account);

    /**
     * register
     * @param account
     * @return
     */
    Account register(Account account);

    /**
     * Operation save/get
     * @param operateDTO
     * @return
     */
    Account operate(OperateDTO operateDTO);
}

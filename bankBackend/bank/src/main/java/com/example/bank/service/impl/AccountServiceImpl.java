package com.example.bank.service.impl;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.log.StaticLog;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bank.entity.Account;
import com.example.bank.entity.OperateDTO;
import com.example.bank.entity.Record;
import com.example.bank.mapper.AccountMapper;
import com.example.bank.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bank.service.RecordService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Random;

/**
 * <p>
 * service implementation
 * </p>
 *
 * @author Administrator
 * @since 2022-05-22
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Autowired
    private RecordService recordService;

    /**
     * Login
     * @param account
     * @return
     */
    @Override
    public Account login(Account account) {
        if (StringUtils.isBlank(account.getNumber()) || StringUtils.isBlank(account.getPassWord())) {
            throw new IllegalArgumentException("Input Error!");
        }

        StaticLog.info("Login: {}", account);
        Account one = getOne(new QueryWrapper<Account>().eq("number", account.getNumber()).eq("pass_word", account.getPassWord()));
        Assert.notNull(one, "Login Failed, Number Or PassWord Error!");
        return one;
    }

    /**
     * Register
     * @param account
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Account register(Account account) {
        if (StringUtils.isBlank(account.getNickName()) || StringUtils.isBlank(account.getPassWord())) {
            throw new IllegalArgumentException("Input Error!");
        }

        Account saveObj = new Account();
        saveObj.setNumber(getAccountNumber())
                .setBalance(0.00)
                .setNickName(account.getNickName())
                .setPassWord(account.getPassWord())
                .preInsert();
        boolean save = save(saveObj);

        StaticLog.info("Do Register,Result: {}, Number: {}", save, saveObj.getNumber());
        Assert.isTrue(save, "Register Failed");

        return new Account().setNumber(saveObj.getNumber()).setNickName(account.getNickName());
    }

    /**
     * operation save/get
     * @param dto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized Account operate(OperateDTO dto) {
        StaticLog.info("Operate: {}", dto);
        Account byId = getById(dto.getId());
        Record record = new Record();
        if (dto.getOperate() == 0) {
            byId.setBalance(NumberUtil.add(byId.getBalance(), dto.getAmount()));
        } else {
            Assert.isTrue(NumberUtil.sub(byId.getBalance(), dto.getAmount()) > 0, "Balance can not less than Zero");
            byId.setBalance(NumberUtil.sub(byId.getBalance(), dto.getAmount()));
        }

        record.setAmount(dto.getAmount())
                .setOperation(dto.getOperate())
                .setAccountId(byId.getId())
                .setBalance(byId.getBalance())
                .preInsert();

        recordService.save(record);
        boolean b = updateById(byId);
        Assert.isTrue(b, "Update Your Account Failed!");

        return getById(dto.getId());
    }

    /**
     * Generate 18-digit card number without repetition
     * @return
     */
    private synchronized String getAccountNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 18; i++) {
            int n = new Random().nextInt(10);
            if (sb.length() == 0 && n == 0) {
                n++;
            }
            sb.append(n);
        }
        String number = sb.toString();
        List<Account> list = list(new QueryWrapper<Account>().eq("number", number));
        if (list.size() > 0) {
            return getAccountNumber();
        } else {
            return number;
        }
    }
}

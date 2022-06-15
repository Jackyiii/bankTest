package com.example.bank.service.impl;

import com.example.bank.entity.Account;
import com.example.bank.entity.OperateDTO;
import com.example.bank.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class AccountServiceImplTest {

    @Resource
    private AccountService accountService;

    @Test
    void login() {
        Account acc=new Account();
        acc.setNumber("139843233695072716");
        acc.setPassWord("aaa");
        Account ac= this.accountService.login(acc);
        System.out.println(ac);
    }

    @Test
    void register() {
        Account acc=new Account();
        acc.setNickName("yi");
        acc.setPassWord("aaa");
        Account ac= this.accountService.register(acc);
        System.out.println(ac);
    }

    @Test
    void operate() {
        OperateDTO op=new OperateDTO();
        op.setOperate(0);
        op.setId(16L);
        Account ac= this.accountService.operate(op);
        System.out.println(ac);
        op.setOperate(1);
        //数据库account  余额大于零的数据进行测试 Test account if balance > 0 data to test
        Account acs= this.accountService.operate(op);
        System.out.println(acs);
    }


}
package com.example.bank.controller;


import com.example.bank.common.R;
import com.example.bank.entity.Account;
import com.example.bank.entity.OperateDTO;
import com.example.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  Frontend Controller
 * </p>
 *
 * @author Administrator
 * @since 2022-05-22
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public R login(@RequestBody Account account) {
        return R.success(accountService.login(account));
    }

    @PostMapping("/register")
    public R register(@RequestBody Account account) {
        return R.success(accountService.register(account));
    }

    @GetMapping("/getOne/{id}")
    public R getOne(@PathVariable("id") Long id) {
        return R.success(accountService.getById(id));
    }

    @PostMapping("/operate")
    public R operate(@RequestBody OperateDTO operateDTO) {
        Account account = accountService.operate(operateDTO);
        return R.success(account);
    }
}


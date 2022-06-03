package com.example.bank.controller;


import com.example.bank.common.R;
import com.example.bank.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器Frontend Controller
 * </p>
 *
 * @author Administrator
 * @since 2022-05-22
 */
@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    private RecordService recordService;

    @GetMapping("/getList/{id}")
    public R getList(@PathVariable("id") Long id) {
        return R.success(recordService.getRecordListByAccountId(id));
    }
}


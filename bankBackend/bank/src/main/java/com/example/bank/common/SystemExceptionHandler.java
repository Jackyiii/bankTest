package com.example.bank.common;

import cn.hutool.log.StaticLog;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常捕获
 */
@RestControllerAdvice
public class SystemExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public R exceptionHandler(Exception e) {
        StaticLog.info("{}", e);
        return R.failed(e.getMessage());
    }
}

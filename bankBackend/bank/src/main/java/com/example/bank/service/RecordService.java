package com.example.bank.service;

import com.example.bank.entity.OperateDTO;
import com.example.bank.entity.Record;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  Service
 * </p>
 *
 * @author Administrator
 * @since 2022-05-22
 */
public interface RecordService extends IService<Record> {

    /**
     * Get the list of operation records based on AccountId
     * @param accountId
     * @return
     */
    List<Record> getRecordListByAccountId(Long accountId);
}

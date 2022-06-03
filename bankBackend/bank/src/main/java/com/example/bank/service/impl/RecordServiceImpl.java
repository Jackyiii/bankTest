package com.example.bank.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bank.entity.Record;
import com.example.bank.mapper.RecordMapper;
import com.example.bank.service.RecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * service implementation
 * </p>
 *
 * @author Administrator
 * @since 2022-05-22
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements RecordService {

    /**
     * Get the list of operation records based on AccoundId
     * @param accountId
     * @return
     */
    @Override
    public List<Record> getRecordListByAccountId(Long accountId) {
        List<Record> list = list(new QueryWrapper<Record>().eq("account_id", accountId).orderByDesc("create_date"));
        for (Record record : list) {
            record.setDateStr(DateUtil.formatDateTime(record.getCreateDate()));
        }
        return list;
    }
}

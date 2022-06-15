package com.example.bank.service.impl;

import com.example.bank.entity.Record;
import com.example.bank.service.RecordService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RecordServiceImplTest {

    @Resource
    private RecordService recordService;
    @Test
    void getRecordListByAccountId() {
        List<Record> rc= this.recordService.getRecordListByAccountId(25L);
        for(Record r : rc){
            System.out.println(r);
        }
        System.out.println(rc.size());
    }
}
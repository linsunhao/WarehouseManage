package com.example.warehousemanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.warehousemanage.entity.Record;
import com.example.warehousemanage.mapper.RecordMapper;
import com.example.warehousemanage.service.RecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sun
 * @since 2024-04-09
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements RecordService {
    @Autowired
    private RecordMapper recordMapper;
    @Override
    public IPage<Record> listPage(IPage<Record> page, Wrapper<Record> wrapper) {
        return page.setRecords(recordMapper.Page(page,wrapper));
    }
}

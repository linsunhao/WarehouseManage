package com.example.warehousemanage.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.warehousemanage.entity.Record;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sun
 * @since 2024-04-09
 */
public interface RecordService extends IService<Record> {
    IPage<Record> listPage(IPage<Record> page, Wrapper<Record> wrapper);
}

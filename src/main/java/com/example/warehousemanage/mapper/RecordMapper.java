package com.example.warehousemanage.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.warehousemanage.entity.Goods;
import com.example.warehousemanage.entity.Record;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sun
 * @since 2024-04-09
 */
@Mapper
public interface RecordMapper extends BaseMapper<Record> {
    List<Record> Page(@Param("page") IPage<Record> page, @Param("ew") Wrapper<Record> queryWrapper);
}

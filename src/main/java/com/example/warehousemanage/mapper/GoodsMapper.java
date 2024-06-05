package com.example.warehousemanage.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.warehousemanage.entity.Goods;
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
public interface GoodsMapper extends BaseMapper<Goods> {
    List<Goods> Page(@Param("page") IPage<Goods> page,@Param("ew") Wrapper<Goods> queryWrapper);
}

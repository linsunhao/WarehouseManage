package com.example.warehousemanage.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.warehousemanage.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sun
 * @since 2024-04-09
 */
public interface GoodsService extends IService<Goods> {
    IPage<Goods> listPage(IPage<Goods> page, Wrapper<Goods> wrapper);
}
